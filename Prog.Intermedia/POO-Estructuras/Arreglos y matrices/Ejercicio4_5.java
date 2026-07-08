import java.util.Scanner;

public class Ejercicio4_5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] tablero = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        int fila, col;
        int turno = 0;
        boolean ganador = false;

        while (turno < 9 && !ganador) {

            imprimirTablero(tablero);

            char jugador = (turno % 2 == 0) ? 'X' : 'O';

            System.out.println("\nTurno jugador " + jugador);

            while (true) {

                System.out.print("Fila (0-2): ");
                fila = sc.nextInt();

                System.out.print("Columna (0-2): ");
                col = sc.nextInt();

                if (fila >= 0 && fila < 3 && col >= 0 && col < 3) {

                    if (tablero[fila][col] == ' ') {
                        break;
                    } else {
                        System.out.println("Casilla ocupada. Intente de nuevo.");
                    }

                } else {
                    System.out.println("Posición inválida.");
                }
            }

            tablero[fila][col] = jugador;

            ganador = verificarGanador(tablero, jugador);

            turno++;
        }

        imprimirTablero(tablero);

        if (ganador) {
            System.out.println("\n¡Gana el jugador!");
        } else {
            System.out.println("\nEmpate");
        }

        sc.close();
    }

    static void imprimirTablero(char[][] t) {

        System.out.println();

        for (int i = 0; i < 3; i++) {

            System.out.print(" ");

            for (int j = 0; j < 3; j++) {

                System.out.print(t[i][j]);

                if (j < 2) System.out.print(" | ");
            }

            System.out.println();

            if (i < 2) System.out.println("-----------");
        }
    }

    static boolean verificarGanador(char[][] t, char p) {

        // filas
        for (int i = 0; i < 3; i++) {
            if (t[i][0] == p && t[i][1] == p && t[i][2] == p)
                return true;
        }

        // columnas
        for (int j = 0; j < 3; j++) {
            if (t[0][j] == p && t[1][j] == p && t[2][j] == p)
                return true;
        }

        // diagonales
        if (t[0][0] == p && t[1][1] == p && t[2][2] == p)
            return true;

        if (t[0][2] == p && t[1][1] == p && t[2][0] == p)
            return true;

        return false;
    }
}
