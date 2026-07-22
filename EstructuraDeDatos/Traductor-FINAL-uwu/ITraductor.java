public interface ITraductor {
    boolean agregarPalabra(Traduccion palabra);
    String verSignificado(String palabra);
    int verTotalPalabras();
    
    boolean modificarPalabra(String palabraEspanol, String nuevoSignificado);
}