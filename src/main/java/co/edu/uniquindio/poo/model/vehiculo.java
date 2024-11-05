package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public abstract class Vehiculo {

    private String numMatricula;
    private String marca;
    private String modelo;
    private LocalDate anoFabrica;

    public Vehiculo(String numMatricula, String marca, String modelo, LocalDate anoFabrica) {
        this.numMatricula = numMatricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabrica = anoFabrica;
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

    public LocalDate getAnoFabrica() {
        return anoFabrica;
    }

    public void setAnoFabrica(LocalDate añoFabri) {
        this.anoFabrica = añoFabri;
    }

    public abstract double calcularCosto(double diasAlquiler);
}