import java.util.Scanner;
public class Tr1 {
    //PRUEBA DE ACTUALIZACION GITHUB
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la base y la altura");
        double base = sc.nextDouble();
        double altura = sc.nextDouble();
        double are = base * altura;
        double per = 2 + (base + altura);
        System.out.println("el area del rectangulo es "+ are );
        System.out.println("el perimetro del rectangulo es  "+ per );
        //
        System.out.println("ingrese el radio del circulo");
        double radio = sc.nextDouble();
        double area = Math.PI * (radio*radio); 
        double circu = 2 * Math.PI * radio;
        System.out.println("el area del circulo es "+ area );
        System.out.println("el circuferencia del circulo es "+ circu );
        sc.close();
    }
}