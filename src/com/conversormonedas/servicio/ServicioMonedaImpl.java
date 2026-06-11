package com.conversormonedas.servicio;

import com.conversormonedas.modelo.ExchangeRateResponse;
import com.conversormonedas.modelo.TasasConversion;
import com.conversormonedas.util.Constantes;
import com.google.gson.Gson;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Map;

public class ServicioMonedaImpl implements ServicioMoneda {

    private final Gson gson = new Gson();

    @Override
    public TasasConversion obtenerTasasConversion() {
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(URI.create(Constantes.API_URL))
                    .build();

            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            ExchangeRateResponse response = gson.fromJson(respuesta.body(), ExchangeRateResponse.class);

            if (response == null || !"success".equals(response.result())) {
                throw new RuntimeException("La API respondió con error: " + (response != null ? response.result() : "null"));
            }

            Map<String, Double> tasas = response.conversionRates();
            if (tasas == null || tasas.isEmpty()) {
                throw new RuntimeException("No se recibieron tasas de conversión.");
            }

            return new TasasConversion(tasas);
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
