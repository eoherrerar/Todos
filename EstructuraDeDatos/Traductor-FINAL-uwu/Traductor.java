public class Traductor implements ITraductor {
    private Traduccion[] diccionario;
    private int totalPalabras;
    private TipoDiccionario tipo;

    public Traductor(int size, TipoDiccionario tipo) {
        this.diccionario = new Traduccion[size];
        this.totalPalabras = 0;
        this.tipo = tipo;
    }

    @Override
    public boolean agregarPalabra(Traduccion palabra) {
        if (palabra == null || palabra.verPalabra() == null || palabra.verSignificado() == null) {
            return false;
        }
        if (palabra.verPalabra().trim().isEmpty() || palabra.verSignificado().trim().isEmpty()) {
            return false;
        }

        if (totalPalabras < diccionario.length) {
            diccionario[totalPalabras] = palabra;
            totalPalabras++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String verSignificado(String palabra) {
        if (palabra == null) return "No existe en el diccionario";
        
        for (int i = 0; i < totalPalabras; i++) {
            if (diccionario[i].verPalabra().equalsIgnoreCase(palabra.trim())) {
                return diccionario[i].verSignificado();
            }
            if (diccionario[i].verSignificado().equalsIgnoreCase(palabra.trim())) {
                return diccionario[i].verPalabra();
            }
        }
        return "No existe en el diccionario";
    }

    @Override
    public boolean modificarPalabra(String palabraEspanol, String nuevoSignificado) {
        if (palabraEspanol == null || nuevoSignificado == null) return false;
        
        for (int i = 0; i < totalPalabras; i++) {
            if (diccionario[i].verPalabra().equalsIgnoreCase(palabraEspanol.trim())) {
                diccionario[i].setSignificado(nuevoSignificado.trim());
                return true;
            }
        }
        return false;
    }

    @Override
    public int verTotalPalabras() {
        return totalPalabras;
    }

    public TipoDiccionario getTipo() {
        return tipo;
    }

    public String verTipoDiccionario() {
        return tipo.name();
    }
}