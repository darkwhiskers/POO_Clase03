package com.darkwhiskers.animales;

public class Mamifero extends Animal {

    // CONSTRUCTOR:
    public Mamifero(String nombre) {
        super(nombre);
    }
    
    // MÉTODO SOBRESCRITO:
    @Override
    public void hacerSonido() {
        super.hacerSonido(); // primero ejecuta el del padre
        System.out.println("El sonido proviene de un mamífero.");
    }
    
    // MÉTODOS HEREDADOS DE Object:
    @Override
    public String toString() {
        return "Mamifero [nombre=" + getNombre() + "]";
    }

}
