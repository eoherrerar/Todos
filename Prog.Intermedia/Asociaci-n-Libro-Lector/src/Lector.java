public class Lector{
    private String cedula, nombre;
    private Libro libroActual;
    
public Lector(String cedula , String nombre){
    this.nombre =  nombre;
    this.cedula = cedula;
}
public String getCedula() {
    return cedula;
}
public Libro getLibroActual() {
    return libroActual;
}
public String getNombre() {
    return nombre;
}
public void setCedula(String cedula) {
    this.cedula = cedula;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}
public void tomarPrestado (Libro libro){
    if(libroActual != null){
        System.out.println(nombre + "ya tiene libro \n");
    }else{
        if (libro.prestar()){
            libroActual = libro;
        }
    }
    
}

public void devolverLibro(Libro libro){
    if (libroActual == null){
        System.out.println(nombre + "no tiene libro para devolver");
    }else{
        libro.devolver();
        libroActual = null;

    }
    
}
public void mostrarEstado (){
    String Estado = (libroActual != null) ? libroActual.getTitulo() : "sin libro";
    System.out.println("Lector: " + nombre + " , " + "Libro: " + Estado);
}

}
