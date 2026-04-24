package com.darkwhiskers.figuras;

/**
 * Clase <b>abstracta</b> que representa una figura geométrica genérica.
 *
 * <p>Una clase abstracta:</p>
 * <ul>
 *   <li>Representa un <em>concepto incompleto</em>, pensado solo para ser heredado.</li>
 *   <li><strong>No puede instanciarse</strong> directamente con {@code new Figura()}.</li>
 *   <li>Puede tener métodos <em>abstractos</em> (sin cuerpo) y métodos <em>concretos</em>.</li>
 *   <li>Obliga a las subclases a implementar los métodos abstractos.</li>
 * </ul>
 *
 * <p>UML:</p>
 * <pre>
 *           «abstract»
 *            Figura
 *           /   |   \
 *      Cuadrado Circulo Triangulo
 * </pre>
 *
 * @author  Miguel Silva C.
 * @version 1.0
 * @since   2025
 */

// La clase es abstracta porque tiene métodos abstractos.
public abstract class Figura {

    // MÉTODOS ABSTRACTOS:
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    
    // MÉTODOS:
    public void mostrarDatos() {
        System.out.printf("  Área      : %.2f%n", calcularArea());
        System.out.printf("  Perímetro : %.2f%n", calcularPerimetro());
    }
}
