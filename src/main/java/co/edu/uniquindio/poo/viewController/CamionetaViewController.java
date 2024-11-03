package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CamionetaViewController {

    @FXML
    private Button btAtras;

    @FXML
    private TextField txtCAnoFabrica;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TextField txtCMarca;

    @FXML
    private TableColumn<?, ?> tbcCModelo;

    @FXML
    private TextField txtCModelo;

    @FXML
    private TableColumn<?, ?> tbcCargaTonelasdas;

    @FXML
    private TableColumn<?, ?> tbcCAnoFabrica;

    @FXML
    private TextField txtCNumeroMatricula;

    @FXML
    private TableColumn<?, ?> tbcCMarca;

    @FXML
    private TableView<?> tblListCliente;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField txtCargaToneladas;

    @FXML
    private Button btnActualizarCamioneta;

    @FXML
    private TableColumn<?, ?> tbcCNumeroMatricula;

    @FXML
    private Button btbAgregarCamioneta;

    private App app;

    @FXML
    void onEliminar() {

    }

    @FXML
    void onLimpiar() {

    }

    @FXML
    void onAgregarCamioneta() {

    }

    @FXML
    void onActualizarCamioneta() {

    }

    @FXML
    void onOpenMenu(ActionEvent event) {
        app.openMenuVehiculo();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
