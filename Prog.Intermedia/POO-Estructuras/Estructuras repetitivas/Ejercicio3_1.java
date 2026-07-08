import java.util.Scanner;

public class Ejercicio3_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Ingrese un número positivo: ");
        n = sc.nextInt();

        System.out.println("\n--- Tabla del número " + n + " ---");

        for (int i = 1; i <= 12; i++) {
            System.out.printf("%d x %d = %d\n", n, i, (n * i));
        }

        System.out.println("\n--- Tablas del 1 al " + n + " ---");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= 12; j++) {
                System.out.printf("%4d", (i * j));
            }

            System.out.println();
        }

        sc.close();
    }
}