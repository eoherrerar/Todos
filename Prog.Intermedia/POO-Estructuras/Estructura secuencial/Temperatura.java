import java.util.Scanner;
public class Temperatura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese los grados a celsius");
        double C = sc.nextDouble();
        double F = (double)(C * 9/5) + 32;
        double K = (double)C + 273.15;
        System.out.println("Los grados en Kelvin son "+ K + "K");
        System.out.println("Los grados en son Fahrenheit "+ F +"°F");
        sc.close();
    }
}