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

    
    public double calcularCosto(){
        int valorTotal = 0;
        return valorTotal;
    }
}
