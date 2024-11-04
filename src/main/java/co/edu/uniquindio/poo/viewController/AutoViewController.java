package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.AutoController;
import co.edu.uniquindio.poo.model.Auto;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AutoViewController {

    AutoController autoController;
    ObservableList<Auto> listAutos = FXCollections.observableArrayList();
    Auto selectedAuto;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btAtras;
    
    @FXML
    private TextField txtAnoFabrica;

    @FXML
    private TextField txtNumeroMatricula;

    @FXML
    private TableColumn<Auto, String> tbcMarca;

    @FXML
    private Button btnActualizarAuto;

    @FXML
    private TextField txtModelo;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableColumn<Auto, String> tbcNumeroMatricula;

    @FXML
    private TextField txtNumeroPuertas;

    @FXML
    private TableColumn<Auto, Double> tbcNumeroPuertas;

    @FXML
    private TableColumn<Auto, String> tbcModelo;

    @FXML
    private TableView<Auto> tblListAuto;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<Auto, String> tbcAnoFabrica;

    @FXML
    private TextField txtMarca;

    @FXML
    private Button btbAgregarAuto;

    private App app;

    @FXML
    void onEliminar() {
        eliminarAuto();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onAgregarAuto() {
        agregarAuto();
    }

    @FXML
    void onActualizarAuto() {
        actualizarAuto();
    }

    @FXML
    void onOpenMenu(ActionEvent event) {
        app.openMenuVehiculo();
    }

    @FXML
    void initialize() {
        autoController = new AutoController(app.empresa);
        initView();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerAutos();

        // Limpiar la tabla
        tblListAuto.getItems().clear();

        // Agregar los elementos a la tabla
        tblListAuto.setItems(listAutos);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcNumeroMatricula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumMatricula()));
        tbcMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        tbcModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        tbcAnoFabrica.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getAnoFabrica()));
        tbcNumeroPuertas.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getNumPuertas()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerAutos() {
        listAutos.addAll(autoController.obtenerListaAutos());
    }

    private void listenerSelection() {
        tblListAuto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedAuto = newSelection;
            mostrarInformacionAuto(selectedAuto);
        });
    }

    private void mostrarInformacionAuto(Auto auto) {
        if (auto != null) {
            txtNumeroMatricula.setText(auto.getNumMatricula());
            txtMarca.setText(auto.getMarca());
            txtModelo.setText(auto.getModelo());
            txtAnoFabrica.setText(String.valueOf(auto.getAnoFabrica()));;
            txtNumeroPuertas.setText(String.valueOf(auto.getNumPuertas()));
        }
    }

    private void agregarAuto() {
        Auto auto = buildAuto();
        if (autoController.crearAuto(auto)) {
            listAutos.add(auto);
            limpiarCamposAuto();
        }
    }

    // public Date parse(String dateString) throws ParseException {
    //     SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    //     return formatoFecha.parse(dateString);
    // }
    
    private Auto buildAuto() {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // LocalDate fecha = LocalDate.parse(fechaTexto, formatter);
        Auto auto = new Auto(txtNumeroMatricula.getText(), txtMarca.getText(), txtModelo.getText(), LocalDate.parse(txtAnoFabrica.getText()), Double.parseDouble(txtNumeroPuertas.getText()));
        return auto;
    }

    private void eliminarAuto() {
        if (autoController.eliminarAuto(txtNumeroMatricula.getText())) {
            listAutos.remove(selectedAuto);
            limpiarCamposAuto();
            limpiarSeleccion();
        }
    }

    private void actualizarAuto() {

        if (selectedAuto != null &&
                autoController.actualizarAuto(selectedAuto.getNumMatricula(), buildAuto())) {

            int index = listAutos.indexOf(selectedAuto);
            if (index >= 0) {
                listAutos.set(index, buildAuto());
            }

            tblListAuto.refresh();
            limpiarSeleccion();
            limpiarCamposAuto();
        }
    }

    private void limpiarSeleccion() {
        tblListAuto.getSelectionModel().clearSelection();
        limpiarCamposAuto();
    }

    private void limpiarCamposAuto() {
        txtNumeroMatricula.clear();
        txtMarca.clear();
        txtModelo.clear();
        txtAnoFabrica.clear();
        txtNumeroPuertas.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }

}
