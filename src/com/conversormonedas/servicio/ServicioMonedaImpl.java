package com.conversormonedas.servicio;

import com.conversormonedas.modelo.TasasConversion;
import com.conversormonedas.util.Constantes;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

/**
 * Implementación de la interfaz ServicioMoneda.
 */
public class ServicioMonedaImpl implements ServicioMoneda {

    @Override
    public TasasConversion obtenerTasasConversion() {
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(URI.create(Constantes.API_URL))
                    .build();

            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonRespuesta = JsonParser.parseString(respuesta.body()).getAsJsonObject();
            return new TasasConversion(jsonRespuesta.getAsJsonObject("conversion_rates"));
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener las tasas de cambio: " + e.getMessage());
        }
    }

    @Override
    public double convertir(String monedaOrigen, String monedaDestino, double monto, TasasConversion tasas) {
        double tasaOrigen = tasas.obtenerTasa(monedaOrigen);
        double tasaDestino = tasas.obtenerTasa(monedaDestino);

        if (tasaOrigen == 0.0 || tasaDestino == 0.0) {
            throw new IllegalArgumentException("Moneda no soportada.");
        }

        return (monto / tasaOrigen) * tasaDestino;
    }
}
