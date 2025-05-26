# PROYECTO BARAJA

## Descripción

El proyecto usa una clase llamada 'Baraja' la cual simula una baraja de 48 cartas. Este proyecto permite crear la baraja, mezclar cartas, sacarlas y devolverlas.

El objetivo del proyecto es refactorizar el codigo para una mejor claridad aplicando metodos de refactorización y JavaDoc.

---

## Compilar y ejecutar
Necesario:
- Tener instalado Java

Pasos a seguir:
1. Ejecutar la terminal
2. Navegar a la raiz del proyecto
3. Compilar los archivos '.java'

```bash
javac estropeado/*.java

java estropeado.Main
```

En la compilación escribimos *.java ya que sirve para compilar todos los archivos .java de la carpeta. Es conocido como wildcard.

---

# Refactorizaciones aplicadas

## Replace Magic Number with Symbolic Constant

- **Problema:** El problema surge debido a que se emplea un mismo número varias veces
- **Solucion:** Defini una variable con el nombre de "TOTAL_CARTAS" para: explicar el significado del número y para mas simplicidad a futuro 
- Ejemplo de uso:
```
 private static final int TOTAL_CARTAS = 48;
 
   num = new String[TOTAL_CARTAS];
```

## Rename Variable
- **Problema:** Num es poco descriptivo
- **Solucion:** Se renombra a "cartas" dandole facilidad de compresión al codigo.
- Ejemplo de uso:

```
private String[] cartas; 

cartas = new String[TOTAL_CARTAS]; // Reemplazamos num por cartas
```

## Replace Error Code with Exception

- **Problema:** El error estaba señalado sin la función de error no teniendo así un control total.
- **Solucion:** Se reemplaza el mensaje de error escrito a mano por una excepción
- Ejemplo de uso:

```
   public void meter(String carta) {
        for (int i = cartas.length - 1; i >= 0; i--) {
            if (cartas[i] == null) {
                cartas[i] = carta;
                System.out.println("original.Carta devuelta: " + carta);
                return;
            }
        }
        throw new IllegalStateException("Error: baraja llena"); // Si la baraja esta llena ahora lanza un error
    }
```

## Extract Method

- **Problema:** Metodos muy largos 
- **Solucion:** Se separa el codigo en otros metodos (obtenerPalo, obtenerNombreCarta).
- Ejemplo de uso:

```
 private String obtenerPalo(int indice) { 
        String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
        return palos[indice];
    }

    private String obtenerNombreCarta(int valor) {  
        switch (valor) {
            case 10: return "Sota";
            case 11: return "Caballo";
            case 12: return "Rey";
            default: return String.valueOf(valor);
        }
    }
```

