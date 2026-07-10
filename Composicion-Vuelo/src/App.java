public class App {
    public static void main(String[] args) throws Exception {
        Vuelo vuelo1 = new Vuelo("45", "Bogota","Canada");
        
        vuelo1.mostrarInfo();
        vuelo1.Embarcar("A1");
        vuelo1.Embarcar("A2");
        vuelo1.Embarcar("A3");
        vuelo1.Embarcar("A2");
        vuelo1.mostrarAsientos();


        
        //embarcar 3 asientos, intenta embarcar un asiento ocupado, mostrar la informacion de los asientos
        //desembarcar asientos , y mostrar asientos

        //3 vuelos 
    }
}
