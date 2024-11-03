package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AutoViewController {

    @FXML
    private Button btAtras;
    
    @FXML
    private TextField txtAnoFabrica;

    @FXML
    private TextField txtNumeroMatricula;

    @FXML
    private TableColumn<?, ?> tbcMarca;

    @FXML
    private Button btnActualizarAuto;

    @FXML
    private TextField txtModelo;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableColumn<?, ?> tbcNumeroMatricula;

    @FXML
    private TextField txtNumeroPuertas;

    @FXML
    private TableColumn<?, ?> tbcNumeroPuertas;

    @FXML
    private TableColumn<?, ?> tbcModelo;

    @FXML
    private TableView<?> tblListCliente;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<?, ?> tbcAnoFabrica;

    @FXML
    private TextField txtMarca;

    @FXML
    private Button btbAgregarAuto;

    private App app;

    @FXML
    void onEliminar() {

    }

    @FXML
    void onLimpiar() {

    }

    @FXML
    void onAgregarAuto() {

    }

    @FXML
    void onActualizarAuto() {

    }

    @FXML
    void onOpenMenu(ActionEvent event) {
        app.openMenuVehiculo();
    }

    public void setApp(App app) {
        this.app = app;
    }

}
