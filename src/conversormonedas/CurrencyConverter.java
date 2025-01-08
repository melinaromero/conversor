package conversormonedas;

import java.util.Scanner;

public class CurrencyConverter {
    private final ExchangeRateService service = new ExchangeRateService();

    public void convertirDesdeARS() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la moneda destino (USD, BOB, BRL, CLP, COP): ");
        String destino = scanner.nextLine().toUpperCase();

        ExchangeRateResponse tasas = service.obtenerTasasDeCambio("ARS");
        if (tasas != null && tasas.getConversion_rates().containsKey(destino)) {
            System.out.print("Ingresa la cantidad en ARS: ");
            double cantidad = scanner.nextDouble();
            double tasa = tasas.getConversion_rates().get(destino);
            System.out.println("Resultado: " + (cantidad * tasa) + " " + destino);
        } else {
            System.out.println("Moneda no válida o no encontrada.");
        }
    }

    public void convertirAHaciaARS() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la moneda origen (USD, BOB, BRL, CLP, COP): ");
        String origen = scanner.nextLine().toUpperCase();

        ExchangeRateResponse tasas = service.obtenerTasasDeCambio(origen);
        if (tasas != null && tasas.getConversion_rates().containsKey("ARS")) {
            System.out.print("Ingresa la cantidad en " + origen + ": ");
            double cantidad = scanner.nextDouble();
            double tasa = tasas.getConversion_rates().get("ARS");
            System.out.println("Resultado: " + (cantidad * tasa) + " ARS");
        } else {
            System.out.println("Moneda no válida o no encontrada.");
        }
    }
}
