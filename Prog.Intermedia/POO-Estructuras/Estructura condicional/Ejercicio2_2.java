import java.util.Scanner;

public class Ejercicio2_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double peso, estatura, imc;

        System.out.print("Ingrese peso en kg: ");
        peso = sc.nextDouble();

        System.out.print("Ingrese estatura en metros: ");
        estatura = sc.nextDouble();

        imc = peso / (estatura * estatura);

        System.out.printf("IMC: %.2f\n", imc);

        if (imc < 18.5) {
            System.out.println("Bajo peso");
        } else if (imc < 25) {
            System.out.println("Peso normal");
        } else if (imc < 30) {
            System.out.println("Sobrepeso");
        } else {
            System.out.println("Obesidad");
        }

        sc.close();
    }
}