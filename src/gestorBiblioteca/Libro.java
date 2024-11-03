package gestorBiblioteca;

public class Libro {
    String titulo;
    private String autor;
    private String genero;
    Estado estado; // Asumiendo que tienes una enum Estado


    public Libro(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.estado = Estado.DISPONIBLE;
    }
}
