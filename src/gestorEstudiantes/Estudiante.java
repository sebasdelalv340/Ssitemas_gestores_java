package gestorEstudiantes;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    public String nombre;
    public String apellido;
    public List<Curso> listaCursos;

    public Estudiante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaCursos = new ArrayList<>();
    }
}
