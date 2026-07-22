import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    @FXML private TextField buscarPalabra;

    @FXML private ChoiceBox<String> idiomaBuscar;
    @FXML private TextField nuevoEspanol;
    @FXML private TextField nuevoSignificado;
    @FXML private TextField resultadoActualizar;

    private Traductor traductorIngles =
            new Traductor(50, TipoDiccionario.ESPAÑOL_INGLES);

    private Traductor traductorFrances =
            new Traductor(50, TipoDiccionario.ESPAÑOL_FRANCES);

    private Traductor traductorItaliano =
            new Traductor(50, TipoDiccionario.ESPAÑOL_ITALIANO);

    @Override
    public void start(Stage stage) {

        try {

            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("TraductorV2.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);

            stage.setTitle("Traductor");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    public void initialize() {

        idiomaOrigen.getItems().addAll(
                "Español",
                "Inglés",
                "Francés",
                "Italiano");

        idiomaDestino.getItems().addAll(
                "Español",
                "Inglés",
                "Francés",
                "Italiano");

        idiomaTraduccion.getItems().addAll(
                "Inglés",
                "Francés",
                "Italiano");

        idiomaBuscar.getItems().addAll(
                "Inglés",
                "Francés",
                "Italiano");

        actualizarContadores();

    }

    @FXML
    public void traducir() {

        String texto = palabra.getText();

        String origen = idiomaOrigen.getValue();

        String destino = idiomaDestino.getValue();

        if (texto.isEmpty() || origen == null || destino == null) {

            traduccion.setText("Complete los datos");
            return;
        }

        Traductor t = obtenerTraductor(origen, destino);

        if (t == null) {

            if (origen.equals(destino))
                traduccion.setText(texto);
            else
                traduccion.setText("No existe");

            return;
        }

        traduccion.setText(t.verSignificado(texto));

    }



    @FXML
    public void agregar() {

        String esp = palabraEspanol.getText();

        String tra = palabraTraducida.getText();

        String idioma = idiomaTraduccion.getValue();

        if (esp.isEmpty() || tra.isEmpty() || idioma == null)
            return;

        Traductor t = obtenerTraductor(idioma);

        if (t != null) {

            if (t.agregarPalabra(new Traduccion(esp, tra))) {

                actualizarContadores();

                limpiarAgregar();

            }

        }

    }

    //================== LIMPIAR ==================

    @FXML
    public void limpiarConsulta() {

        palabra.clear();

        traduccion.clear();

        idiomaOrigen.setValue(null);

        idiomaDestino.setValue(null);

    }

    @FXML
    public void limpiarAgregar() {

        palabraEspanol.clear();

        palabraTraducida.clear();

        idiomaTraduccion.setValue(null);

    }

    //================== BUSCAR ==================

     @FXML
    public void buscar() {
    
        String palabra = buscarPalabra.getText().trim();
        String idioma = idiomaBuscar.getValue();
    
        if (palabra.isEmpty() || idioma == null) {
            resultadoActualizar.setText("Complete los datos");
            return;
        }
    
        Traductor traductor = obtenerTraductor(idioma);
    
        Traduccion t = traductor.buscarPalabra(palabra);
    
        if (t != null) {
    
            nuevoEspanol.setText(t.verPalabra());
            nuevoSignificado.setText(t.verSignificado());
            resultadoActualizar.setText("Encontrada");
    
        } else {
    
            resultadoActualizar.setText("No encontrada");
    
        }
    
    }


    //================== ACTUALIZAR ==================

    @FXML
    public void actualizar() {
    
        String palabra = nuevoEspanol.getText().trim();
        String significado = nuevoSignificado.getText().trim();
        String idioma = idiomaBuscar.getValue();
    
        if (palabra.isEmpty() || significado.isEmpty() || idioma == null) {
            resultadoActualizar.setText("Complete los datos");
            return;
        }
    
        Traductor traductor = obtenerTraductor(idioma);
    
        if (traductor == null) {
            resultadoActualizar.setText("Idioma inválido");
            return;
        }
    
        boolean actualizado = traductor.modificarPalabra(palabra, significado);
    
        if (actualizado) {
            resultadoActualizar.setText("Actualizada");
    
            // Limpia los campos
            buscarPalabra.clear();
            nuevoEspanol.clear();
            nuevoSignificado.clear();
            idiomaBuscar.setValue(null);
    
        } else {
            resultadoActualizar.setText("Palabra no encontrada");
        }
    }


    //================== CONTADORES ==================

    private void actualizarContadores() {

        ingles.setText(String.valueOf(
                traductorIngles.verTotalPalabras()));

        frances.setText(String.valueOf(
                traductorFrances.verTotalPalabras()));

        italiano.setText(String.valueOf(
                traductorItaliano.verTotalPalabras()));

    }

    //================== OBTENER TRADUCTOR ==================

    private Traductor obtenerTraductor(String idioma) {

        if (idioma.equals("Inglés"))
            return traductorIngles;

        if (idioma.equals("Francés"))
            return traductorFrances;

        if (idioma.equals("Italiano"))
            return traductorItaliano;

        return null;

    }

    private Traductor obtenerTraductor(String origen,
                                       String destino) {

        if (origen.equals("Español") && destino.equals("Inglés"))
            return traductorIngles;

        if (origen.equals("Inglés") && destino.equals("Español"))
            return traductorIngles;

        if (origen.equals("Español") && destino.equals("Francés"))
            return traductorFrances;

        if (origen.equals("Francés") && destino.equals("Español"))
            return traductorFrances;

        if (origen.equals("Español") && destino.equals("Italiano"))
            return traductorItaliano;

        if (origen.equals("Italiano") && destino.equals("Español"))
            return traductorItaliano;

        return null;

    }

}
