public class Vuelo {
    private String numero , origen , destino;
    private int capacidad;
    private Asiento[]asientos;

    public Vuelo(String numero, String origen, String destido){
        this.numero = numero;
        this.origen = origen;
        this.destino = destido;
    }
    public Vuelo(String numero, String origen, String destido , int capacidad){
        this.numero = numero;
        this.origen = origen;
        this.destino = destido;
        this.capacidad =  capacidad;
        asientos = new Asiento[capacidad];
            for (int i = 0; i < capacidad ; i ++ ){
            asientos[i] =  new Asiento("A" + (i+1));
        }

    }
    public String getNumero() {
        return this.numero;
    }
    public String getOrigen() {
        return this.origen;
    }
    public String getDestino() {
        return this.destino;
    }
    public void mostrarInfo(){
        System.out.println("El vuelo el tiene el numero :" + numero);
        System.out.println("la ruta del vuelo va de : " + origen + " a " + destino);
        System.out.println("la capacidad del vuelo es " + capacidad);
    }
    public void mostrarAsientos(){
        System.out.println("Estados de asientos en el vuelo :" + numero);
        for (Asiento a : asientos){
            a.mostrasEstado();
        }
    }
    public void Embarcar(String codigoAsiento){
        for(Asiento a : asientos){
            if (a.getCodigo().equals(codigoAsiento)){
                a.liberar();
                return;
            }

        }System.out.println("el asiento : " + codigoAsiento + "no se encuentra en este vuelo");
    }
    public void Desembarcar(String codigoAsiento){
        for(Asiento a : asientos){
            if (a.getCodigo().equals(codigoAsiento)){
                a.liberar();
                return;
            }

        }System.out.println("el asiento : " + codigoAsiento + "no se encuentra en este vuelo");
    }
}
