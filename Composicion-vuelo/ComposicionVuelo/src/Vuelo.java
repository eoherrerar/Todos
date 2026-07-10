public class Vuelo {
    private String numero,origen,destino;
    private int capacidad;   
    private Asiento [] asientos;

    public Vuelo(String numero, String origen, String destino){
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;   
    }
    public Vuelo(String numero, String origen, String destino,int capacidad){
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.capacidad = capacidad;  
        asientos = new Asiento[capacidad];
        for(int i = 0 ; i < capacidad; i++){
            asientos[i] = new Asiento("A"+(i+1));
        }
    }
    public String getNumero() {
        return this.numero;
    }
    public String getDestino() {
        return this.destino;
    }
    public String getOrigen() {
        return this.origen;
    }
    public void mostrarInfo(){
        System.out.println("\nvuelo: "+ numero);
        System.out.println("ruta: "+ origen + " ---> " + destino);
        System.out.println("capacidad: "+ capacidad +"\n");
    }
    public void mostrarAsientos(){
        System.out.println("\nEstado de asientos del vuelo:"+numero);
        for(Asiento a:asientos){
            System.out.println();
            a.mostrarEstado();
        }
    }
    public void embarcar(String codigoAsiento){
        for(Asiento a : asientos){
            if(a.getCodigo().equals(codigoAsiento)){
                a.ocupar();
                return;
            }
        }
        System.out.println("El asiento " + codigoAsiento + " no fue encontrado en el vuelo " + numero);
    }
       public void desembarcar(String codigoAsiento){
        for(Asiento a : asientos){
            if(a.getCodigo().equals(codigoAsiento)){
                a.liberar();
                return;
            }
        }
        System.out.println("El asiento " + codigoAsiento + " no fue encontrado en el vuelo " + numero);
    }
}

