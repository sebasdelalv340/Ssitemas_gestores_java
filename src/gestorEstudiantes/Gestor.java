package gestorEstudiantes;

import consola.Consola;

import java.util.ArrayList;
import java.util.List;

class GestorEstudiantes {
    public Consola consola;
    public Profesor profesor;
    public List<Estudiante> listaEstudiantes;

    public GestorEstudiantes(Consola consola, Profesor profesor) {
        this.consola = consola;
        this.profesor = profesor;
        this.listaEstudiantes = new ArrayList<>();
    }

    public void pedirEstudiante() {
        consola.imprimirTexto("Nombre del estudiante: ", false);
        String nombre = consola.pedirString();
        consola.imprimirTexto("Apellido del estudiante: ", false);
        String apellido = consola.pedirString();
        Curso curso = pedirCurso();
        Estudiante estudiante = new Estudiante(nombre, apellido);
        profesor.asignarCurso(estudiante, curso);
        listaEstudiantes.add(estudiante);
    }

    private Curso pedirCurso() {
        consola.imprimirTexto("Nombre del curso: ", false);
        String nombre = consola.pedirString();
        consola.imprimirTexto("Nota del curso: ", false);
        double nota = consola.pedirDouble();
        return new Curso(nombre, nota);
    }

    public void notaMedia() {
        consola.imprimirTexto("Nombre del estudiante: ", false);
        String nombreEstudiante = consola.pedirString();
        Estudiante estudiante = listaEstudiantes.stream()
                .filter(e -> e.nombre.equals(nombreEstudiante))
                .findFirst()
                .orElse(null);

        if (estudiante != null) {
            consola.imprimirTexto("Nota media: " + profesor.calcularNotaMedia(estudiante), true);
        } else {
            consola.imprimirTexto("Estudiante no encontrado.", true);
        }
    }
}