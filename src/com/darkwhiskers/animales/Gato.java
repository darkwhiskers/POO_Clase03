package com.darkwhiskers.animales;

public class Gato extends Mamifero {
    
    // ATRIBUTOS:
    private String maullido;

    public Gato(String nombre, String maullido) {
        super(nombre);
        this.maullido = maullido;
    }
    
    // GETTERS y SETTERS :
    public String getMaullido() { return maullido; }
    public void setMaullido(String maullido) { this.maullido = maullido; }
    
    // MÉTODO SOBRESCRITO:
    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: " + maullido);
    }
    
    // MÉTODOS HEREDADOS DE Object:
    @Override
    public String toString() {
        return "Gato [nombre=" + getNombre() + ", maullido=" + maullido + "]";
    }

}
