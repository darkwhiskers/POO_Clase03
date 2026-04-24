package com.darkwhiskers.figuras;

public class Circulo extends Figura {

    // ATRIBUTO:
    private final double radio;
    
    // CONSTRUCTOR:
    public Circulo(double radio) {
        this.radio = radio;
    }
    
    // GETTER:
    public double getRadio() { return radio; }
    
    // MÉTODOS SOBRESCRITOS:
    @Override
    public double calcularArea() { return Math.PI * radio * radio; }
    @Override
    public double calcularPerimetro() { return 2 * Math.PI * radio; }
    
    // MÉTODO HEREDADO DE Object:
    @Override
    public String toString() {
        return "Circulo [radio=" + radio + "]";
    }

}
