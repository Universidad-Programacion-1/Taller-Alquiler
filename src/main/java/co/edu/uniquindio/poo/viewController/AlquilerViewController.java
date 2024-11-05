package co.edu.uniquindio.poo.viewController;
import javafx.beans.property.SimpleObjectProperty;
import co.edu.uniquindio.poo.App;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import co.edu.uniquindio.poo.controller.AlquilerController;
import co.edu.uniquindio.poo.model.Alquiler;
import co.edu.uniquindio.poo.model.Vehiculo;
public class AlquilerViewController {
    AlquilerController alquilerController;
    ObservableList<Alquiler> listAlquilers = FXCollections.observableArrayList();
    Alquiler selectedAlquiler;

    @FXML
    private TextField rtxVehiculo;

    @FXML
    private Button btbEliminarVehiculo;

    @FXML
    private TableColumn<Alquiler, String> tbcVehiculo;

    @FXML
    private Button btbAlquilerVehiculo;

    @FXML
    private TableColumn<Alquiler, Double> tbcDiasReservado;

    @FXML
    private TextField rtxIdentificacion;

    @FXML
    private Button btbLimpiarVehiculo;

    @FXML
    private TableColumn<Alquiler, String> tbcIdentificacion;

    @FXML
    private TableColumn<Vehiculo, Double> tbcCosto;

    @FXML
    private TextField rtxPlaca;
    

    @FXML
    private TableView<Alquiler> tblListAlquilerVehiculo;
    
    @FXML
    private TableColumn<Vehiculo, String> tbcPlaca;

    @FXML
    private TextField rtxDiasReservado;

    @FXML
    private Button btbActualizarVehiculo;
    private App app;

    @FXML
    void onEliminar() {
        eliminarAlquiler();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onAgregarAlquiler() {
        agregarAlquiler();
    }

    @FXML
    void onActualizarAlquiler() {
        actualizarAlquiler();
    }

    //@FXML
    //void onOpenMenu(ActionEvent event) {
    //    app.openMenuVehiculo();
    //}

    @FXML
    void initialize() {
        alquilerController = new AlquilerController(app.empresa);
        initView();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerAlquiler();

        // Limpiar la tabla
        tblListAlquilerVehiculo.getItems().clear();

        // Agregar los elementos a la tabla
        tblListAlquilerVehiculo.setItems(listAlquilers);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    
    private void initDataBinding() {
        tbcIdentificacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        tbcPlaca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumMatricula()));
        tbcDiasReservado.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDiasAlquiler()));
        tbcVehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomVehiculo()));
        //tbcCosto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().ge()));
        
        
        
    }

    private void obtenerAlquiler() {
        listAlquilers.addAll(alquilerController.obtenerListaAlquilers());
    }

    private void listenerSelection() {
        tblListAlquilerVehiculo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedAlquiler = newSelection;
            mostrarInformacionAlquiler(null, newSelection);
        });
    }

    private void mostrarInformacionAlquiler(Vehiculo vehiculo, Alquiler alquiler) {
        if (alquiler != null) {
            rtxIdentificacion.setText(alquiler.getIdentificacion());
            rtxPlaca.setText(vehiculo.getNumMatricula());
            rtxVehiculo.setText(alquiler.getNomVehiculo());
            rtxDiasReservado.setText(String.valueOf(alquiler.getDiasAlquiler()));
        }
    }

    private void agregarAlquiler() {
        Alquiler alquiler = buildAlquiler();
        if (alquilerController.crearAlquiler(alquiler)) {
            listAlquilers.add(alquiler);
            limpiarCamposAlquiler();
        }
    }

    private Alquiler buildAlquiler() {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // LocalDate fecha = LocalDate.parse(fechaTexto, formatter);
        Alquiler alquiler = new Alquiler(rtxDiasReservado.getText(), rtxIdentificacion.getText(), rtxPlaca.getText(),  rtxVehiculo.getText());
        return alquiler;
    }

    private void eliminarAlquiler() {
        if (alquilerController.eliminarAlquiler(rtxIdentificacion.getText())) {
            listAlquilers.remove(selectedAlquiler);
            limpiarCamposAlquiler();
            limpiarSeleccion();
        }
    }

    private void actualizarAlquiler() {

        if (selectedAlquiler != null &&
                AlquilerController.actualizarAlquiler(selectedAlquiler.getNomVehiculo(), buildAlquiler())) {

            int index = listAlquilers.indexOf(selectedAlquiler);
            if (index >= 0) {
                listAlquilers.set(index, buildAlquiler());
            }

            tblListAlquilerVehiculo.refresh();
            limpiarSeleccion();
            limpiarCamposAlquiler();
        }
    }

    private void limpiarSeleccion() {
        tblListAlquilerVehiculo.getSelectionModel().clearSelection();
        limpiarCamposAlquiler();
    }

    private void limpiarCamposAlquiler() {
        rtxPlaca.clear();
        rtxIdentificacion.clear();
        rtxVehiculo.clear();
        rtxDiasReservado.clear();
        //tbcCosto.clear();
    }

    /**
     * @param app
     */
    public void setApp(App app) {
        this.app = app;
    }

}