package co.edu.uniquindio.poo.model;

import java.util.Date;

public class Auto extends Vehiculo {

    private int numPuertas;
    
    public Auto(String numMatricula, String marca, String modelo, Date añoFabri, int numPuertas) {
        super(numMatricula, marca, modelo, añoFabri);
        this.numPuertas = numPuertas;
    }


    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
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
