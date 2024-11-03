package gestorTareas;

import consola.Consola;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Consola consola = new Consola();
        Usuario usuario = new Usuario(consola, "Sebas");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            consola.imprimirTexto("Menú:", true);
            consola.imprimirTexto("1. Crear proyecto.", true);
            consola.imprimirTexto("2. Asignar tarea.", true);
            consola.imprimirTexto("3. Marcar tarea.", true);
            consola.imprimirTexto("4. Salir", true);
            consola.imprimirTexto("Elige una opción (1-4):", true);


            String input = scanner.nextLine();
            Integer opcion = null;

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            if (opcion != null) {
                switch (opcion) {
                    case 1:
                        usuario.crearProyecto();
                        break;
                    case 2:
                        usuario.asignarTarea();
                        break;
                    case 3:
                        usuario.cambiarEstadoTarea();
                        break;
                    case 4:
                        consola.imprimirTexto("Saliendo del menú. ¡Hasta luego!", true);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        return;
                    default:
                        consola.imprimirTexto("Opción no válida. Inténtalo de nuevo.", true);
                        break;
                }
            } else {
                consola.imprimirTexto("Opción no válida. Inténtalo de nuevo.", true);
            }
        }
    }
}