package estropeado;

import java.util.Random;

public class Baraja {

    private String[] p = {"Oros", "Copas", "Espadas", "Bastos"}; // array de palos
    private String[] num; // array de cartas

    // constructor
    public Baraja() {
        num = new String[48]; //inicializa array a 48 cartas

        int i = 0; // la i será el índice para meter cada carta en el array num
        // bucle que recorre los 4 palos
        for (int j = 0; j < p.length; j++) {
            // pa es un palo de la baraja
            String pa = p[j];
            // array de 1 a 12 para crear 1 de oros, 2 de oros, etc
            for (int k = 1; k <= 12; k++) {
                // si el número es 10, 11 o 12, en vez del número serán sota, caballo y rey
                String nombre = "";
                if (k == 10) {
                    nombre = "Sota";
                } else {
                    if (k == 11) {
                        nombre = "Caballo";
                    } else {
                        if (k == 12) {
                            nombre = "Rey";
                        } else {
                            nombre = String.valueOf(k);
                        }
                    }
                }
                // aquí se crea la carta como string, p ej, sota de copas
                nombre = nombre + " de " + pa;
                num[i] = nombre; // se asigna a una posición del array grande de 48 cartas
                i++; // aumento la posición
            }
        }
    }

    // metodo para sacar una carta de la baraja
    // devuelve la carta y pone su posición a null porque ya no está en la baraja
    public String sacar() {
        for (int i = 0; i < num.length; i++) {
            String carta = num[i];
            if (carta != null) {
                num[i] = null;
                return carta;
            }
        }
        return null;
    }

    // metodo para meter una carta de fuera a la baraja
    // busca la primera posición nula del array y le asigna la variable carta
    public void meter(String carta) {
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] == null) {
                num[i] = carta;
                System.out.println("original.Carta devuelta: " + carta);
                return;
            }
        }
        System.out.println("Error: baraja llena");
    }

    // metodo interno para comprobar si la baraja está vacía
    public boolean vacia() {
        for (int i = 0; i < num.length; i++) {
            if (num[i] != null) return false;
        }
        return true;
    }

    // metodo para imprimir la baraja
    // el param alReves permite imprimirla del final al principio si es true
    public void imprimir(boolean alReves) {
        if (vacia()) {
            System.out.println("La baraja está vacía");
            System.out.println();
        } else {
            if (alReves) {
                for (int i = num.length - 1; i >= 0 ; i--) {
                    if (num[i] != null) {
                        System.out.print(num[i] + " | ");
                    }
                }
            } else {
                for (int i = 0; i < num.length; i++) {
                    if (num[i] != null) {
                        System.out.print(num[i] + " | ");
                    }
                }
            }
            System.out.println();
        }
    }

    // metodo para barajar con 5 movimientos
    // desordena las posiciones del array con numeros random
    public void mezclar5veces() {
        for (int i = 0; i < 5; i++) {
            Random r = new Random();
            int j = r.nextInt(48);
            int k = r.nextInt(48);
            String temp = num[k];
            num[k] = num[j];
            num[j] = temp;
        }
    }

    // metodo para barajar con 40 movimientos
    // desordena las posiciones del array con numeros random
    public void mezclar40veces() {
        for (int i = 0; i < 40; i++) {
            Random r = new Random();
            int j = r.nextInt(48);
            int k = r.nextInt(48);
            String temp = num[k];
            num[k] = num[j];
            num[j] = temp;
        }
    }
}