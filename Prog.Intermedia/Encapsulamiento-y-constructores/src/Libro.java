public class Libro {
    private String titulo;
    private String autor;
    private boolean disponible;

    // Constructor vacío
    public Libro() {
        disponible = true;
    }

    // Constructor con título y autor
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    // Constructor completo
    public Libro(String titulo, String autor, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = disponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {

        if (!titulo.isEmpty()) {
            this.titulo = titulo;
        } else {
            System.out.println("El titulo no puede estar vacio");
        }

    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void mostrarInfo() {

        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Disponible: " + disponible);
    }

    public void prestar() {

        if (disponible) {
            disponible = false;
            System.out.println("Libro prestado");
        } else {
            System.out.println("El libro ya estaba prestado");
        }

    }

    public void devolver() {

        if (!disponible) {
            disponible = true;
            System.out.println("Libro devuelto");
        } else {
            System.out.println("El libro ya estaba disponible");
        }

    }
}