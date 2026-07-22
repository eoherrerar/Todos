import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.IOException;

public class Main extends Application {

    @FXML private TextField palabra;
    @FXML private ChoiceBox<String> idiomaOrigen;
    @FXML private ChoiceBox<String> idiomaDestino;
    @FXML private TextField traduccion;

    @FXML private TextField palabraEspanol;
    @FXML private TextField palabraTraducida;
    @FXML private ChoiceBox<String> idiomaTraduccion;

    @FXML private TextField ingles;
    @FXML private TextField frances;
    @FXML private TextField italiano;

    private Traductor traductorIngles = new Traductor(50, TipoDiccionario.ESPAÑOL_INGLES);
    private Traductor traductorFrances = new Traductor(50, TipoDiccionario.ESPAÑOL_FRANCES);
    private Traductor traductorItaliano = new Traductor(50, TipoDiccionario.ESPAÑOL_ITALIANO);

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Traductor.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 500);
            primaryStage.setTitle("App generada por : Edwin Herrera");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Error loading FXML file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        if (idiomaOrigen != null) {
            idiomaOrigen.getItems().addAll("Español", "Inglés", "Francés", "Italiano");
        }
        if (idiomaDestino != null) {
            idiomaDestino.getItems().addAll("Español", "Inglés", "Francés", "Italiano");
        }
        if (idiomaTraduccion != null) {
            idiomaTraduccion.getItems().addAll("Inglés", "Francés", "Italiano");
        }

        actualizarContadores();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    public void traducir() {
        String textoBusqueda = palabra.getText();
        String origen = idiomaOrigen.getValue();
        String destino = idiomaDestino.getValue();

        if (textoBusqueda == null || textoBusqueda.trim().isEmpty() || origen == null || destino == null) {
            traduccion.setText("Seleccione opciones válidas");
            return;
        }

        Traductor traductorSeleccionado = obtenerTraductorPorIdioma(origen, destino);

        if (traductorSeleccionado != null) {
            String resultado = traductorSeleccionado.verSignificado(textoBusqueda);
            traduccion.setText(resultado);
        } else if (origen.equals(destino)) {
            traduccion.setText(textoBusqueda);
        } else {
            traduccion.setText("No existe en el diccionario");
        }
    }

    @FXML
    public void agregar() {
        String word = palabraEspanol.getText();
        String translate = palabraTraducida.getText();
        String idioma = idiomaTraduccion.getValue();

        if (idioma == null) return;

        Traductor traductorObjetivo = null;
        if (idioma.equalsIgnoreCase("Inglés")) traductorObjetivo = traductorIngles;
        else if (idioma.equalsIgnoreCase("Francés")) traductorObjetivo = traductorFrances;
        else if (idioma.equalsIgnoreCase("Italiano")) traductorObjetivo = traductorItaliano;

        if (traductorObjetivo != null) {
            boolean resultado = traductorObjetivo.agregarPalabra(new Traduccion(word, translate));
            if (resultado) {
                actualizarContadores();
                limpiarAgregar();
            }
        }
    }

    @FXML
    public void limpiarConsulta() {
        palabra.setText("");
        traduccion.setText("");
        if (idiomaOrigen != null) idiomaOrigen.setValue(null);
        if (idiomaDestino != null) idiomaDestino.setValue(null);
    }

    @FXML
    public void limpiarAgregar() {
        palabraEspanol.setText("");
        palabraTraducida.setText("");
        if (idiomaTraduccion != null) idiomaTraduccion.setValue(null);
    }

    private void actualizarContadores() {
        if (ingles != null) ingles.setText(String.valueOf(traductorIngles.verTotalPalabras()));
        if (frances != null) frances.setText(String.valueOf(traductorFrances.verTotalPalabras()));
        if (italiano != null) italiano.setText(String.valueOf(traductorItaliano.verTotalPalabras()));
    }

    private Traductor obtenerTraductorPorIdioma(String origen, String destino) {
        if (origen.equals("Español") && destino.equals("Inglés")) return traductorIngles;
        if (origen.equals("Inglés") && destino.equals("Español")) return traductorIngles;

        if (origen.equals("Español") && destino.equals("Francés")) return traductorFrances;
        if (origen.equals("Francés") && destino.equals("Español")) return traductorFrances;

        if (origen.equals("Español") && destino.equals("Italiano")) return traductorItaliano;
        if (origen.equals("Italiano") && destino.equals("Español")) return traductorItaliano;

        return null;
    }
}