public class Asiento {
    private String codigo;
    private boolean ocupado;

    public Asiento(String codigo){
        this.codigo =  codigo;
        this.ocupado = false;
    }
    public String getCodigo() {
        return codigo;
    }
    public boolean isOcupado(){
        return ocupado;
    }  

    public void ocupar (){
        if(ocupado){
            System.out.println("El asiento esta ocupado");
        }else{
            this.ocupado =  true;
            System.out.println("El asiento " + codigo + " ha sido ocupado");
        }
    }
    public void liberar(){
        if(ocupado){
            this.ocupado = false;
            System.out.println("el asiento " + codigo + "ha sido liberado");
        }else{
            System.out.println("No se puede liberar el asiento" + codigo + "por que aun no ha sido ocupado");
        }
    }
    public void mostrasEstado(){
        System.out.println("el asiento con el codigo : "+ codigo + (ocupado ? "ocupado" : "libre"));
    }
    
}
