package gestorEstudiantes;

public class Profesor {
    public String nombre;
    public String apellido;
    public String especialidad;

    public Profesor(String nombre, String apellido, String especialidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }

    public void asignarCurso(Estudiante estudiante, Curso curso) {
        estudiante.listaCursos.add(curso);
    }

    public double calcularNotaMedia(Estudiante estudiante) {
        double notaMedia = 0.0;
        for (Curso curso : estudiante.listaCursos) {
            notaMedia += curso.nota;
        }
        return !estudiante.listaCursos.isEmpty() ? notaMedia / estudiante.listaCursos.size() : 0.0;
    }
}
