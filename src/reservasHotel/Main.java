package reservasHotel;

import consola.Consola;

public class Main {
    public static void main(String[] args) {
        Consola consola = new Consola();
        GestorReservar gestorReservar = new GestorReservar(consola);

        while (true) {
            consola.imprimirTexto("Menú:", true);
            consola.imprimirTexto("1. Realizar reserva.", true);
            consola.imprimirTexto("2. Cancelar reserva.", true);
            consola.imprimirTexto("3. Mostrar reservas.", true);
            consola.imprimirTexto("4. Salir", true);
            consola.imprimirTexto("Elige una opción (1-4):", true);

            int opcion = consola.pedirEntero();
            switch (opcion) {
                case 1:
                    gestorReservar.realizarReserva();
                    break;
                case 2:
                    gestorReservar.cancelarReserva();
                    break;
                case 3:
                    gestorReservar.mostrarReservas();
                    break;
                case 4:
                    consola.imprimirTexto("Saliendo del menú. ¡Hasta luego!", true);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return;
                default:
                    consola.imprimirTexto("Opción no válida. Inténtalo de nuevo.", true);
                    break;
            }
        }
    }
}