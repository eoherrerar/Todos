import java.util.Scanner;

public class Ejercicio2_4 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int tipo, horas;
            int primeraHora = 0;
            int adicional = 0;
            int total;

            System.out.println("1. Moto");
            System.out.println("2. Carro");
            System.out.println("3. Camioneta");

            System.out.print("Ingrese tipo de vehículo: ");
            tipo = sc.nextInt();

            System.out.print("Ingrese horas: ");
            horas = sc.nextInt();

            switch (tipo) {

                case 1:
                    primeraHora = 2000;
                    adicional = 1500;
                    break;

                case 2:
                    primeraHora = 4000;
                    adicional = 3000;
                    break;

                case 3:
                    primeraHora = 5000;
                    adicional = 4000;
                    break;

                default:
                    System.out.println("Opción no válida");
                    return;
            }

            total = primeraHora + ((horas - 1) * adicional);

            System.out.println("Total a pagar: $" + total);
        }
    }
}