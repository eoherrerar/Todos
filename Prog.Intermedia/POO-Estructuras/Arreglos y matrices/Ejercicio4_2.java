import java.util.Scanner;

public class Ejercicio4_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Ingrese tamaño del arreglo (máximo 20): ");
        n = sc.nextInt();

        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Ingrese número: ");

            numeros[i] = sc.nextInt();
        }

        System.out.print("\nOriginal: ");

        for (int num : numeros) {
            System.out.print(num + " ");
        }

        for (int i = 0; i < n / 2; i++) {

            int temp = numeros[i];

            numeros[i] = numeros[n - 1 - i];

            numeros[n - 1 - i] = temp;
        }

        System.out.print("\nInvertido: ");

        for (int num : numeros) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}