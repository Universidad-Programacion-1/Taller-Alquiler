package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Camioneta extends Vehiculo{
    
    private Double cargaToneladas;

    public Camioneta(String numMatricula, String marca, String modelo, LocalDate añoFabri, double cargaToneladas) {
        super(numMatricula, marca, modelo, añoFabri);
        this.cargaToneladas = cargaToneladas;
    }

    public double getCargaToneladas() {
        return cargaToneladas;
    }

    public void setCargaToneladas(Double cargaToneladas) {
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
