public class App {
    public static void main(String[] args) throws Exception {
        Libro libro1 = new Libro("Cien anos de soledad", "Gabriel Garcia marquez");
        Libro libro2 = new Libro("El amor en los tiempos de colera", "Gabriel Garcia marquez");
        Libro libro3 = new Libro("El principito", "Antonio Rodrigez");
        
        Biblioteca biblioteca = new Biblioteca("El patito san Juan");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro3);

        biblioteca.mostrarCatalogo();

        
        biblioteca.buscarAutor("Gabriel garcia marquez");
        biblioteca.buscarAutor("Edwin pasto aleman rodriperro");
    }
}
