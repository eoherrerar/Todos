public class App {
    public static void main(String[] args) throws Exception {
        Vuelo vuelo1 = new Vuelo("1","Bogota","Medellin",5);
        vuelo1.mostrarInfo();
        vuelo1.embarcar("A1");
        vuelo1.embarcar("A2");
        vuelo1.embarcar("A3");
        vuelo1.embarcar("A1");
        vuelo1.mostrarAsientos();
        vuelo1.desembarcar("A1");
        vuelo1.desembarcar("A2");
        vuelo1.desembarcar("A3");
        vuelo1.desembarcar("A5");
        vuelo1.mostrarAsientos();

        // segundo vuelo
        Vuelo vuelo2 = new Vuelo("2","Cartagena","Cali",10);
        vuelo2.mostrarInfo();
        vuelo2.embarcar("A1");
        vuelo2.embarcar("A5");
        vuelo2.embarcar("A9");
        vuelo2.embarcar("A1");
        vuelo2.mostrarAsientos();
        vuelo2.desembarcar("A1");
        vuelo2.desembarcar("A5");
        vuelo2.desembarcar("A9");
        vuelo2.desembarcar("A2");
        vuelo2.mostrarAsientos();
        // tercer vuelo
        Vuelo vuelo3 = new Vuelo("3","Cucuta","Ibague",8);
        vuelo3.mostrarInfo();
        vuelo3.embarcar("A4");
        vuelo3.embarcar("A6");
        vuelo3.embarcar("A8");
        vuelo3.embarcar("A8");
        vuelo3.mostrarAsientos();
        vuelo3.desembarcar("A4");
        vuelo3.desembarcar("A6");
        vuelo3.desembarcar("A8");
        vuelo3.desembarcar("A7");
        vuelo3.mostrarAsientos();
    }
}
