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

    @Override
    public double calcularCosto(double diasAlquiler){
        double toneladas = 100000;
        double valorTotal = 0;
        double tarifabase = 500000;
        valorTotal = tarifabase * diasAlquiler +(getCargaToneladas() * toneladas);
        return valorTotal;
    }
}
