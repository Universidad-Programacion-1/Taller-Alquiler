package co.edu.uniquindio.poo.controller;
import java.util.Collection;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.model.Alquiler;
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

    public Vehiculo buscarVehiculo(String matricula){
        return empresa.buscarVehiculo(matricula);
    }
}