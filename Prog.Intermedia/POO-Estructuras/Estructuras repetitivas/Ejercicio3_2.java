import java.util.Scanner;

public class Ejercicio3_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numeroSecreto;
        int intento;
        int contador = 0;

        numeroSecreto = (int)(Math.random() * 100) + 1;

        System.out.println("Adivina el número entre 1 y 100");

        while (true) {

            contador++;

            System.out.print("Intento " + contador + ": ");
            intento = sc.nextInt();

            if (intento < numeroSecreto) {
                System.out.println("El número es mayor");
            } else if (intento > numeroSecreto) {
                System.out.println("El número es menor");
            } else {
                System.out.println("¡Correcto!");
                System.out.println("Lo lograste en " + contador + " intentos");
                break;
            }
        }

        sc.close();
    }
}