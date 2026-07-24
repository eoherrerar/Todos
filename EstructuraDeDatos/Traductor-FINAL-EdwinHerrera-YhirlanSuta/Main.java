import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;



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
    @FXML private TextField buscarPalabra1;
    @FXML private ChoiceBox<String> idiomaBuscar1;
    @FXML private TextField resultadoEliminar;
    


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
                    new FXMLLoader(getClass()
                    .getResource("TraductorV3.fxml"));


            Parent root = loader.load();


            Scene scene =
                    new Scene(root);


            stage.setTitle("Traductor");


            stage.setScene(scene);


            stage.show();



        } catch(IOException e) {

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
                "Italiano"
        );


        idiomaDestino.getItems().addAll(
                "Español",
                "Inglés",
                "Francés",
                "Italiano"
        );


        idiomaTraduccion.getItems().addAll(
                "Inglés",
                "Francés",
                "Italiano"
        );


        idiomaBuscar.getItems().addAll(
                "Inglés",
                "Francés",
                "Italiano"
        );


        idiomaBuscar1.getItems().addAll(
                "Inglés",
                "Francés",
                "Italiano"
        );


        actualizarContadores();

    }
    @FXML
    public void traducir() {


    String texto = palabra.getText().trim();

    String origen = idiomaOrigen.getValue();

    String destino = idiomaDestino.getValue();



    if(texto.isEmpty() || origen == null || destino == null) {

        traduccion.setText("Complete los datos");
        return;

    }



    Traductor traductor =
            obtenerTraductor(origen, destino);



    if(traductor == null) {


        if(origen.equals(destino)) {

            traduccion.setText(texto);

        } else {

            traduccion.setText("No existe");

        }


        return;

    }



    traduccion.setText(
            traductor.verSignificado(texto)
    );

}




@FXML
public void agregar() {


    String esp =
            palabraEspanol.getText().trim();


    String tra =
            palabraTraducida.getText().trim();


    String idioma =
            idiomaTraduccion.getValue();



    if(esp.isEmpty() ||
       tra.isEmpty() ||
       idioma == null) {

        return;

    }



    Traductor traductor =
            obtenerTraductor(idioma);



    if(traductor != null) {


        boolean agregado =
                traductor.agregarPalabra(
                        new Traduccion(esp, tra)
                );



        if(agregado) {

            actualizarContadores();

            limpiarAgregar();

        }

    }

}






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



@FXML
public void buscar() {


    String palabraBuscar =
            buscarPalabra.getText().trim();


    String idioma =
            idiomaBuscar.getValue();



    if(palabraBuscar.isEmpty() ||
       idioma == null) {


        resultadoActualizar.setText(
                "Complete los datos"
        );

        return;

    }



    Traductor traductor =
            obtenerTraductor(idioma);



    Traduccion traduccionEncontrada =
            traductor.buscarPalabra(palabraBuscar
    );



    if(traduccionEncontrada != null) {


        nuevoEspanol.setText(
                traduccionEncontrada.verPalabra()
        );


        nuevoSignificado.setText(
                traduccionEncontrada.verSignificado()
        );


        resultadoActualizar.setText(
                "Encontrada"
        );


    } else {


        resultadoActualizar.setText(
                "No encontrada"
        );

    }

}

@FXML
public void actualizar() {


    String palabraActual =
        buscarPalabra.getText().trim();
        
        String nuevaPalabra =
        nuevoEspanol.getText().trim();
        String significadoNuevo =
        nuevoSignificado.getText().trim();
        String idioma =
        idiomaBuscar.getValue();




    if(palabraActual.isEmpty() ||nuevaPalabra.isEmpty() ||significadoNuevo.isEmpty() ||idioma == null){



        resultadoActualizar.setText(
                "Complete los datos"
        );

        return;
    }



    Traductor traductor =
            obtenerTraductor(idioma);



    boolean actualizado = traductor.modificarPalabra(palabraActual, nuevaPalabra, significadoNuevo);



    if(actualizado){


        resultadoActualizar.setText(
                "Actualizada"
        );


        buscarPalabra.clear();
        nuevoEspanol.clear();
        nuevoSignificado.clear();
        idiomaBuscar.setValue(null);


    }else{


        resultadoActualizar.setText(
                "No encontrada"
        );


    }

}




@FXML
public void eliminar() {


    String palabraEliminar =
            buscarPalabra1.getText().trim();


    String idioma =
            idiomaBuscar1.getValue();



    if(palabraEliminar.isEmpty() ||
       idioma == null) {


        resultadoEliminar.setText(
                "Complete los datos"
        );


        return;

    }



    Traductor traductor =obtenerTraductor(idioma);



    boolean eliminado = traductor.eliminarPalabra(palabraEliminar);



    if(eliminado) {


        resultadoEliminar.setText(
                "Eliminada"
        );


        buscarPalabra1.clear();

        idiomaBuscar1.setValue(null);


        actualizarContadores();



    } else {


        resultadoEliminar.setText(
                "No encontrada"
        );

    }

}




private void actualizarContadores() {


    ingles.setText(
            String.valueOf(
                traductorIngles.verTotalPalabras()
            )
    );


    frances.setText(
            String.valueOf(
                traductorFrances.verTotalPalabras()
            )
    );


    italiano.setText(
            String.valueOf(
                traductorItaliano.verTotalPalabras()
            )
    );

}



private Traductor obtenerTraductor(String idioma) {


    if(idioma.equals("Inglés"))
        return traductorIngles;


    if(idioma.equals("Francés"))
        return traductorFrances;


    if(idioma.equals("Italiano"))
        return traductorItaliano;


    return null;

}

private Traductor obtenerTraductor(
        String origen,
        String destino) {



    if(origen.equals("Español") &&
       destino.equals("Inglés"))

        return traductorIngles;



    if(origen.equals("Inglés") &&
       destino.equals("Español"))

        return traductorIngles;



    if(origen.equals("Español") &&
       destino.equals("Francés"))

        return traductorFrances;



    if(origen.equals("Francés") &&
       destino.equals("Español"))

        return traductorFrances;



    if(origen.equals("Español") &&
       destino.equals("Italiano"))

        return traductorItaliano;



    if(origen.equals("Italiano") &&
       destino.equals("Español"))

        return traductorItaliano;



    return null;

}
@FXML
public void buscarEliminar() {

    String palabra =
            buscarPalabra1.getText().trim();


    String idioma =
            idiomaBuscar1.getValue();



    if (palabra.isEmpty() || idioma == null) {

        resultadoEliminar.setText("Complete los datos");
        return;

    }



    Traductor traductor =
            obtenerTraductor(idioma);



    if (traductor == null) {

        resultadoEliminar.setText("Idioma inválido");
        return;

    }



    Traduccion encontrada =
            traductor.buscarPalabra(palabra);



    if (encontrada != null) {

        resultadoEliminar.setText("Encontrada");


    } else {

        resultadoEliminar.setText("No encontrada");

    }

}


}

