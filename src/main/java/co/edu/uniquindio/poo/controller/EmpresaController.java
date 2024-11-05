package co.edu.uniquindio.poo.controller;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmpresaController {

    private void loadInterface(String fxmlFile) {
        try {
            // Cargar el archivo FXML especificado
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            // Crear una nueva escena con la vista cargada
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToGestionClientes() {
        loadInterface("GestionClientes.fxml");
    }

    @FXML
    private void goToGestionVehiculo() {
        loadInterface("GestionVehiculo.fxml");
    }

    @FXML
    private void goToGestionReserva() {
        loadInterface("GestionReserva.fxml");
    }
}

    
    

