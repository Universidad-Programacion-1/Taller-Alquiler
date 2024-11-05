package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Empresa;

public class CamionetaController {

    Empresa empresa;

    public CamionetaController(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean crearCamioneta(Camioneta camioneta) {
        return empresa.agregarCamioneta(camioneta);
    }

    public Collection<Camioneta> obtenerListaCamioneta() {
        return empresa.getCamionetas();
    }

    public boolean eliminarCamioneta(String numMatricula) {
        return empresa.eliminarCamioneta(numMatricula);
    }

    public boolean actualizarCamioneta(String numMatricula, Camioneta camioneta) {
        return empresa.actualizarCamioneta(numMatricula, camioneta);
    }
}
