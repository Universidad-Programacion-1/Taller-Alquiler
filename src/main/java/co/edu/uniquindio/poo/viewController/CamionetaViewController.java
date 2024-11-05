package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.CamionetaController;
import co.edu.uniquindio.poo.model.Camioneta;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CamionetaViewController {

    CamionetaController camionetaController;
    ObservableList<Camioneta> listcamionetas = FXCollections.observableArrayList();
    Camioneta selectedcamioneta;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btAtras;

    @FXML
    private TextField txtCAnoFabrica;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TextField txtCMarca;

    @FXML
    private TableColumn<Camioneta, String> tbcCModelo;

    @FXML
    private TextField txtCModelo;

    @FXML
    private TableColumn<Camioneta, Double> tbcCargaTonelasdas;

    @FXML
    private TableColumn<Camioneta, String> tbcCAnoFabrica;

    @FXML
    private TextField txtCNumeroMatricula;

    @FXML
    private TableColumn<Camioneta, String> tbcCMarca;

    @FXML
    private TableView<Camioneta> tblListCamioneta;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField txtCargaToneladas;

    @FXML
    private Button btnActualizarCamioneta;

    @FXML
    private TableColumn<Camioneta, String> tbcCNumeroMatricula;

    @FXML
    private Button btbAgregarCamioneta;

    private App app;

    @FXML
    void onEliminar() {
        eliminarCamioneta();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onAgregarCamioneta() {
        agregarCamioneta();
    }

    @FXML
    void onActualizarCamioneta() {
        actualizarCamioneta();
    }

    @FXML
    void onOpenMenu() {
        app.openMenuVehiculo();
    }

    @FXML
    void initialize() {
        camionetaController = new CamionetaController(app.empresa);
        initView();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerCamioneta();

        // Limpiar la tabla
        tblListCamioneta.getItems().clear();

        // Agregar los elementos a la tabla
        tblListCamioneta.setItems(listcamionetas);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCNumeroMatricula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumMatricula()));
        tbcCMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        tbcCModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        tbcCAnoFabrica.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getAnoFabrica()));
        tbcCargaTonelasdas.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getCargaToneladas()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerCamioneta() {
        listcamionetas.addAll(camionetaController.obtenerListaCamioneta());
    }

    private void listenerSelection() {
        tblListCamioneta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedcamioneta = newSelection;
            mostrarInformacionCamioneta(selectedcamioneta);
        });
    }

    private void mostrarInformacionCamioneta(Camioneta camioneta) {
        if (camioneta != null) {
            txtCNumeroMatricula.setText(camioneta.getNumMatricula());
            txtCMarca.setText(camioneta.getMarca());
            txtCModelo.setText(camioneta.getModelo());
            txtCAnoFabrica.setText(String.valueOf(camioneta.getAnoFabrica()));;
            txtCargaToneladas.setText(String.valueOf(camioneta.getCargaToneladas()));
        }
    }

    private void agregarCamioneta() {
        Camioneta camioneta = buildCamioneta();
        if (camionetaController.crearCamioneta(camioneta)) {
            listcamionetas.add(camioneta);
            limpiarCamposCamioneta();
        }
    }
    
    private Camioneta buildCamioneta() {
        Camioneta camioneta = new Camioneta(txtCNumeroMatricula.getText(), txtCMarca.getText(), txtCModelo.getText(), LocalDate.parse(txtCAnoFabrica.getText()), Double.parseDouble(txtCargaToneladas.getText()));
        return camioneta;
    }

    private void eliminarCamioneta() {
        if (camionetaController.eliminarCamioneta(txtCNumeroMatricula.getText())) {
            listcamionetas.remove(selectedcamioneta);
            limpiarCamposCamioneta();
            limpiarSeleccion();
        }
    }

    private void actualizarCamioneta() {

        if (selectedcamioneta != null &&
                camionetaController.actualizarCamioneta(selectedcamioneta.getNumMatricula(), buildCamioneta())) {

            int index = listcamionetas.indexOf(selectedcamioneta);
            if (index >= 0) {
                listcamionetas.set(index, buildCamioneta());
            }

            tblListCamioneta.refresh();
            limpiarSeleccion();
            limpiarCamposCamioneta();
        }
    }

    private void limpiarSeleccion() {
        tblListCamioneta.getSelectionModel().clearSelection();
        limpiarCamposCamioneta();
    }

    private void limpiarCamposCamioneta() {
        txtCNumeroMatricula.clear();
        txtCMarca.clear();
        txtCModelo.clear();
        txtCAnoFabrica.clear();
        txtCargaToneladas.clear();
    }
    public void setApp(App app) {
        this.app = app;
    }
}
