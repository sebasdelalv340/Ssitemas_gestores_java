package gestorBiblioteca;

import consola.Consola;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final Consola consola;
    private final List<Libro> listaLibros;
    private final List<Usuario> listaUsuarios;


    public Biblioteca(Consola consola) {
        this.consola = consola;
        this.listaLibros = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
    }

    public void registrarLibro() {
        consola.imprimirTexto("Introduzca el título: ", false);
        String titulo = consola.pedirString();
        consola.imprimirTexto("Introduzca el autor: ", false);
        String autor = consola.pedirString();
        consola.imprimirTexto("Introduzca el genero: ", false);
        String genero = consola.pedirString();
        listaLibros.add(new Libro(titulo, autor, genero));
    }

    public void registrarUsuario() {
        consola.imprimirTexto("Introduzca su nombre: ", false);
        String nombre = consola.pedirString();
        consola.imprimirTexto("Introduzca su DNI: ", false);
        String dni = consola.pedirString();
        listaUsuarios.add(new Usuario(nombre, dni));
    }


    public void prestarLibro() {
        consola.imprimirTexto("Introduzca el título del libro: ", false);
        String titulo = consola.pedirString();

        Libro libro = listaLibros.stream()
                .filter(l -> l.titulo.equals(titulo))  // Acceso a título sin getter
                .findFirst()
                .orElse(null);

        if (libro != null && libro.estado == Estado.DISPONIBLE) {  // Acceso a estado sin getter
            consola.imprimirTexto("El libro está disponible.", true);
            libro.estado = Estado.PRESTADO;  // Cambiar el estado sin setter
        } else {
            consola.imprimirTexto("El libro no está disponible.", true);
        }
    }
}
