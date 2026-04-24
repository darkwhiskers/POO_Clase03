package com.darkwhiskers.main;

import com.darkwhiskers.animales.Animal;
import com.darkwhiskers.animales.Gato;
import com.darkwhiskers.animales.Mamifero;
import com.darkwhiskers.figuras.Circulo;
import com.darkwhiskers.figuras.Cuadrado;
import com.darkwhiskers.figuras.Figura;
import com.darkwhiskers.figuras.Triangulo;
import com.darkwhiskers.vehiculos.Auto;
import com.darkwhiskers.vehiculos.Avion;
import com.darkwhiskers.vehiculos.Barco;
import java.io.PrintStream;

/**
 * Punto de entrada de la Clase 03 — POO: Herencia.
 *
 * <p>Integra y ejecuta todos los ejemplos de la presentación:</p>
 * <ol>
 *   <li>Sobrescritura de métodos: {@link Animal}, {@link Mamifero}, {@link Gato}.</li>
 *   <li>Herencia con {@code protected} y {@code super()}: jerarquía de {@link Vehiculo}.</li>
 *   <li>Clases abstractas: jerarquía de {@link Figura}.</li>
 *   <li>Palabra clave {@code final}: se documenta pero no puede mostrarse como herencia.</li>
 *   <li>Ejercicio Level 3: jerarquía de {@link banco.CuentaBancaria}.</li>
 *   <li>Ejercicio PLUS: jerarquía de {@link rpg.Personaje} (La Arena de Aetherfall).</li>
 * </ol>
 *
 * @author  Mamba & Mike
 * @version 1.0
 * @since   2026
*/
public class Main {

    public static void main(String[] args) throws Exception {
        
        // Con este objeto podemos mosttrar los caracteres propios de ASCCI,
        // es decir, letras con tildes y caracteres especiales.
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        
        
        // =============================================================
        // 1. SOBRESCRITURA DE MÉTODOS
        // =============================================================
        
        System.out.println("========== 1. SOBRESCRITURA DE MÉTODOS ==========");
 
        Animal animal = new Animal("Animal genérico");
        Mamifero mamifero = new Mamifero("León");
        Gato mamba = new Gato("Mamba",  "¡Miau!");
        Gato siames = new Gato("Siamés", "Meow...");
 
        // Cada objeto responde distinto al mismo mensaje hacerSonido()
        animal.hacerSonido();
        mamifero.hacerSonido();  // llama a super.hacerSonido() + agrega mensaje
        mamba.hacerSonido();     // reemplaza completamente
        siames.hacerSonido();
 
        System.out.println("\n--- Variable de tipo Animal apunta a un Gato ---");
        // Polimorfismo: la variable es de tipo Animal, el objeto es Gato
        Animal ref = new Gato("Pelusa", "Prrrr...");
        ref.hacerSonido(); // en runtime, llama al método de Gato
        
        
        // =============================================================
        // 2. HERENCIA CON protected Y super()
        // =============================================================
        
        System.out.println("\n========== 2. JERARQUÍA DE VEHÍCULOS ==========");
 
        Auto corolla = new Auto("Corolla", 180, 500, 4, "Blanco", "Toyota");
        Barco ferry  = new Barco("Santa Rosa", 35, 50000, 4.5, true);
        Avion boeing = new Avion("Boeing 737", 850, 20000, 12000, 2);
 
        corolla.mostrarDatos();
        corolla.arrancar();
        corolla.tocarBocina();
        corolla.desplazarse("Mar del Plata");
        corolla.detener();
 
        System.out.println();
        ferry.mostrarDatos();
        ferry.arrancar();
        ferry.anclar();
 
        System.out.println();
        boeing.mostrarDatos();
        boeing.despegar();
        boeing.desplazarse("Aeropuerto de Roma");
        boeing.aterrizar();
        
        
        // =============================================================
        // 3. CLASES ABSTRACTAS
        // =============================================================
        
        System.out.println("\n========== 3. CLASES ABSTRACTAS (Figuras) ==========");
 
        // new Figura(); ← ERROR de compilación: clase abstracta
        Figura cuadrado  = new Cuadrado(5.0);
        Figura circulo   = new Circulo(3.0);
        Figura triangulo = new Triangulo(4.0, 6.0);
 
        System.out.println(cuadrado);
        cuadrado.mostrarDatos();
 
        System.out.println(circulo);
        circulo.mostrarDatos();
 
        System.out.println(triangulo);
        triangulo.mostrarDatos();
 
        // Array de figuras: polimorfismo en acción
        System.out.println("\n--- Array de Figura (polimorfismo) ---");
        Figura[] figuras = { cuadrado, circulo, triangulo,
                             new Cuadrado(2.5), new Circulo(7.0) };
 
        for (Figura f : figuras) {
            System.out.printf("%-30s → Área: %7.2f | Perímetro: %7.2f%n",
                    f.toString(), f.calcularArea(), f.calcularPerimetro());
        }
        
        
        // =============================================================
        // 4. PALABRA CLAVE final
        // =============================================================
        
        System.out.println("\n========== 4. PALABRA CLAVE final ==========");
 
        final double PI = 3.14159;   // constante: no puede reasignarse
        // PI = 3.0;  ← ERROR de compilación
 
        System.out.println("Constante PI (final): " + PI);
        System.out.println("String y Integer son clases final: no pueden heredarse.\n");
        
        
        
        
    }

}
