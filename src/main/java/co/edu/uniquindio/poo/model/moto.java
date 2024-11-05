package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Moto extends Vehiculo {
    private String tipoCaja;
    
    
    public Moto(String numMatricula, String marca, String modelo, LocalDate anoFabrica, String tipoCaja) {
        super(numMatricula, marca, modelo, anoFabrica);
        this.tipoCaja = tipoCaja;

    }
    
    public String getTipoCaja() {
        return tipoCaja;
    }

    public void setTipoCaja(String tipoCaja) {
        this.tipoCaja = tipoCaja;
    }
    @Override
    public double calcularCosto(double diasAlquiler){
        double valorTotal = 0.0;
        double tarifabase = 200.000;
        double tarifaAutomatica = 50.000;
        if(tipoCaja=="automatica"){
            valorTotal = tarifabase*diasAlquiler;
            valorTotal += tarifaAutomatica;
        }
        if(tipoCaja=="manual"){
            valorTotal = tarifabase*diasAlquiler;
        }
        return valorTotal;
    }

}