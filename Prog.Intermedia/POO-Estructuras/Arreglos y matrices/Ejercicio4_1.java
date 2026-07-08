import java.util.Scanner;

public class Ejercicio4_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] notas = new double[10];

        double suma = 0;

        double mayor;
        double menor;

        int posMayor = 0;
        int posMenor = 0;

        int aprobados = 0;
        int reprobados = 0;

        for (int i = 0; i < notas.length; i++) {

            System.out.print("Ingrese nota " + (i + 1) + ": ");

            notas[i] = sc.nextDouble();

            suma += notas[i];
        }

        mayor = notas[0];
        menor = notas[0];

        for (int i = 0; i < notas.length; i++) {

            if (notas[i] > mayor) {
                mayor = notas[i];
                posMayor = i;
            }

            if (notas[i] < menor) {
                menor = notas[i];
                posMenor = i;
            }

            if (notas[i] >= 3.0) {
                aprobados++;
            } else {
                reprobados++;
            }
        }

        double promedio = suma / notas.length;

        System.out.printf("\nPromedio: %.2f\n", promedio);

        System.out.println("Mayor nota: " + mayor +
                " en posición " + posMayor);

        System.out.println("Menor nota: " + menor +
                " en posición " + posMenor);

        System.out.println("Aprobados: " + aprobados);

        System.out.println("Reprobados: " + reprobados);

        sc.close();
    }
}