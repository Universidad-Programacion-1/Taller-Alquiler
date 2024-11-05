package co.edu.uniquindio.poo.controller;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.model.Alquiler;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;

public class AlquilerController {

    static Empresa empresa;
    Vehiculo vehiculo;
        Moto moto;
    
        public AlquilerController(Empresa empresa) {
            this.empresa = empresa;
        }
    
    
        public boolean crearAlquiler(Alquiler alquiler) {
            return empresa.agregarAlquiler(alquiler);
        }
    
        public Collection<Alquiler> obtenerListaAlquilers() {
            return empresa.getAlquilers();
        }
    
        public boolean eliminarAlquiler(String identificacion) {
           return empresa.eliminarAlquiler(identificacion);
        }
    
        public static boolean actualizarAlquiler(String identificacion, Alquiler alquiler) {
           return empresa.actualizarAlquiler(identificacion, alquiler);
    }
    private Map<String, Vehiculo> vehiculosDisponibles = new HashMap<>();

    public AlquilerController() {
        inicializarVehiculos();
    }

    private void inicializarVehiculos() {
        vehiculosDisponibles.put("ABC123", new Camioneta("ABC123", "Toyota", "Hilux", LocalDate.now(), 0));
        vehiculosDisponibles.put("XYZ456", new Auto("XYZ456", "Ford", "Focus", LocalDate.now(), 0));
        vehiculosDisponibles.put("MOT789", new Moto("MOT789", "Yamaha", "FZ", LocalDate.now(), "manual"));
        // Agrega más vehículos si es necesario
    }

    public Vehiculo buscarVehiculoPorPlaca(String numMatricula) {
        return vehiculosDisponibles.get(numMatricula);
    }
    public void registrarAlquiler(String numMatricula, Double diasAlquiler,String identificacion) {
        Vehiculo vehiculo = buscarVehiculoPorPlaca(numMatricula);
    
        if (vehiculo != null) {
            // Llama a calcularCosto pasando los días de alquiler directamente
            double costo = vehiculo.calcularCosto(diasAlquiler);
    
            // Agrega los datos del alquiler a la tabla
            agregarAlquilerATabla(numMatricula,identificacion, diasAlquiler, costo);
        } else {
            System.out.println("No se encontró un vehículo con la placa ingresada.");
        }
    }
    @FXML
    private TableView<Alquiler> miTabla; // Vinculado a la tabla en tu archivo FXML

    // Método que añade un registro de alquiler a la tabla
    public void agregarAlquilerATabla(String numMatricula, String identificacion, double diasAlquiler, double costo) {
        // Crea una nueva instancia de RegistroAlquiler con los datos proporcionados
        Alquiler registro = new Alquiler(identificacion, numMatricula, diasAlquiler, costo);

        // Agrega el nuevo registro a la tabla
        miTabla.getItems().add(registro);
    }
    

    
}
