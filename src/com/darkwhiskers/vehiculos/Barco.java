package com.darkwhiskers.vehiculos;

public class Barco extends Vehiculo {

    // ATRIBUTOS PROPIOS:
    private final double calado;
    private final boolean conMotor;
    
    // CONSTRUCTOR:
    public Barco(String nombre, double velocidadMaxima, int capacidadCarga,
                 double calado, boolean conMotor) {
        super(nombre, velocidadMaxima, capacidadCarga, false);
        this.calado    = calado;
        this.conMotor  = conMotor;
    }
    
    // GETTERS:
    public double getCalado() { return calado; }
    public boolean isConMotor() { return conMotor; }

    // MÉTODOS PROPIOS:
    public void anclar() {
        detener(); // reutiliza el método heredado
        System.out.println("La embarcación " + nombre + " ha echado el ancla.");
    }
    
    // MÉTODO SOBRESCRITO:
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("  Calado    : " + calado + " m");
        System.out.println("  Con motor : " + conMotor);
    }
    
    // MÉTODO HEREDADO DE Object:
    @Override
    public String toString() {
        return "Barco [nombre=" + nombre + ", calado=" + calado
                + ", conMotor=" + conMotor + "]";
    }
}
