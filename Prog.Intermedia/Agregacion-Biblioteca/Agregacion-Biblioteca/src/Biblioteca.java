public class Biblioteca {
    private String nombre;
    private Libro[] catalogo;
    private int cantidad;

    public Biblioteca(String nombre){
        this.nombre = nombre;
        this.cantidad = 0;
        this.catalogo = new Libro[10];
    }
    public String getNombre(){
        return this.nombre;
    }
    public void agregarLibro(Libro libro){
        if(cantidad< catalogo.length){
            catalogo[cantidad] = libro;
            cantidad++;
            System.out.println("\nEl libro :"+ libro.getTitulo()+"\nAutor :"+ libro.getAutor()+"\nSe agrego a catalogo");
        }else{
            System.out.println("El catalogo esta lleno");
        }
    }
    public void mostrarCatalogo(){
        if(cantidad == 0){
            System.out.println("\nEl catalogo est vacio\n");
        }else{
            for(int i = 0 ; i < cantidad; i++){
                catalogo[i].mostrarInfo();
                System.out.println();
            }
        }
    }
    public void buscarAutor(String autor){
        for(int i = 0 ; i < cantidad;i++){
            if(catalogo[i].getAutor().equalsIgnoreCase(autor)){
                System.out.println(catalogo[i].getTitulo());
                return;
            }
        }
        System.out.println("\nno fue encontrado");
    }
}