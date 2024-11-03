package consola;

import java.util.Scanner;

public class Consola {
    private final Scanner scanner; // Para leer entradas del usuario


    public Consola() {
        this.scanner = new Scanner(System.in);
    }

    public void imprimirTexto(String mensaje, boolean salto) {
        if (salto) {
            System.out.println(mensaje);
        } else {
            System.out.print(mensaje);
        }
    }


    public String pedirString() {
        return scanner.nextLine();
    }


    public int pedirEntero() {
        return Integer.parseInt(scanner.nextLine());
    }


    public double pedirDouble() {
        return Double.parseDouble(scanner.nextLine());
    }


    public boolean preguntarOpcion() {
        boolean opcion = true;
        do {
            imprimirTexto("S/N: ", false);
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("s")) {
                opcion = false;
                return true;
            } else if (input.equals("n")) {
                opcion = false;
                return false;
            } else {
                imprimirTexto("Valor no válido.", true);
                return false;
            }
        } while (opcion);
    }
}