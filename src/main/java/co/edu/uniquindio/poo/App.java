package co.edu.uniquindio.poo;

import java.io.IOException;
import java.time.LocalDate;

import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.viewController.AutoViewController;
import co.edu.uniquindio.poo.viewController.CamionetaViewController;
import co.edu.uniquindio.poo.viewController.ClienteViewController;
import co.edu.uniquindio.poo.viewController.EmpresaViewController;
import co.edu.uniquindio.poo.viewController.PrimaryController;
import co.edu.uniquindio.poo.viewController.VehiculoViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    @SuppressWarnings("exports")
    public static Empresa empresa = new Empresa("UQ");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Gestion de Clientes");
        openCrudEmpresa();
    }

    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox) loader.load();
            PrimaryController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public void openCrudCliente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudCliente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ClienteViewController clienteViewController = loader.getController();
            clienteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudEmpresa() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudEmpresa.fxml"));
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox) loader.load();
            EmpresaViewController empresaViewController = loader.getController();
            empresaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //servicios

    public void inicializarData(){
        Cliente cliente = new Cliente("12233", "juan", "apellido");
        Auto auto = new Auto("1234", "YAMAHA", "2000", LocalDate.now(), 5);
        Camioneta camioneta = new Camioneta("12377", "HONDA", "2020", LocalDate.now(), 10);
        empresa.agregarCliente(cliente);
        empresa.agregarAuto(auto);
        empresa.agregarCamioneta(camioneta);
    }

    //REDIRECCION CARLOS

    public void openMenuVehiculo() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("menuVehiculo.fxml"));
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox) loader.load();
            //AnchorPane rootLayout = (AnchorPane) loader.load();
            VehiculoViewController vehiculoViewController = loader.getController();
            vehiculoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void onOpenCrudAuto() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudAuto.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AutoViewController autoViewController = loader.getController();
            autoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void onOpenCrudCamioneta() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudCamioneta.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            CamionetaViewController camionetaViewController = loader.getController();
            camionetaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}