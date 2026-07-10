import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Traductor traductor = new Traductor(10);

        traductor.agregarPalabra("casa", "house");
        traductor.agregarPalabra("perro", "dog");
        traductor.agregarPalabra("libro", "book");
        traductor.agregarPalabra("house", "casa");
        traductor.agregarPalabra("dog", "perro");
        traductor.agregarPalabra("book", "libro");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite una palabra en español para traducir:");
        String palabra = scanner.nextLine();

        String traduccion = traductor.traducir(palabra);
        System.out.println("Traducción: " + traduccion);

        scanner.close();
    }
}
