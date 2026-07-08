
import java.util.Scanner;
public class Minutos {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese los minutos");
            int min = sc.nextInt();
            int horas = (int)min/60;
            int horasM =(int) min %60;
            int segun = min * 60;

            System.out.println("Los minutos "+ min );
            System.out.println("Los segundos  "+ segun);
            System.out.println("horas "+ horas + " : " +horasM + "minutos");
        }
    }
}