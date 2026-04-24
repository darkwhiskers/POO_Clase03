package com.darkwhiskers.animales;

/**
 * Superclase que representa a cualquier animal.
 *
 * <p>Demuestra el punto de partida de la <b>sobrescritura de métodos</b>:
 * define un comportamiento genérico ({@code hacerSonido}) que cada
 * subclase puede redefinir con su propia implementación.</p>
 *
 * @author  Miguel Silva C.
 * @version 1.0
 * @since   2025
 */

public class Animal {
    
    // ATRIBUTOS:
    private String nombre;

    // CONSTRUCTOR:
    public Animal(String nombre) {
        this.nombre = nombre;
    }

    // GETTERS y SETTERS :
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    // MÉTODOS:
    public void hacerSonido() {
        System.out.println("El " + nombre + " hace un sonido...");
    }

    // MÉTODOS HEREDADOS DE Object:
    @Override
    public String toString() {
        return "Animal [nombre=" + nombre + "]";
    }
}
