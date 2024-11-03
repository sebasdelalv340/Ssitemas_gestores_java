package gestorTareas;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    public String nombre;                 // Atributo para el nombre del proyecto
    public List<Tarea> listaTarea;       // Lista mutable de tareas


    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.listaTarea = new ArrayList<>();
    }
}
