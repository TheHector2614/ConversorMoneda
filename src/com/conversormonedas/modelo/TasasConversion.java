package com.conversormonedas.modelo;

import java.util.Map;

public record TasasConversion(Map<String, Double> tasas) {
    public double obtenerTasa(String codigoMoneda) {
        return tasas.getOrDefault(codigoMoneda, 0.0);
    }
}
