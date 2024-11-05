package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Moto;

public class MotoController {

    Empresa empresa;

    public MotoController(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean crearMoto(Moto moto) {
        return empresa.agregarMoto(moto);
    }

    public Collection<Moto> obtenerListaMotos() {
        return empresa.getMotos();
    }

    public boolean eliminarMoto(String numMatricula) {
       return empresa.eliminarMoto(numMatricula);
    }

    public boolean actualizarMoto(String numMatricula, Moto moto) {
       return empresa.actualizarMoto(numMatricula, moto);
    }
}
