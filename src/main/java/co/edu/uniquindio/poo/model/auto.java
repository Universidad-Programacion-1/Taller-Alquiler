package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.Date;

import javafx.scene.control.TextFormatter;

public class Auto extends Vehiculo {

    private Double numPuertas;
    
    public Auto(String numMatricula, String marca, String modelo, LocalDate añoFabri, double numPuertas) {
        super(numMatricula, marca, modelo, añoFabri);
        this.numPuertas = numPuertas;
    }


    public double getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(Double numPuertas) {
        this.numPuertas = numPuertas;
    }

    
    @Override
    public double calcularCosto(double diasAlquiler){
        double valorTotal = 0;
        double tarifabase = 300000;
        valorTotal = tarifabase * diasAlquiler;
        return valorTotal;
    }
}
