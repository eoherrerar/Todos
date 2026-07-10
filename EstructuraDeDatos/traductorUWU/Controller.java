import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.util.HashMap;

public class Controller {

    @FXML
    private TextField txtPalabra;

    @FXML
    private TextField txtResultado;

    @FXML
    private ComboBox<String> cbOrigen;

    @FXML
    private ComboBox<String> cbDestino;

    @FXML
    private TextField txtEspanol;

    @FXML
    private TextField txtTraducida;

    @FXML
    private ComboBox<String> cbIdiomaAgregar;


    private HashMap<String, String> ingles = new HashMap<>();
    private HashMap<String, String> frances = new HashMap<>();
    private HashMap<String, String> italiano = new HashMap<>();


    // Se ejecuta al cargar la interfaz
    @FXML
    public void initialize() {

        cbOrigen.getItems().addAll(
                "Español"
        );

        cbDestino.getItems().addAll(
                "Inglés",
                "Francés",
                "Italiano"
        );


        cbIdiomaAgregar.getItems().addAll(
                "Inglés",
                "Francés",
                "Italiano"
        );


        // Diccionario inicial

        ingles.put("hola", "hello");
        ingles.put("casa", "house");
        ingles.put("perro", "dog");


        frances.put("hola", "bonjour");
        frances.put("casa", "maison");
        frances.put("perro", "chien");


        italiano.put("hola", "ciao");
        italiano.put("casa", "casa");
        italiano.put("perro", "cane");

    }


    // Botón Traducir
    @FXML
    public void traducir(ActionEvent event) {

        String palabra = txtPalabra.getText().toLowerCase();

        String idioma = cbDestino.getValue();


        String resultado = "";


        if (idioma.equals("Inglés")) {

            resultado = ingles.get(palabra);

        } else if (idioma.equals("Francés")) {

            resultado = frances.get(palabra);

        } else if (idioma.equals("Italiano")) {

            resultado = italiano.get(palabra);
        }


        if (resultado == null) {

            txtResultado.setText("No encontrada");

        } else {

            txtResultado.setText(resultado);
        }

    }



    // Botón Agregar
    @FXML
    public void agregar(ActionEvent event) {


        String palabra = txtEspanol.getText().toLowerCase();

        String traduccion = txtTraducida.getText();

        String idioma = cbIdiomaAgregar.getValue();



        if (idioma.equals("Inglés")) {

            ingles.put(palabra, traduccion);


        } else if (idioma.equals("Francés")) {

            frances.put(palabra, traduccion);


        } else if (idioma.equals("Italiano")) {

            italiano.put(palabra, traduccion);

        }


        limpiarAgregar();

    }



    // Botón Limpiar consulta
    @FXML
    public void limpiar(ActionEvent event) {

        txtPalabra.clear();
        txtResultado.clear();

    }



    // Limpia sección agregar
    public void limpiarAgregar() {

        txtEspanol.clear();
        txtTraducida.clear();

    }

}