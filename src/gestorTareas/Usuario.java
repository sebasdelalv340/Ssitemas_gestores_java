package gestorTareas;

import consola.Consola;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private Consola consola;
    public String nombre;
    public List<Proyecto> listaProyecto;

    // Constructor que inicializa el nombre y la lista de proyectos
    public Usuario(Consola consola, String nombre) {
        this.consola = consola;
        this.nombre = nombre;
        this.listaProyecto = new ArrayList<>();
    }

    // Método para crear un nuevo proyecto
    public void crearProyecto() {
        consola.imprimirTexto("Introduce el nombre del proyecto: ", false);
        String nombre = consola.pedirString();
        listaProyecto.add(new Proyecto(nombre));
    }

    // Método para asignar una nueva tarea a un proyecto
    public void asignarTarea() {
        Proyecto proyecto = buscarProyecto();
        consola.imprimirTexto("Nombre de la tarea: ", false);
        String nombre = consola.pedirString();
        consola.imprimirTexto("Descripción de la tarea: ", false);
        String descripcion = consola.pedirString();
        Tarea tarea = new Tarea(nombre, descripcion);
        if (proyecto != null) {
            proyecto.listaTarea.add(tarea);
        }
    }

    // Método para buscar un proyecto por nombre
    private Proyecto buscarProyecto() {
        consola.imprimirTexto("Nombre del proyecto: ", false);
        String nombre = consola.pedirString();
        return listaProyecto.stream().filter(p -> p.nombre.equals(nombre)).findFirst().orElse(null);
    }

    // Método para cambiar el estado de una tarea
    public void cambiarEstadoTarea() {
        Proyecto proyecto = buscarProyecto();
        Tarea tarea = buscarTarea(proyecto);
        consola.imprimirTexto("El estado de la tarea es " + (tarea != null ? tarea.estado : "no encontrada"), true);
        consola.imprimirTexto("¿Desea cambiar el estado?", true);
        if (consola.preguntarOpcion()) {
            if (tarea != null) {
                if (tarea.estado == Estado.PENDIENTE) {
                    tarea.estado = Estado.COMPLETADA;
                    consola.imprimirTexto("Estado de la tarea cambiado a completada.", true);
                } else {
                    tarea.estado = Estado.PENDIENTE;
                    consola.imprimirTexto("Estado de la tarea cambiado a pendiente.", true);
                }
            }
        }
    }

    // Método para buscar una tarea en un proyecto por nombre
    private Tarea buscarTarea(Proyecto proyecto) {
        consola.imprimirTexto("Nombre de la tarea: ", false);
        String nombre = consola.pedirString();
        return proyecto != null ? proyecto.listaTarea.stream().filter(t -> t.nombre.equals(nombre)).findFirst().orElse(null) : null;
    }
}