package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Empresa {
    private String nombre;
    private Collection<Cliente> clientes;
    private Collection<Auto> autos;

    public Empresa(String nombre) {
        this.nombre = nombre;
        clientes = new LinkedList<>();
        autos = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Collection<Auto> getAutos() {
        return autos;
    }

    public void setAutos(Collection<Auto> autos) {
        this.autos = autos;
    }

    public boolean agregarCliente(Cliente cliente) {
        boolean centinela = false;
        if (!verificarCliente(cliente.getCedula())) {
            clientes.add(cliente);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                clientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setCedula(actualizado.getCedula());
                cliente.setNombre(actualizado.getNombre());
                cliente.setApellido(actualizado.getApellido());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    //Creacion de Auto
    public boolean agregarAuto(Auto auto) {
        boolean centinela = false;
        if (!verificarAuto(auto.getNumMatricula())) {
            autos.add(auto);
            centinela = true;
        }
        return centinela;
    }

    //Eliminacion de Auto
    public boolean eliminarAuto(String numMatricula) {
        boolean centinela = false;
        for (Auto auto : autos) {
            if (auto.getNumMatricula().equals(numMatricula)) {
                autos.remove(auto);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    //Actualizacion de Auto
    public boolean actualizarAuto(String numMatricula, Auto actualizado) {
        boolean centinela = false;
        for (Auto auto : autos) {
            if (auto.getNumMatricula().equals(numMatricula)) {
                auto.setNumMatricula(actualizado.getNumMatricula());
                auto.setMarca(actualizado.getMarca());
                auto.setModelo(actualizado.getModelo());
                auto.setAnoFabrica(actualizado.getAnoFabrica());
                auto.setNumPuertas(actualizado.getNumPuertas());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    //Verificaccion de Auto
    public boolean verificarAuto(String numMatricula) {
        boolean centinela = false;
        for (Auto auto : autos) {
            if (auto.getNumMatricula().equals(numMatricula)) {
                centinela = true;
            }
        }
        return centinela;
    }
}