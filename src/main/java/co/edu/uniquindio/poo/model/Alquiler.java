package co.edu.uniquindio.poo.model;

public class Alquiler {
    
    private String nomVehiculo;
    private String identificacion;
    private double diasAlquiler;
    Vehiculo vehiculo;
    Cliente cliente;
    private double costo;
    public Alquiler( String nomVehiculo, String identificacion, double diasAlquiler, Vehiculo vehiculo) {
        
        this.nomVehiculo = nomVehiculo;
        this.identificacion = identificacion;
        this.vehiculo = vehiculo;
        this.diasAlquiler = diasAlquiler;
        this.costo = vehiculo.calcularCosto(diasAlquiler);
    }

    public double getDiasAlquiler() {
        return diasAlquiler;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setDiasAlquiler(Double diasAlquiler) {
        this.diasAlquiler = diasAlquiler;
    }

    public String getNomVehiculo() {
        return nomVehiculo;
    }
    public void setNomVehiculo(String nomVehiculo) {
        this.nomVehiculo = nomVehiculo;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
}
