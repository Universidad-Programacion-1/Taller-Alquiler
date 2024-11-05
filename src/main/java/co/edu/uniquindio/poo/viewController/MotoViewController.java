package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.MotoController;
import co.edu.uniquindio.poo.model.Moto;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MotoViewController {

    MotoController motoController;
    ObservableList<Moto> listMotos = FXCollections.observableArrayList();
    Moto selectedMoto;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAno;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TableColumn<Moto, String> tbcMarca;

    @FXML
    private Button btnActualizarMoto;

    @FXML
    private TextField txtModelo;

    @FXML
    private Button btnLimpiarMoto;

    @FXML
    private TableColumn<Moto, String> tbcPlaca;

    @FXML
    private TextField txtTipoCaja;

    @FXML
    private TableColumn<Moto, String> tbcTipoCaja;

    @FXML
    private TableColumn<Moto, String> tbcModelo;

    @FXML
    private TableView<Moto> tblListMoto;

    @FXML
    private Button btnEliminarMoto;

    @FXML
    private TableColumn<Moto, LocalDate> tbcAno;

    @FXML
    private TextField txtMarca;

    @FXML
    private Button btbAgregarMoto;

    private App app;

    @FXML
    void onEliminar() {
        eliminarMoto();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onAgregarMoto() {
        agregarMoto();
    }

    @FXML
    void onActualizarMoto() {
        actualizarMoto();
    }

    //@FXML
    //void onOpenMenu(ActionEvent event) {
    //    app.openMenuVehiculo();
    //}

    @FXML
    void initialize() {
        motoController = new MotoController(app.empresa);
        initView();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerMoto();

        // Limpiar la tabla
        tblListMoto.getItems().clear();

        // Agregar los elementos a la tabla
        tblListMoto.setItems(listMotos);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    
    private void initDataBinding() {
        tbcPlaca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumMatricula()));
        tbcMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        tbcModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        tbcAno.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getAnoFabrica()));
        tbcTipoCaja.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoCaja()));
        
    }

    private void obtenerMoto() {
        listMotos.addAll(motoController.obtenerListaMotos());
    }

    private void listenerSelection() {
        tblListMoto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedMoto = newSelection;
            mostrarInformacionMoto(selectedMoto);
        });
    }

    private void mostrarInformacionMoto(Moto moto) {
        if (moto != null) {
            txtPlaca.setText(moto.getNumMatricula());
            txtMarca.setText(moto.getMarca());
            txtModelo.setText(moto.getModelo());
            txtAno.setText(String.valueOf(moto.getAnoFabrica()));;
            txtTipoCaja.setText(String.valueOf(moto.getTipoCaja()));
        }
    }

    private void agregarMoto() {
        Moto moto = buildMoto();
        if (motoController.crearMoto(moto)) {
            listMotos.add(moto);
            limpiarCamposMoto();
        }
    }

    public Date parse(String dateString) throws ParseException {
         SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.parse(dateString);
    }
    
    private Moto buildMoto() {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // LocalDate fecha = LocalDate.parse(fechaTexto, formatter);
        Moto moto = new Moto(txtPlaca.getText(), txtMarca.getText(), txtModelo.getText(), LocalDate.parse(txtAno.getText()), txtTipoCaja.getText());
        return moto;
    }

    private void eliminarMoto() {
        if (motoController.eliminarMoto(txtPlaca.getText())) {
            listMotos.remove(selectedMoto);
            limpiarCamposMoto();
            limpiarSeleccion();
        }
    }

    private void actualizarMoto() {

        if (selectedMoto != null &&
                motoController.actualizarMoto(selectedMoto.getNumMatricula(), buildMoto())) {

            int index = listMotos.indexOf(selectedMoto);
            if (index >= 0) {
                listMotos.set(index, buildMoto());
            }

            tblListMoto.refresh();
            limpiarSeleccion();
            limpiarCamposMoto();
        }
    }

    private void limpiarSeleccion() {
        tblListMoto.getSelectionModel().clearSelection();
        limpiarCamposMoto();
    }

    private void limpiarCamposMoto() {
        txtPlaca.clear();
        txtMarca.clear();
        txtModelo.clear();
        txtAno.clear();
        txtTipoCaja.clear();
    }

    /**
     * @param app
     */
    public void setApp(App app) {
        this.app = app;
    }
}