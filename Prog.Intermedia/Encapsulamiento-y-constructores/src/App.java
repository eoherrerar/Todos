public class App {

    public static void main(String[] args) {
        ////////////////LIBROS///////////////////////

        Libro libro1 = new Libro(
                "El universo en una cáscara de nuez",
                "Stephen Hawking",
                true);

        Libro libro2 = new Libro(
                "Java",
                "Edwin Herrera");

        // LIBRO 2 muestra la info
        System.out.println("LIBRO 2");
        libro2.mostrarInfo();
        System.out.println();

        // prestamos el libro
        libro2.prestar();
        libro2.mostrarInfo();
        System.out.println();

        libro2.prestar();

        // devolvemos el libro
        System.out.println();
        libro2.devolver();
        libro2.mostrarInfo();
        System.out.println();

        libro2.devolver();

        System.out.println("--------------------------------");

        System.out.println("LIBRO 1");

        libro1.mostrarInfo();
        System.out.println();

        libro1.mostrarInfo();

        // prestamos el libro
        System.out.println();
        libro1.prestar();
        libro1.mostrarInfo();
        System.out.println();

        libro1.prestar();

        // devolvemos el libro
        System.out.println();
        libro1.devolver();
        libro1.mostrarInfo();
        System.out.println();

        libro1.devolver();

        ///////////// VUELO //////////////////////

        Vuelo vuelo1 = new Vuelo(
                "AV9401",
                "Bogota",
                "Medellin",
                60,
                100);

        Vuelo vuelo2 = new Vuelo(
                "LA3020",
                "
                "Cartagena",Cali",
                80,
                150);

        vuelo1.mostrarInfo();

        System.out.println();

        vuelo2.mostrarInfo();

        System.out.println();

        vuelo1.embarcar(20);

        vuelo1.mostrarInfo();

        System.out.println();

        vuelo1.embarcar(50);

        System.out.println();

        vuelo1.desembarcar(30);

        vuelo1.mostrarInfo();

        System.out.println();

        vuelo1.desembarcar(100);

        vuelo1.mostrarInfo();

        System.out.println();

        ///////////// DEPOSITO DE AGUA //////////////////////

        DepositoAgua deposito1 = new DepositoAgua(100);
        DepositoAgua deposito2 = new DepositoAgua(50);

        deposito1.setDepositoDesborde(deposito2);

        deposito1.agregarAgua(120);

        System.out.println("Deposito 1");
        deposito1.mostrarEstado();

        System.out.println();

        System.out.println("Deposito 2");
        deposito2.mostrarEstado();

        System.out.println();

        deposito1.quitarAgua(40);

        deposito1.mostrarEstado();
    }
}