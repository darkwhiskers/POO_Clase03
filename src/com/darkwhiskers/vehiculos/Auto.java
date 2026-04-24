package com.darkwhiskers.vehiculos;

public class Auto extends Vehiculo {

    // ATRIBUTOS PROPIOS:
    private final int puertas;
    private final String color;
    private final String marca;
    
    // CONSTRUCTOR:
    public Auto(String nombre, double velocidadMaxima, int capacidadCarga,
                int puertas, String color, String marca) {
        super(nombre, velocidadMaxima, capacidadCarga, false);
        this.puertas = puertas;
        this.color   = color;
        this.marca   = marca;
    }
    
    // GETTERS:
    public int getPuertas() { return puertas; }
    public String getColor() { return color; }
    public String getMarca() { return marca; }

    // MÉTODOS PROPIOS:
    public void tocarBocina() {
        System.out.println(nombre + " (" + marca + "): ¡Beep beep!");
    }
    
    // MÉTODO SOBRESCRITO:
    @Override
    public void mostrarDatos() {
        super.mostrarDatos(); // reutiliza el del padre
        System.out.println("  Marca   : " + marca);
        System.out.println("  Color   : " + color);
        System.out.println("  Puertas : " + puertas);
    }
    
    // MÉTODO HEREDADO DE Object:
    @Override
    public String toString() {
        return "Auto [nombre=" + nombre + ", marca=" + marca
                + ", color=" + color + ", puertas=" + puertas + "]";
    }
}
