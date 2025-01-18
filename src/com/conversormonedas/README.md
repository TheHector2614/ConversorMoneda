# Conversor de Monedas

Este proyecto es una aplicación Java que permite convertir montos entre diferentes monedas utilizando las tasas de cambio proporcionadas por la API [ExchangeRate-API](https://www.exchangerate-api.com/).

## Estructura del Proyecto
src/main/java/ └── com/ └── conversormonedas/ ├── modelo/ │ └── TasasConversion.java ├── servicio/ │ ├── ServicioMoneda.java │ └── ServicioMonedaImpl.java ├── util/ │ └── Constantes.java └── principal/ └── Principal.java


### Descripción de Paquetes y Clases

- **`com.conversormonedas.util.Constantes`**  
  Contiene constantes globales, como la URL de la API utilizada para obtener las tasas de cambio.

- **`com.conversormonedas.modelo.TasasConversion`**  
  Representa las tasas de conversión obtenidas de la API. Proporciona métodos para recuperar la tasa de una moneda específica.

- **`com.conversormonedas.servicio.ServicioMoneda`**  
  Interfaz que define los métodos para obtener las tasas de cambio y realizar conversiones de moneda.

- **`com.conversormonedas.servicio.ServicioMonedaImpl`**  
  Implementación de la interfaz `ServicioMoneda`. Maneja la lógica para interactuar con la API y realizar conversiones.

- **`com.conversormonedas.principal.Principal`**  
  Clase principal que interactúa con el usuario a través de la consola. Permite seleccionar monedas, ingresar montos y visualizar los resultados de la conversión.

## Funcionalidades

- Obtener tasas de cambio actualizadas desde la API de ExchangeRate.
- Realizar conversiones entre monedas seleccionadas.
- Monedas soportadas:
    - Dólar estadounidense (USD)
    - Peso argentino (ARS)
    - Real brasileño (BRL)
    - Peso colombiano (COP)

## Requisitos

- **Java 17** o superior.
- Conexión a Internet (para consultar las tasas de cambio).

## Instrucciones de Uso

1. Clona el repositorio o descarga los archivos.
2. Asegúrate de tener configurado un entorno de desarrollo Java (JDK 17 o superior).
3. Navega al directorio del proyecto y compila los archivos:
   ```bash
   javac src/main/java/com/conversormonedas/**/*.java

## Ejemplo de Uso

****************************************
Sea bienvenido/a al Conversor de Moneda =]
****************************************
1) Dólar => Peso argentino
2) Peso argentino => Dólar
3) Dólar => Real brasileño
4) Real brasileño => Dólar
5) Dólar => Peso colombiano
6) Peso colombiano => Dólar
7) Salir
****************************************
Elija una opción válida: 1
Ingrese el monto a convertir: 100
Resultado: 100.00 USD = 28700.00 ARS

## Créditos

Desarrollado por Hector Suarez.
Basado en la API de ExchangeRate-API.
    