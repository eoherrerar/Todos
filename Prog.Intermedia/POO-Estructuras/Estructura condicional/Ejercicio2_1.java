import java.util.Scanner;

public class Ejercicio2_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double a, b, c;

        System.out.print("Ingrese lado 1: ");
        a = sc.nextDouble();

        System.out.print("Ingrese lado 2: ");
        b = sc.nextDouble();

        System.out.print("Ingrese lado 3: ");
        c = sc.nextDouble();

        if (a + b > c && a + c > b && b + c > a) {

            if (a == b && b == c) {
                System.out.println("Triángulo Equilátero");
            } else if (a == b || a == c || b == c) {
                System.out.println("Triángulo Isósceles");
            } else {
                System.out.println("Triángulo Escaleno");
            }

        } else {
            System.out.println("No forman un triángulo válido");
        }

        sc.close();
    }
}