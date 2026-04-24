package com.darkwhiskers.vehiculos;

public class Avion extends Vehiculo {
    
    // ATRIBUTOS PROPIOS:
    private final double alturaMaxima;
    private final int cantidadMotores;
    
    // CONSTRUCTOR:
    public Avion(String nombre, double velocidadMaxima, int capacidadCarga,
                 double alturaMaxima, int cantidadMotores) {
        super(nombre, velocidadMaxima, capacidadCarga, false);
        this.alturaMaxima     = alturaMaxima;
        this.cantidadMotores  = cantidadMotores;
    }
    
    // GETTERS:
    public double getAlturaMaxima() { return alturaMaxima; }
    public int getCantidadMotores() { return cantidadMotores; }

    // MÉTODOS PROPIOS:
    public void despegar() {
        arrancar(); // reutiliza el del padre
        System.out.println(nombre + " ha despegado. Altitud máxima: "
                + alturaMaxima + " m.");
    }
    public void aterrizar() {
        detener(); // reutiliza el del padre
        System.out.println(nombre + " ha aterrizado.");
    }
    
    // MÉTODO SOBRESCRITO:
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("  Altura máxima    : " + alturaMaxima + " m");
        System.out.println("  Cantidad motores : " + cantidadMotores);
    }
    
    // MÉTODO HEREDADO DE Object:
    @Override
    public String toString() {
        return "Avion [nombre=" + nombre + ", alturaMax=" + alturaMaxima
                + ", motores=" + cantidadMotores + "]";
    }
}
