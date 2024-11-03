package co.edu.uniquindio.poo.model;

import java.util.Date;

public abstract class Vehiculo {

    private String numMatricula;
    private String marca;
    private String modelo;
    private Date añoFabri;

    public Vehiculo(String numMatricula, String marca, String modelo, Date añoFabri) {
        this.numMatricula = numMatricula;
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabri = añoFabri;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getAñoFabri() {
        return añoFabri;
    }

    public void setAñoFabri(Date añoFabri) {
        this.añoFabri = añoFabri;
    }

    public abstract double calcularCosto();
}
