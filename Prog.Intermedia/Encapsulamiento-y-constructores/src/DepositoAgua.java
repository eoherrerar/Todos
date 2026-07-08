public class DepositoAgua {

    private double capacidad;
    private double volumenActual;
    private DepositoAgua depositoDesborde;

    // Constructor vacío
    public DepositoAgua() {

    }

    // Constructor con capacidad
    public DepositoAgua(double capacidad) {
        this.capacidad = capacidad;
        this.volumenActual = 0;
        this.depositoDesborde = null;
    }

    // Constructor completo
    public DepositoAgua(double capacidad, double volumenActual) {
        this.capacidad = capacidad;
        this.volumenActual = volumenActual;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {

        if (capacidad > 0) {
            this.capacidad = capacidad;
        } else {
            System.out.println("Capacidad invalida");
        }

    }

    public double getVolumenActual() {
        return volumenActual;
    }

    public void setVolumenActual(double volumenActual) {
        this.volumenActual = volumenActual;
    }

    public DepositoAgua getDepositoDesborde() {
        return depositoDesborde;
    }

    public void setDepositoDesborde(DepositoAgua depositoDesborde) {
        this.depositoDesborde = depositoDesborde;
    }

    public void mostrarEstado() {

        System.out.println("Capacidad: " + capacidad);
        System.out.println("Volumen actual: " + volumenActual);
        System.out.println("Espacio libre: " + (capacidad - volumenActual));

    }

    public void agregarAgua(double cantidad) {

        volumenActual += cantidad;

        if (volumenActual > capacidad) {

            double sobrante = volumenActual - capacidad;

            volumenActual = capacidad;

            if (depositoDesborde != null) {

                depositoDesborde.agregarAgua(sobrante);

            } else {

                System.out.println("No hay deposito conectado");

            }

        }

    }

    public void quitarAgua(double cantidad) {

        if (cantidad <= volumenActual) {

            volumenActual -= cantidad;

        } else {

            volumenActual = 0;

            System.out.println("No habia suficiente agua");

        }

    }

}