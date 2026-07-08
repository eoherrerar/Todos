import java.util.Scanner;

public class notas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double parcial1, parcial2, examenFinal, definitiva;

        System.out.print("Ingrese nota del primer parcial: ");
        parcial1 = sc.nextDouble();

        System.out.print("Ingrese nota del segundo parcial: ");
        parcial2 = sc.nextDouble();

        System.out.print("Ingrese nota del examen final: ");
        examenFinal = sc.nextDouble();

        definitiva = (parcial1 * 0.30) +
                     (parcial2 * 0.30) +
                     (examenFinal * 0.40);

        String resultado = (definitiva >= 3.0) ?
                "Aprueba" : "Reprueba";

        System.out.printf("Nota definitiva: %.2f\n", definitiva);
        System.out.println("Resultado: " + resultado);

        sc.close();
    }
}