package conversormonedas;

import java.util.Scanner;

public class Menu {
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Conversor de Monedas ---");
            System.out.println("1. Convertir ARS a otra moneda");
            System.out.println("2. Convertir otra moneda a ARS");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> converter.convertirDesdeARS();
                case 2 -> converter.convertirAHaciaARS();
                case 3 -> {
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                }
                default -> System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
    }
}
