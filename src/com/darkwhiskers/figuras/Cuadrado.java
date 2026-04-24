
package com.darkwhiskers.figuras;

public class Cuadrado extends Figura {
    
    // ATRIBUTO:
    private final double lado;
    
    // CONSTRUCTOR:
    public Cuadrado(double lado) {
        this.lado = lado;
    }
    
    // GETTER:
    public double getLado() { return lado; }

    // MÉTODOS SOBRESCRITOS:
    @Override
    public double calcularArea() { return lado * lado; }
    @Override
    public double calcularPerimetro() { return 4 * lado; }
    
    // MÉTODO HEREDADO DE Object:
    @Override
    public String toString() {
        return "Cuadrado [lado=" + lado + "]";
    }

}
