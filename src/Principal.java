import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ApiRequestHandler consulta = new ApiRequestHandler();
        Historial historial = new Historial();

        int opcion;
        System.out.println("**********************************************");
        System.out.println("Bienvenido al Conversor de Moneda\n");
        while (true) {
            System.out.println("**********************************************");
            System.out.println("1) Dolar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dolar ");
            System.out.println("3) Dolar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dolar ");
            System.out.println("5) Dolar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dolar ");
            System.out.println("7) Dolar =>> Peso Mexicano");
            System.out.println("8) Peso Mexicano =>> Dolar ");
            System.out.println("9) Ver Historial de Conversiones");
            System.out.println("10) Salir");
            System.out.println("Elija una opcion valida.");
            System.out.println("**********************************************");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1, 2, 3, 4, 5, 6, 7, 8:
                    try {
                        String monedaBase = obtenerMonedaBase(opcion);
                        String monedaDestino = obtenerMonedaDestino(opcion);
                        Moneda moneda = consulta.consultaMoneda(monedaBase);
                        System.out.println("Ingrese el valor en " + monedaBase + " que deseas convertir a " + monedaDestino);
                        double cantidad = teclado.nextDouble();
                        System.out.println("Conversión: ");
                        System.out.println("Valor ingresado: " + cantidad + " [" + monedaBase + "] Valor equivalente: " +
                                (moneda.obtenerTasaDeConversion(monedaDestino) * cantidad) + "[" + monedaDestino + "]\n");

                        // Agregar la conversión al historial
                        historial.agregarConversion(cantidad + " " + monedaBase + " => " +
                                (moneda.obtenerTasaDeConversion(monedaDestino) * cantidad) + " " + monedaDestino);

                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Usted a salido de la aplicación.");
                        System.exit(0);
                    }
                    break;

                case 9:
                    historial.mostrarHistorial();
                    break;
                case 10:
                    System.out.println("¡Hasta luego!");
                    teclado.close();
                    teclado.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida, seleccione una opción válida.");
            }


        }
    }


    private static String obtenerMonedaBase(int opcion) {
        switch (opcion) {
            case 1,3,5,7:
                return "USD";
            case 2:
                return "ARS";
            case 4:
                return "BRL";
            case 6:
                return "COP";
            case 8:
                return "MNX";
            default:
                throw new IllegalArgumentException("Opción no válida.");
        }
    }

    private static String obtenerMonedaDestino(int opcion) {
        switch (opcion) {
            case 2,4,6,8:
                return "USD";
            case 1:
                return "ARS";
            case 3:
                return "BRL";
            case 5:
                return "COP";
            case 7:
                return "MXN";
            default:
                throw new IllegalArgumentException("Opción no válida.");
        }
    }
}