package com.darkwhiskers.figuras;

public class Triangulo extends Figura {

    // ATRIBUTO:
    private final double base;
    private final double altura;
    
    // CONSTRUCTOR:
     public Triangulo(double base, double altura) {
        this.base   = base;
        this.altura = altura;
    }
    
    // GETTER:
    public double getBase() { return base; }
    public double getAltura() { return altura; }
    
    // MÉTODOS SOBRESCRITOS:
    @Override
    public double calcularArea() { return (base * altura) / 2; }
    @Override
    public double calcularPerimetro() { 
        double hipotenusa = Math.sqrt(base * base + altura * altura);
        return base + altura + hipotenusa;
    }
    
    // MÉTODO HEREDADO DE Object:
    @Override
    public String toString() {
        return "Triangulo [base=" + base + ", altura=" + altura + "]";
    }
}
