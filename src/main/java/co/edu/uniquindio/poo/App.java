package co.edu.uniquindio.poo;

import java.io.IOException;
import java.time.LocalDate;



import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Moto;


import co.edu.uniquindio.poo.viewController.MotoViewController;
import co.edu.uniquindio.poo.viewController.PrimaryController;

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
    
    public static Empresa empresa = new Empresa("UQ");

    @SuppressWarnings("exports")
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Gestion de Clientes");
        openViewPrincipal();
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

    public void inicializarData(){
        Moto moto = new Moto("TAN11G", "YAMAHA", "2024", LocalDate.now(), "automatica"  );
        empresa.agregarMoto(moto);
        empresa.agregarMoto(moto);
    }

    
    public void OpenCrudMoto() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudCamioneta.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MotoViewController motoViewController = loader.getController();
            motoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}