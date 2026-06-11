package com.conversormonedas.util;

public final class Constantes {
    public static final String API_URL = "https://v6.exchangerate-api.com/v6/" + getApiKey() + "/latest/USD";

    private Constantes() {
    }

    private static String getApiKey() {
        String envKey = System.getenv("EXCHANGE_API_KEY");
        if (envKey != null && !envKey.isBlank()) {
            return envKey;
        }
        throw new IllegalStateException(
                "La variable de entorno EXCHANGE_API_KEY no está configurada. " +
                "Regístrate en https://www.exchangerate-api.com/ y obtén tu API key.");
    }
}
