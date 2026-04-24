# Clase 03: POO — Pilares y Herencia

Este repositorio contiene los ejemplos y ejercicios prácticos de la tercera sesión de Java,
enfocada en los **cuatro pilares de la POO** con desarrollo profundo del pilar de **Herencia**:
clases abstractas, sobrescritura de métodos, `super`, `final` y UML.

---

## Estructura del Proyecto

```
Clase03/
 ├── animales/
 │    ├── Animal.java           ← superclase (ejemplo sobrescritura)
 │    ├── Mamifero.java         ← subclase: usa super.hacerSonido()
 │    └── Gato.java             ← subclase: reemplaza completamente
 ├── vehiculos/
 │    ├── Vehiculo.java         ← superclase con atributos protected
 │    ├── Auto.java             ← subclase
 │    ├── Barco.java            ← subclase
 │    └── Avion.java            ← subclase
 ├── figuras/
 │    ├── Figura.java           ← clase abstracta
 │    ├── Cuadrado.java         ← implementa calcularArea() y calcularPerimetro()
 │    ├── Circulo.java          ← implementa calcularArea() y calcularPerimetro()
 │    └── Triangulo.java        ← implementa calcularArea() y calcularPerimetro()
 └── Principal.java             ← punto de entrada (main)
```

---

## Temas Tratados

### 1. Los Cuatro Pilares de la POO

La POO modela el software como un universo de objetos que interactúan.
Sus reglas se basan en cuatro pilares que **trabajan en conjunto**:

| Pilar | Definición |
|---|---|
| **Herencia** | Las clases hijas heredan atributos y métodos de las clases padre |
| **Encapsulamiento** | Protege los datos internos de manipulaciones no autorizadas |
| **Polimorfismo** | La misma orden enviada a varios objetos genera respuestas distintas |
| **Abstracción** | Proceso de definir solo los atributos y métodos relevantes de una clase |

---

### 2. Herencia


Permite crear nuevas clases reutilizando otras existentes. Modela la relación **"es un"** (IS-A).

- En Java es **simple**: una clase solo puede extender una única superclase.
- Usa la palabra reservada `extends`.
- Todas las clases heredan (directa o indirectamente) de `Object`.
- No existe herencia múltiple de clases, pero sí se pueden implementar múltiples interfaces.

**Terminología**

| Término | Significado |
|---|---|
| Superclase | Clase padre (más general) |
| Subclase | Clase hija (más específica) |
| `extends` | Palabra reservada para heredar |
| `super` | Referencia a la clase padre |

**Qué se hereda según el modificador de acceso**

| Modificador | ¿Hereda? | ¿Accede directamente la subclase? |
|---|---|---|
| `public` | ✅ | ✅ |
| `protected` | ✅ | ✅ |
| *(package)* | ✅ * | ✅ * |
| `private` | ✅ (existe) | ❌ Solo vía getters/setters |

**Práctica**


**Diagrama UML — Jerarquía de Vehículos**

```
              ┌───────────────────────────────────┐
              │           Vehiculo                │
              ├───────────────────────────────────┤
              │ # nombre: String                  │
              │ # velocidadMaxima: double         │
              │ # capacidadCarga: int             │
              │ # enMovimiento: boolean           │
              ├───────────────────────────────────┤
              │ + Vehiculo(String,double,int,bool)│
              │ + arrancar(): void                │
              │ + detener(): void                 │
              │ + desplazarse(String): void       │
              │ + mostrarDatos(): void            │
              └───────────────┬───────────────────┘
                              │
           ┌──────────────────┼──────────────────┐
           ▽                 ▽                  ▽
┌───────────────┐   ┌───────────────┐   ┌───────────────┐
│     Auto      │   │    Barco      │   │    Avion      │
├───────────────┤   ├───────────────┤   ├───────────────┤
│ - puertas:int │   │ - calado:dbl  │   │ - altMax:dbl  │
│ - color:String│   │ - conMotor:   │   │ - cantMot:int │
│ - marca:String│   │   boolean     │   ├───────────────┤
├───────────────┤   ├───────────────┤   │+despegar():vd │
│+tocarBocina() │   │+ anclar():vd  │   │+aterrizar():vd│
│+mostrarDatos()│   │+mostrarDatos()│   │+mostrarDatos()│
└───────────────┘   └───────────────┘   └───────────────┘
```

---

### 3. Constructor y `super()`


El constructor de una subclase **siempre llama** a un constructor de la superclase.
Si no se escribe `super()` explícitamente, Java lo invoca automáticamente —
pero **solo si existe un constructor sin parámetros** en la superclase.

```java
// ❌ ERROR: Persona solo tiene constructor con parámetros, no existe Persona()
public class Alumno extends Persona {
    public Alumno() {
        // Java intentaría llamar a super() pero no existe
    }
}

// ✅ CORRECTO
public class Alumno extends Persona {
    private char horario;

    public Alumno(String nombre, String apellido, char horario) {
        super(nombre, apellido); // PRIMERA línea: inicializa atributos del padre
        this.horario = horario;
    }
}
```

> `super(...)` **debe ser la primera instrucción** del constructor de la subclase.

---

### 4. Sobrescritura de Métodos (`@Override`)


Ocurre cuando una subclase redefine un método heredado de su superclase,
manteniendo **exactamente la misma firma**, pero cambiando su comportamiento.
Se decide en **tiempo de ejecución** (runtime).

**Un método sobrescrito DEBE cumplir:**
- Mismo nombre.
- Mismos parámetros (tipo, cantidad y orden).
- Tipo de retorno compatible.
- No reducir visibilidad.
- No estar declarado como `final`.
- Se recomienda usar `@Override`.

**NO CONFUNDIR:**

| | Sobrescritura | Sobrecarga |
|---|---|---|
| Dónde | Entre superclase y subclase | En la misma clase |
| Firma | Misma | Distinta |
| Se decide | En runtime | En compile time |
| Cambia | Comportamiento | Forma de llamado |

**Práctica — reemplazar completamente vs. extender**

```java
public class Animal {
    public void hacerSonido() {
        System.out.println("El animal hace un sonido.");
    }
}

// Reemplaza completamente el comportamiento del padre
public class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("El gato maúlla.");
    }
}

// Extiende el comportamiento del padre con super.metodo()
public class Mamifero extends Animal {
    @Override
    public void hacerSonido() {
        super.hacerSonido();                               // ejecuta el del padre primero
        System.out.println("El sonido proviene de un mamífero.");
    }
}
```

> `super.metodo()` permite **extender**, no duplicar.

**Diagrama UML — Sin sobrescritura vs. Con sobrescritura**

```
SIN sobrescritura:                CON sobrescritura:
                                           «abstract»
  OrganismoVivo                             Figura
  # estaVivo:bool                    + calcularArea(): void
  + nacer(): void                    + calcularPerim(): void
  + morir(): void                           /     \
        ▲                          Cuadrado       Circulo
      Animal                       -lado:Double   -radio:Double
      + moverse(): void            @Override      @Override
      + alimentarse(): void        calcularArea   calcularArea
        ▲                          calcularPerim  calcularPerim
    Vertebrado
    # columnaVert:bool
    + mostrarEstructura()
        ▲
       Gato
       -nombre:String
       +maullar(): void
       +ronronear(): void
```

---

### 5. Clases Abstractas


Una clase abstracta representa un **concepto incompleto o genérico**,
pensado solo para ser heredado.

- **No puede instanciarse** directamente.
- Puede tener métodos **abstractos** (sin cuerpo) y métodos **concretos** (con cuerpo).
- Obliga a las subclases a implementar los métodos abstractos.
- Si una clase tiene al menos un método abstracto, la clase también debe ser abstracta.


**Diagrama UML — Figuras**

```
              ┌───────────────────────────┐
              │      «abstract»           │
              │         Figura            │
              ├───────────────────────────┤
              │                           │
              ├───────────────────────────┤
              │ + calcularArea(): double  │  ← abstracto
              │ + calcularPerim(): double │  ← abstracto
              │ + mostrarDatos(): void    │  ← concreto
              └────────────┬──────────────┘
                           │
           ┌───────────────┼──────────────┐
           ▽              ▽              ▽
  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐
  │   Cuadrado   │  │   Circulo    │  │  Triangulo   │
  ├──────────────┤  ├──────────────┤  ├──────────────┤
  │ - lado:Double│  │ - radio:Dbl  │  │ - base:Double│
  ├──────────────┤  ├──────────────┤  │ - altura:Dbl │
  │+Cuadrado(Dbl)│  │+Circulo(Dbl) │  ├──────────────┤
  │+calcularArea │  │+calcularArea │  │+Triangulo(D,D│
  │+calcularPerim│  │+calcularPerim│  │+calcularArea │
  └──────────────┘  └──────────────┘  │+calcularPerim│
                                      └──────────────┘
```

---

### 6. Palabra clave `final`


Java impone límites con `final` para proteger diseños:

| Uso | Efecto |
|---|---|
| `final` en variables | Constante: no puede cambiar después de asignarse |
| `final` en métodos | No pueden sobrescribirse en subclases |
| `final` en clases | No pueden heredarse (`String`, `Integer`, `Math`) |

```java
final double PI = 3.14159;    // constante
// PI = 3.0;                  ← ERROR de compilación

public final void calcularImpuesto() { ... }  // ninguna subclase puede sobrescribir este método

public final class MiClaseSegura { ... }      // nadie puede heredar de esta clase
```

**Problemas comunes del abuso de herencia:**
- Jerarquías muy profundas, difíciles de mantener.
- Herencia solo para reutilizar código (en ese caso usar composición).
- Romper la relación "es un".
- Dificultad para cambiar comportamientos.

**Herencia vs. Composición**

| | Herencia | Composición |
|---|---|---|
| Relación | ES UN | TIENE UN |
| Flexibilidad | Más rígida | Más flexible |
| Acoplamiento | Fuerte | Bajo |
| Cuándo usarla | Relación "es un" real | Relación "tiene un" |

> *"La herencia no sirve para escribir menos código, sino para escribir mejor diseño."*

---

### 7. UML — Unified Modeling Language


UML es un lenguaje gráfico estándar para **modelar, visualizar, diseñar y documentar**
sistemas de software orientados a objetos.

> UML **no es** un lenguaje de programación. No reemplaza al código: lo complementa.

**Representación de una clase UML**

```
┌──────────────────┐
│   NombreClase    │  ← nombre (en cursiva si es abstracta)
├──────────────────┤
│ - atrib: tipo    │  ← atributos
├──────────────────┤
│ + metodo(): tipo │  ← métodos
└──────────────────┘
```

**Visibilidad**

| Símbolo | Modificador |
|---|---|
| `+` | `public` |
| `-` | `private` |
| `#` | `protected` |
| `~` | *(package)* |

**Multiplicidad**

| Notación | Significado |
|---|---|
| `1` | exactamente uno |
| `0..1` | cero o uno |
| `0..*` | cero o muchos |
| `1..*` | uno o muchos |
| `*` | muchos |

**Relaciones entre clases**

| Relación | Símbolo | Lectura |
|---|---|---|
| Herencia | `──────▷` (triángulo blanco) | "es un" |
| Realización / Interfaz | `- - - -▷` (punteada) | "puede hacer" |
| Asociación | `──────` (línea simple) | "usa / conoce" |
| Agregación | `◇──────` (rombo blanco) | "tiene, pero no depende" |
| Composición | `◆──────` (rombo negro) | "no puede vivir sin" |
| Dependencia | `- - - ->` (punteada flecha) | "usa temporalmente" |

---

## Cómo usar estos ejemplos

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/darkwhiskers/POO_Clase03.git
   ```

2. **Compilar desde la raíz del proyecto:**
   ```bash
   javac animales/*.java vehiculos/*.java figuras/*.java banco/*.java rpg/*.java Principal.java
   ```

3. **Ejecutar:**
   ```bash
   java Principal
   ```

4. **Configurar encoding en NetBeans** (para tildes en consola):\
   *Run → Set Project Configuration → Customize → Run → VM Options:*
   ```
   -Dfile.encoding=UTF-8
   ```

5. **Generar Javadoc:**
   ```bash
   javadoc -d doc -encoding UTF-8 -subpackages animales:vehiculos:figuras:banco:rpg Principal.java
   ```

---

## Referencia Rápida

| Concepto | Descripción | Ejemplo |
|---|---|---|
| `extends` | Hereda de una superclase | `class Auto extends Vehiculo` |
| `super(...)` | Llama al constructor del padre (1ra línea) | `super(nombre, velMax, carga, false)` |
| `super.metodo()` | Llama al método del padre | `super.hacerSonido()` |
| `protected` | Accesible en la clase y subclases | `protected String nombre;` |
| `@Override` | Anota sobrescritura de método | `@Override public void atacar()` |
| `abstract class` | No instanciable, para heredar | `public abstract class Figura` |
| `abstract metodo` | Sin cuerpo, obliga a implementar | `public abstract double calcularArea()` |
| `final` variable | Constante, no puede cambiar | `final double PI = 3.14159` |
| `final` método | No puede sobrescribirse | `public final void calcular()` |
| `final` clase | No puede heredarse | `public final class String` |
| Sobrescritura | Misma firma, distinto comportamiento, runtime | `@Override atacar()` en Mago vs Guerrero |
| Sobrecarga | Mismo nombre, distinta firma, compile time | `sumar(int)` y `sumar(double)` |
| Polimorfismo | Variable padre → objeto hijo | `Figura f = new Cuadrado(5)` |

---

| Realizado por **Miguel Silva C.** — UTN INSPT\
| GitHub: [github.com/darkwhiskers] *(https://github.com/darkwhiskers)* \
| Licencia: CC BY-NC-ND 4.0*
