public class Traductor implements iTraductor{

    private  Traduccion[] diccionarioEspEng;
    private int totalPalabras;

    public Traductor(int size){
    diccionarioEspEng = new Traduccion[size];
    totalPalabras = 0;


    }

    @Override
    public boolean agregarPalabras(Traduccion palabra){
        if (totalPalabras < diccionarioEspEng.length ){
            diccionarioEspEng[totalPalabras] = palabra;
            this.totalPalabras ++;
            return true;
        }
        else{
        return false;
        }

    }
    @Override
    public abstract String verSignificado(String palabra){

    }
    @Override
    public abstract int verTotalPalabras(){

    }

}

//terminarlo hasta que traduzca