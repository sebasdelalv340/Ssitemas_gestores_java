package gestorBiblioteca;

import consola.Consola;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Consola consola = new Consola(); // Crear instancia de consola.Consola
        Biblioteca gestorBiblioteca = new Biblioteca(consola); // Crear instancia de Biblioteca
        Scanner scanner = new Scanner(System.in); // Crear instancia de Scanner para entrada de usuario

        while (true) {
            consola.imprimirTexto("Menú:", true);
            consola.imprimirTexto("1. Registrar libro", true);
            consola.imprimirTexto("2. Registrar usuario", true);
            consola.imprimirTexto("3. Prestar libro", true);
            consola.imprimirTexto("4. Salir", true);
            consola.imprimirTexto("Elige una opción (1-4):", true);

            // Leer la opción del usuario
            String input = scanner.nextLine();
            Integer opcion = null;

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // Si la entrada no es un número válido, se captura la excepción
            }

            // Procesar la opción seleccionada
            if (opcion != null) {
                switch (opcion) {
                    case 1:
                        gestorBiblioteca.registrarLibro();
                        break;
                    case 2:
                        gestorBiblioteca.registrarUsuario();
                        break;
                    case 3:
                        gestorBiblioteca.prestarLibro();
                        break;
                    case 4:
                        consola.imprimirTexto("Saliendo del menú. ¡Hasta luego!", true);
                        try {
                            Thread.sleep(3000); // Pausa de 3 segundos
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
                        }
                        return; // Salir del bucle y del programa
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
