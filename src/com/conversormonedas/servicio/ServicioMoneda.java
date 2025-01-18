package com.conversormonedas.servicio;

import com.conversormonedas.modelo.TasasConversion;

/**
 * Interfaz para los servicios relacionados con las conversiones de moneda.
 */
public interface ServicioMoneda {
    TasasConversion obtenerTasasConversion();

    double convertir(String monedaOrigen, String monedaDestino, double monto, TasasConversion tasas);
}
