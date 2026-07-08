import java.util.Scanner;
public class Nomina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre Del empleado");
        String empleado = sc.next();

        System.out.println("Horas trabajadas");
        double horas = sc.nextDouble();
        System.out.println("Cuanto vale la hora");
        double valor = sc.nextDouble();

        double salariob = horas * valor;
        double des = salariob  *0.08;
        double ret = salariob *0.05;
        double neto = salariob - (des + ret);

        System.out.println("el empleado es " + empleado);
        System.out.println("El salario es de " + salariob);
        System.out.println("El descuento ss de (8%) es de "+ des);
        System.out.println("La retencion (5%) es de "+ ret);
        System.out.println("El salario neto es de "+ neto);

        sc.close();


    }
}