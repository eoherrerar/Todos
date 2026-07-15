import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class Main extends Application {

    @FXML private TextField palabra; 
    @FXML private ComboBox<String> idiomaOrigen;
    @FXML private ComboBox<String> idiomaDestino;
    @FXML private ComboBox<String> idiomaTraduccion;
    @FXML private TextField palabraEspanol; 
    @FXML private TextField palabraTraducida; 
    @FXML private TextField ingles; 
    @FXML private TextField frances; 
    @FXML private TextField italiano;
    @FXML private TextField traduccion;

    @FXML private ComboBox<String> cbIdiomaAgregar;

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Traductor.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setTitle("Traductor");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    public void traducir() {
    }

    @FXML
    public void limpiar() {
    palabra.clear();
    idiomaOrigen.setValue(null);
    idiomaDestino.setValue(null);
    traduccion.clear();
}

    @FXML
    public void agregar() {
    }

    @FXML
    public void limpiarAgregar() {
    palabraEspanol.clear();
    palabraTraducida.clear();
    idiomaTraduccion.setValue(null);
}
}
