import java.util.Scanner;

public class Ejercicio3_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a, b;

        int cantidad = 0;
        int suma = 0;

        System.out.print("Ingrese a: ");
        a = sc.nextInt();

        System.out.print("Ingrese b: ");
        b = sc.nextInt();

        System.out.print("Primos entre " + a + " y " + b + ": ");

        for (int num = a; num <= b; num++) {

            if (num < 2) {
                continue;
            }

            boolean primo = true;

            int divisor = 2;

            while (divisor <= Math.sqrt(num)) {

                if (num % divisor == 0) {
                    primo = false;
                    break;
                }

                divisor++;
            }

            if (primo) {

                System.out.print(num + " ");

                cantidad++;

                suma += num;
            }
        }

        System.out.println();

        System.out.println("Cantidad: " + cantidad);

        System.out.println("Suma: " + suma);

        sc.close();
    }
}
