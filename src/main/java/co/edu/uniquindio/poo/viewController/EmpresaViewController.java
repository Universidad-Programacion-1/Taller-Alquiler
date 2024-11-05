package co.edu.uniquindio.poo.viewController;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EmpresaViewController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGestionarReserva;

    @FXML
    private Button btnGestionarVehiculo;

    @FXML
    private Button btnGestionarCliente;
    App app;
    
    @FXML
    void gestionarClienteAction() {
        app.openCrudCliente();
    }

    @FXML
    void gestionarVehiculoAction() {
        app.openMenuVehiculo();
    }
    @FXML
    void gestionarReservaAction() {

    }
    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
    }
}



    

