public class Traductor implements iTraductor {

    private Traduccion[] diccionarioEspEng;
    private int totalPalabras;

    public Traductor(int size) {
        diccionarioEspEng = new Traduccion[size];
        totalPalabras = 0;
    }

    @Override
    public boolean agregarPalabras(Traduccion palabra) {
        if (palabra == null) {
            return false;
        }

        if (totalPalabras < diccionarioEspEng.length) {
            diccionarioEspEng[totalPalabras] = palabra;
            totalPalabras++;
            return true;
        }

        return false;
    }

    public boolean agregarPalabra(String palabra, String significado) {
        if (palabra == null || palabra.trim().isEmpty() || significado == null || significado.trim().isEmpty()) {
            return false;
        }

        return agregarPalabras(new Traduccion(palabra, significado));
    }

    @Override
    public String verSignificado(String palabra) {
        if (palabra == null) {
            return "Palabra no encontrada";
        }

        for (int i = 0; i < totalPalabras; i++) {
            if (diccionarioEspEng[i].VerPalabra().equalsIgnoreCase(palabra.trim())) {
                return diccionarioEspEng[i].verSignificado();
            }
        }

        return "Palabra no encontrada";
    }

    public String traducir(String palabra) {
        return verSignificado(palabra);
    }

    @Override
    public int verTotalPalabras() {
        return totalPalabras;
    }
}

