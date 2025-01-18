package com.conversormonedas.modelo;

import com.google.gson.JsonObject;

/**
 * Record que representa las tasas de conversión obtenidas de la API.
 */
public record TasasConversion(JsonObject tasas) {
    public double obtenerTasa(String codigoMoneda) {
        return tasas.has(codigoMoneda) ? tasas.get(codigoMoneda).getAsDouble() : 0.0;
    }
}
