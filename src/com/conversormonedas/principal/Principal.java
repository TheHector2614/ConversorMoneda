package com.conversormonedas.principal;

import com.conversormonedas.modelo.TasasConversion;
import com.conversormonedas.servicio.ServicioMoneda;
import com.conversormonedas.servicio.ServicioMonedaImpl;

import java.util.Scanner;

/**
 * Clase principal para interactuar con el usuario.
 */
public class Principal {
    public static void main(String[] args) {
        ServicioMoneda servicioMoneda = new ServicioMonedaImpl();
        Scanner scanner = new Scanner(System.in);

        try {
            // Obtener tasas de conversión
            TasasConversion tasas = servicioMoneda.obtenerTasasConversion();

            while (true) {
                // Mostrar menú
                System.out.println("****************************************");
                System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
                System.out.println("****************************************");
                System.out.println("1) Dólar => Peso argentino");
                System.out.println("2) Peso argentino => Dólar");
                System.out.println("3) Dólar => Real brasileño");
                System.out.println("4) Real brasileño => Dólar");
                System.out.println("5) Dólar => Peso colombiano");
                System.out.println("6) Peso colombiano => Dólar");
                System.out.println("7) Salir");
                System.out.println("****************************************");
                System.out.print("Elija una opción válida: ");

                int opcion = scanner.nextInt();

                if (opcion == 7) {
                    System.out.println("¡Gracias por usar el conversor! ¡Hasta pronto!");
                    break;
                }

                // Variables para monedas
                String monedaOrigen = "";
                String monedaDestino = "";
                double monto = 0;

                switch (opcion) {
                    case 1 -> {
                        monedaOrigen = "USD";
                        monedaDestino = "ARS";
                    }
                    case 2 -> {
                        monedaOrigen = "ARS";
                        monedaDestino = "USD";
                    }
                    case 3 -> {
                        monedaOrigen = "USD";
                        monedaDestino = "BRL";
                    }
                    case 4 -> {
                        monedaOrigen = "BRL";
                        monedaDestino = "USD";
                    }
                    case 5 -> {
                        monedaOrigen = "USD";
                        monedaDestino = "COP";
                    }
                    case 6 -> {
                        monedaOrigen = "COP";
                        monedaDestino = "USD";
                    }
                    default -> {
                        System.out.println("Opción no válida. Intente nuevamente.");
                        continue;
                    }
                }

                // Capturar el monto a convertir
                System.out.print("Ingrese el monto a convertir: ");
                monto = scanner.nextDouble();

                // Realizar conversión
                try {
                    double montoConvertido = servicioMoneda.convertir(monedaOrigen, monedaDestino, monto, tasas);
                    System.out.printf("Resultado: %.2f %s = %.2f %s%n",
                            monto, monedaOrigen, montoConvertido, monedaDestino);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
