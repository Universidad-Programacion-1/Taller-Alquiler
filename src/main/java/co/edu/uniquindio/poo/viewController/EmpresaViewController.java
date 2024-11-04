package co.edu.uniquindio.poo.viewController;
import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EmpresaViewController {

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
    
    }
    public void setApp(App app) {
        this.app = app;
    }
}



    

