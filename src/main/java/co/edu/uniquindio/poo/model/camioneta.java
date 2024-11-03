package co.edu.uniquindio.poo.model;

import java.util.Date;

public class Camioneta extends Vehiculo{
    
    private double cargaToneladas;

    public Camioneta(String numMatricula, String marca, String modelo, Date añoFabri, double cargaToneladas) {
        super(numMatricula, marca, modelo, añoFabri);
        this.cargaToneladas = cargaToneladas;
    }

    public double getCargaToneladas() {
        return cargaToneladas;
    }

    public void setCargaToneladas(double cargaToneladas) {
        this.cargaToneladas = cargaToneladas;
    }
    
    public double calcularCosto(){
        int valorTotal = 0;
        return valorTotal;
    }
}
