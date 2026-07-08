import java.util.Scanner;

public class Ejercicio3_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int edad;

        while (true) {

            System.out.print("Ingrese su edad: ");
            edad = sc.nextInt();

            if (edad >= 1 && edad <= 120) {
                break;
            }

            System.out.println("Edad inválida. Debe estar entre 1 y 120.");
        }

        if (edad <= 12) {
            System.out.println("Niñez");
        } else if (edad <= 17) {
            System.out.println("Adolescencia");
        } else if (edad <= 25) {
            System.out.println("Juventud");
        } else if (edad <= 59) {
            System.out.println("Adultez");
        } else {
            System.out.println("Tercera edad");
        }

        sc.close();
    }
}