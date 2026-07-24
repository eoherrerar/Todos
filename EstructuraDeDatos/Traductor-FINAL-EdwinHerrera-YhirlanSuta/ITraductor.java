public interface ITraductor {

    boolean agregarPalabra(Traduccion palabra);

    String verSignificado(String palabra);

    int verTotalPalabras();

    boolean modificarPalabra(String palabraActual, String nuevaPalabra, String nuevoSignificado);

    boolean eliminarPalabra(String palabra);
    
}
