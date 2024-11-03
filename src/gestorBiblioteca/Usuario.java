package gestorBiblioteca;

public class Usuario {
    String nombre;
    private String dni;
    int numUsuario; // Identificador único

    private static int num = 0; // Contador para generar números de usuario

    // Constructor
    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.numUsuario = generarNumUsuario();
    }

    private static int generarNumUsuario() {
        num++;
        return num;
    }
}
