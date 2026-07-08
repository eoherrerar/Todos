public class App {
    public static void main(String[] args) throws Exception {
        Persona persona1 = new Persona("Yhirlan","Suta",17);
        System.out.println("-----------------------------------------------");
        System.out.println(persona1.MostrarInfo());
       Persona persona2 = new Persona("Edwin","herrera",25);
       System.out.println("-----------------------------------------------");
        System.out.println(persona2.MostrarInfo());
        System.out.println("-----------------------------------------------");
        Persona persona3 = new Persona();
        System.out.println(persona3.MostrarInfo());
        System.out.println("-----------------------------------------------");

    }
}
