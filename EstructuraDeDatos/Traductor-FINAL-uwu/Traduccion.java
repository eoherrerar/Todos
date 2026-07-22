public class Traduccion {
    private String palabra;
    private String significado;

    public Traduccion(String palabra, String significado) {
        this.palabra = palabra;
        this.significado = significado;
    }

    public String verPalabra() {
        return palabra;
    }

    public String verSignificado() {
        return significado;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }
}