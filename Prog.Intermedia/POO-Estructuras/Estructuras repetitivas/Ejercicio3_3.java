import java.util.Scanner;

public class Ejercicio3_3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        int sumaNaturales = 0;
        int sumaPares = 0;
        int sumaCuadrados = 0;

        System.out.print("Ingrese n: ");
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            sumaNaturales += i;

            sumaPares += (2 * i);

            sumaCuadrados += (i * i);
        }

        int formulaNaturales = n * (n + 1) / 2;

        int formulaPares = n * (n + 1);

        int formulaCuadrados = n * (n + 1) * (2 * n + 1) / 6;

        System.out.println("\n--- Resultados ---");

        System.out.println("Suma naturales: " + sumaNaturales);
        System.out.println("Fórmula: " + formulaNaturales);

        System.out.println();

        System.out.println("Suma pares: " + sumaPares);
        System.out.println("Fórmula: " + formulaPares);

        System.out.println();

        System.out.println("Suma cuadrados: " + sumaCuadrados);
        System.out.println("Fórmula: " + formulaCuadrados);

        sc.close();
    }
}