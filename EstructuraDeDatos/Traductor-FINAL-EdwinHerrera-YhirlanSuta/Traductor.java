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
    public boolean modificarPalabra(String palabraActual,
                                String nuevaPalabra,
                                String nuevoSignificado) {

    if (palabraActual == null ||
        nuevaPalabra == null ||
        nuevoSignificado == null) {

        return false;
    }


    for (int i = 0; i < totalPalabras; i++) {


        if (diccionario[i].verPalabra()
                .equalsIgnoreCase(palabraActual.trim())) {


            diccionario[i].cambiarPalabra(
                    nuevaPalabra.trim()
            );


            diccionario[i].cambiarSignificado(
                    nuevoSignificado.trim()
            );


            return true;

        }

    }


    return false;
}

    public boolean eliminarPalabra(String palabra) {

    if (palabra == null || palabra.trim().isEmpty()) {
        return false;
    }

    for (int i = 0; i < totalPalabras; i++) {

        if (diccionario[i].verPalabra().equalsIgnoreCase(palabra.trim())) {

            // Desplazar todos los elementos una posición a la izquierda
            for (int j = i; j < totalPalabras - 1; j++) {
                diccionario[j] = diccionario[j + 1];
            }

            // Liberar la última posición
            diccionario[totalPalabras - 1] = null;

            // Disminuir el contador
            totalPalabras--;

            return true;
        }
    }

    return false;
}
public Traduccion buscarPalabra(String palabra) {

    if (palabra == null || palabra.trim().isEmpty()) {
        return null;
    }

    for (int i = 0; i < totalPalabras; i++) {

        if (diccionario[i].verPalabra()
                .equalsIgnoreCase(palabra.trim())) {

            return diccionario[i];

        }

    }

    return null;
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