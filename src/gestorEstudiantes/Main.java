package gestorEstudiantes;

import consola.Consola;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Consola consola = new Consola();
        Profesor profesor = new Profesor("Luis", "Gónzalez", "Programación multimedia");
        GestorEstudiantes gestorEstudiantes = new GestorEstudiantes(consola, profesor);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Asignar curso.");
            System.out.println("2. Calcular nota media.");
            System.out.println("3. Salir");
            System.out.print("Elige una opción (1-3): ");

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
                        gestorEstudiantes.pedirEstudiante();
                        break;
                    case 2:
                        gestorEstudiantes.notaMedia();
                        break;
                    case 3:
                        System.out.println("Saliendo del menú. ¡Hasta luego!");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        return;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                        break;
                }
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}
