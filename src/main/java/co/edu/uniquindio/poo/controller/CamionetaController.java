package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;

public class CamionetaController {

    Empresa empresa;

    public CamionetaController(Empresa empresa) {
        this.empresa = empresa;
    }

    // public boolean crearCamioneta(Camioneta camioneta) {
    //     return empresa.agregarCliente(camioneta);
    // }

    // public Collection<Camioneta> obtenerListaCamioneta() {
    //     return empresa.getClientes();
    // }

    // public boolean eliminarCamioneta(String numMatricula) {
    //    return empresa.eliminarCliente(numMatricula);
    // }

    // public boolean actualizarCamioneta(String numMatricula, Camioneta camioneta) {
    //    return empresa.actualizarCliente(numMatricula, camioneta);
    // }
}
