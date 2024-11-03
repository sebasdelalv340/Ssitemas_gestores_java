package gestorTareas;

import java.time.LocalDate;

public class Tarea {
    public String nombre;
    public String descripcion;
    public LocalDate fecha;
    public Estado estado;


    public Tarea(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = LocalDate.now();
        this.estado = Estado.PENDIENTE;
    }
}
