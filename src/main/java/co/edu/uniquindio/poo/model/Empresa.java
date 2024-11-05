package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Empresa {
    private String nombre;
    private Collection<Cliente> clientes;
    private Collection<Moto> motos;
    private Collection<Alquiler> alquilers;

    public Empresa(String nombre) {
        this.nombre = nombre;
        motos = new LinkedList<>();
        clientes = new LinkedList<>();
        alquilers = new LinkedList<>();
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
    /**
     * Se realizaron los diferentes metodos para la actualización de los datos en el sistema por parte de la clase moto
     * @param moto
     * @return
     */
    public boolean agregarMoto(Moto moto) {
        boolean centinela = false;
        if (!verificarMoto(moto.getNumMatricula())) {
            motos.add(moto);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarMoto(String numMatricula) {
        boolean centinela = false;
        for (Moto moto : motos) {
            if (moto.getNumMatricula().equals(numMatricula)) {
                motos.remove(moto);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarMoto(String numMatricula, Moto actualizado) {
        boolean centinela = false;
        for (Moto moto : motos) {
            if (moto.getNumMatricula().equals(numMatricula)) {
                moto.setNumMatricula(actualizado.getNumMatricula());
                moto.setMarca(actualizado.getMarca());
                moto.setModelo(actualizado.getModelo());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarMoto(String numMatricula) {
        boolean centinela = false;
        for (Moto moto : motos) {
            if (moto.getNumMatricula().equals(numMatricula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public Collection<Moto> getMotos() {
        return motos;
    }

    public void setMotos(Collection<Moto> motos) {
        this.motos = motos;
    }

    public Collection<Alquiler> getAlquilers() {
        return alquilers;
    }

    public void setAlquilers(Collection<Alquiler> alquilers) {
        this.alquilers = alquilers;
    }
    public boolean agregarAlquiler(Alquiler alquiler) {
        boolean centinela = false;
        if (!verificarAlquiler(alquiler.getIdentificacion())) {
            alquilers.add(alquiler);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarAlquiler(String identificacion) {
        boolean centinela = false;
        for (Alquiler alquiler : alquilers) {
            if (alquiler.getIdentificacion().equals(identificacion)) {
                alquilers.remove(alquiler);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarAlquiler(String identificacion, Alquiler actualizado) {
        boolean centinela = false;
        for (Alquiler alquiler : alquilers) {
            if (alquiler.getIdentificacion().equals(identificacion)) {
                alquiler.setNomVehiculo(actualizado.getNomVehiculo());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarAlquiler(String identificacion) {
        boolean centinela = false;
        for (Alquiler alquiler : alquilers) {
            if (alquiler.getIdentificacion().equals(identificacion)) {
                centinela = true;
            }
        }
        return centinela;
    }
}