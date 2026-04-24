package com.darkwhiskers.vehiculos;

/**
 * Superclase que representa a cualquier vehículo.
 *
 * <p>Demuestra el uso de atributos {@code protected}: visibles en
 * la propia clase y en todas sus subclases, pero no desde afuera.</p>
 *
 * <p>Jerarquía:</p>
 * <pre>
 *            Vehiculo
 *           /   |    \   \
 *        Auto Barco Avion BestiaDeCarga
 * </pre>
 *
 * @author  Miguel Silva C.
 * @version 1.0
 * @since   2025
 */

public class Vehiculo {

    // ATRIBUTOS:
     protected String nombre;
     protected double velocidadMaxima;
     protected int capacidadCarga;
     protected boolean enMovimiento;
    
    // CONSTRUCTOR:
    public Vehiculo(String nombre, double velocidadMaxima,
                    int capacidadCarga, boolean enMovimiento) {
        this.nombre          = nombre;
        this.velocidadMaxima = velocidadMaxima;
        this.capacidadCarga  = capacidadCarga;
        this.enMovimiento    = enMovimiento;
    }

    // MÉTODOS:
    public void arrancar() {
        enMovimiento = true;
        System.out.println(nombre + " arrancando...");
    }
    
    public void desplazarse(String destino) {
        if (enMovimiento) {
            System.out.println("El vehículo " + nombre + " está desplazándose hacia: " + destino);
        } else {
            System.out.println("El vehículo " + nombre + " no puede desplazarse: está detenido.");
        }
    }
    
    public void detener() {
        enMovimiento = false;
        System.out.println(nombre + " detenido.");
    }
    
    public void mostrarDatos() {
        System.out.println("=== " + nombre + " ===");
        System.out.println("  Velocidad máxima : " + velocidadMaxima + " km/h");
        System.out.println("  Capacidad carga  : " + capacidadCarga  + " kg");
        System.out.println("  En movimiento    : " + enMovimiento);
    }
    
    // MÉTODO HEREDADO DE Object:
    @Override
    public String toString() {
        return "Vehiculo [nombre=" + nombre
                + ", velMax=" + velocidadMaxima
                + ", carga=" + capacidadCarga
                + ", enMovimiento=" + enMovimiento + "]";
    }
}
