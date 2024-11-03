package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VehiculoViewController {

    @FXML
    private ResourceBundle resources;

    App app;
    @FXML
    private URL location;

    @FXML
    private Button btAtras;

    @FXML
    private Button btGestioAuto;

    @FXML
    private Label txtTitleVehiculos;

    @FXML
    private Button btGestioCamioneta;

    @FXML
    private Button btGestioMoto;

    @FXML
    void onOpenMenu() {
        app.onOpenCrudCamioneta();
    }

    @FXML
    void onOpenCrudMoto() {
        app.onOpenCrudCamioneta();
    }

    @FXML
    void onOpenCrudCamioneta() {
        app.onOpenCrudCamioneta();
    }

    @FXML
    void onOpenCrudAuto() {
        app.onOpenCrudAuto();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
  void initialize() {

  }
}
