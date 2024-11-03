package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Auto;

public class AutoController {

    Empresa empresa;

    public AutoController(Empresa empresa) {
        this.empresa = empresa;
    }

    // public boolean crearAuto(Auto auto) {
    //     return empresa.agregarCliente(auto);
    // }

    // public Collection<Auto> obtenerListaAutos() {
    //     return empresa.getClientes();
    // }

    // public boolean eliminarAuto(String numMatricula) {
    //    return empresa.eliminarCliente(numMatricula);
    // }

    // public boolean actualizarAuto(String numMatricula, Auto auto) {
    //    return empresa.actualizarCliente(numMatricula, auto);
    // }
}
