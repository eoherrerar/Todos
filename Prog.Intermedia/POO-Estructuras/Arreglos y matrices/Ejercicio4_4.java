import java.util.Scanner;

public class Ejercicio4_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] ventas = new int[4][3];

        int[] totalSucursal = new int[4];
        int[] totalProducto = new int[3];

        int maxVenta = 0;
        int maxSucursal = 0;
        int maxProducto = 0;

        // Llenar matriz
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.print("Ingrese venta Sucursal " + (i + 1) +
                        ", Producto " + (j + 1) + ": ");

                ventas[i][j] = sc.nextInt();
            }
        }

        // Procesar datos
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {

                totalSucursal[i] += ventas[i][j];

                totalProducto[j] += ventas[i][j];

                if (ventas[i][j] > maxVenta) {
                    maxVenta = ventas[i][j];
                    maxSucursal = i;
                    maxProducto = j;
                }
            }
        }

        // Mostrar resultados
        System.out.println("\n--- Ventas por sucursal ---");

        for (int i = 0; i < 4; i++) {
            System.out.println("Sucursal " + (i + 1) + ": $ " + totalSucursal[i]);
        }

        System.out.println("\n--- Ventas por producto ---");

        for (int j = 0; j < 3; j++) {
            System.out.println("Producto " + (j + 1) + ": $ " + totalProducto[j]);
        }

        System.out.println("\nVenta más alta: $ " + maxVenta +
                " (Sucursal " + (maxSucursal + 1) +
                ", Producto " + (maxProducto + 1) + ")");

        sc.close();
    }
}