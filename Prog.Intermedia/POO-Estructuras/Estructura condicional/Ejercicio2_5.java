import java.util.Scanner;

public class Ejercicio2_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int anio, dia;
        boolean bisiesto;

        System.out.print("Ingrese un año: ");
        anio = sc.nextInt();

        bisiesto = (anio % 4 == 0 && anio % 100 != 0)
                || (anio % 400 == 0);

        if (bisiesto) {
            System.out.println("El año es bisiesto");
        } else {
            System.out.println("El año no es bisiesto");
        }

        System.out.print("Ingrese número del día (1-7): ");
        dia = sc.nextInt();

        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Número inválido");
        }

        sc.close();
    }
}