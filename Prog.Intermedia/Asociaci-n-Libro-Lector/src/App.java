public class App {
    public static void main(String[] args) throws Exception {
        //----Libros-----
        Libro libro1 = new Libro("cien años de soledad", "Gabriel Garcia Maquez" );
        Libro libro2 = new Libro("El principito", "Antoine de Saint-Exupéry" );
        Libro libro3 = new Libro(" El universo en una cascara de nuez", "Sthepen Hawking" );
        Libro libro4 = new Libro("El extraNo caso del doctor Jekyll y el senor Hyde", "Robert Louis Stevenson" );
        Libro libro5 = new Libro("The Great Gatsby", "F. Scott Fitzgerald" );
        
        //----Lectores-----
        Lector lector1 = new Lector("1005855871" , "Edwin Herrera" );
        lector1.tomarPrestado(libro1);
        lector1.mostrarEstado();
        System.out.println("");
        
        Lector lector2 = new Lector("1005855872" , "Juan Perez" );
        lector2.tomarPrestado(libro2); 
        lector2.mostrarEstado();
        System.out.println("");

        Lector lector3 = new Lector("1005855873" , "Maria Gomez" );
        lector3.tomarPrestado(libro3);
        lector3.mostrarEstado();
        System.out.println("");

        Lector lector4 = new Lector("1005855874" , "Pedro Martinez" );
        lector4.tomarPrestado(libro4);
        lector4.mostrarEstado();
        System.out.println("");

        Lector lector5 = new Lector("1005855875" , "Ana Rodriguez" );
        lector5.tomarPrestado(libro5);
        lector5.mostrarEstado();
        System.out.println("");

        System.out.println("--------------------Devolcuion de libros--------------------------------");
        lector1.devolverLibro(libro1);
        lector2.devolverLibro(libro2);
        lector3.devolverLibro(libro3);
        lector4.devolverLibro(libro4);
        lector5.devolverLibro(libro5);
        lector1.mostrarEstado();
        lector2.mostrarEstado();
        lector3.mostrarEstado();
        lector4.mostrarEstado();
        lector5.mostrarEstado();
    }
}
//CREAR 5 LECTORES Y 5 LIBROS Y VAN A PRESTAR LIBROS A LOS LECTORES , INTENTAR PRESTAR UN LIBRO QUE YA ESTA PRESTAADO POR ALGUIEN
//"ERROR" TIENE QUE MOSTRAR EL LIBRO YA PRESTADO , Y UTILIZAR METODO REGRESAR EL LIBRO

//DRAW.IO PARA HACER EL DIAGRAMA DE CLASES "LIBRO Y LECTOR" CON ATRIBUTOS Y CCARACTERISTICAS