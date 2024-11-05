package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Empresa {
    private String nombre;
    private Collection<Cliente> clientes;
    private Collection<Auto> autos;
    private Collection<Camioneta> camionetas;
    private Collection<Moto> motos;
    private Collection<Alquiler> alquilers;

    public Empresa(String nombre) {
        this.nombre = nombre;
        clientes = new LinkedList<>();
        autos = new LinkedList<>();
        camionetas = new LinkedList<>();
        motos = new LinkedList<>();
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

    public Collection<Auto> getAutos() {
        return autos;
    }

    public void setAutos(Collection<Auto> autos) {
        this.autos = autos;
    }

    public Collection<Camioneta> getCamionetas() {
        return camionetas;
    }

    public void setCamionetas(Collection<Camioneta> camionetas) {
        this.camionetas = camionetas;
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

    //Creacion de Camioneta
    public boolean agregarCamioneta(Camioneta camioneta) {
        boolean centinela = false;
        if (!verificarCamioneta(camioneta.getNumMatricula())) {
            camionetas.add(camioneta);
            centinela = true;
        }
        return centinela;
    }

    //Eliminacion de Camioneta
    public boolean eliminarCamioneta(String numMatricula) {
        boolean centinela = false;
        for (Camioneta camioneta : camionetas) {
            if (camioneta.getNumMatricula().equals(numMatricula)) {
                camionetas.remove(camioneta);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    //Actualizacion de Camioneta
    public boolean actualizarCamioneta(String numMatricula, Camioneta actualizado) {
        boolean centinela = false;
        for (Camioneta camioneta : camionetas) {
            if (camioneta.getNumMatricula().equals(numMatricula)) {
                camioneta.setNumMatricula(actualizado.getNumMatricula());
                camioneta.setMarca(actualizado.getMarca());
                camioneta.setModelo(actualizado.getModelo());
                camioneta.setAnoFabrica(actualizado.getAnoFabrica());
                camioneta.setCargaToneladas(actualizado.getCargaToneladas());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    //Verificaccion de Camioneta
    public boolean verificarCamioneta(String numMatricula) {
        boolean centinela = false;
        for (Camioneta camioneta : camionetas) {
            if (camioneta.getNumMatricula().equals(numMatricula)) {
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

    public Collection<Moto> getMotos() {
        return motos;
    }

    public void setMotos(Collection<Moto> motos) {
        this.motos = motos;
    }

    public Collection<Alquiler> getAlquilers() {
        return alquilers;
    }
    public void calcularCostoTotal(Vehiculo vehiculo, Alquiler alquiler){
        vehiculo.calcularCosto(alquiler.getDiasAlquiler());
    }


    
}