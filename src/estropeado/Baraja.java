package estropeado;

import java.util.Random;

/**
 * La clase representa una baraja de 48 cartas
 *
 * @author Carlos
 * @version 1.0
 */


public class Baraja {

    private String[] p = {"Oros", "Copas", "Espadas", "Bastos"}; // array de palos

    private static final int TOTAL_CARTAS = 48; // Replace Magic Number with Symbolic Constant

    private String[] cartas; // Rename Variable

    /**
     * Constructor de la clase Baraja
     */
    public Baraja() {
        cartas = new String[TOTAL_CARTAS]; // Replace Magic Number with Symbolic Constant

        int i = 0;
        for (int j = 0; j < 4; j++) {
            String palo = obtenerPalo(j); // Extract Method
            for (int k = 1; k <= 12; k++) {
                String nombre = obtenerNombreCarta(k); // Extract Method
                nombre = nombre + " de " + palo;
                cartas[i] = nombre;
                i++;
            }
        }
    }

    private String obtenerPalo(int indice) { // Extract Method
        String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
        return palos[indice];
    }

    private String obtenerNombreCarta(int valor) { // Extract Method
        switch (valor) {
            case 10: return "Sota";
            case 11: return "Caballo";
            case 12: return "Rey";
            default: return String.valueOf(valor);
        }
    }

    /**
     * Metodo para sacar una carta
     *
     * @return la carta extraida, o null si esta vacia
     */
    public String sacar() {
        for (int i = 0; i < cartas.length; i++) {
            String carta = cartas[i];
            if (carta != null) {
                cartas[i] = null;
                return carta;
            }
        }
        return null;
    }

    /**
     * Metodo para añadir una carta a la baraja
     *
     * @param carta la carta a añadir
     */
    public void meter(String carta) {
        for (int i = cartas.length - 1; i >= 0; i--) {
            if (cartas[i] == null) {
                cartas[i] = carta;
                System.out.println("original.Carta devuelta: " + carta);
                return;
            }
        }
        throw new IllegalStateException("Error: baraja llena"); // Replace Error Code with Exception
    }

    /**
     * Metodo para indicar si la baraja esta vacia
     *
     * @return true si esta vacia, false en caso contrario
     */
    private boolean vacia() { // Hide Method
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] != null) return false;
        }
        return true;
    }

    /**
     * Metodo para imprimir las cartas de la baraja
     *
     * @param alReves si es true, imprime en orden inverso
     */
    public void imprimir(boolean alReves) {
        if (vacia()) {
            System.out.println("La baraja está vacía");
            System.out.println();
        } else {
            if (alReves) {
                for (int i = cartas.length - 1; i >= 0 ; i--) {
                    if (cartas[i] != null) {
                        System.out.print(cartas[i] + " | ");
                    }
                }
            } else {
                for (int i = 0; i < cartas.length; i++) {
                    if (cartas[i] != null) {
                        System.out.print(cartas[i] + " | ");
                    }
                }
            }
            System.out.println();
        }
    }

    /**
     * Este metodo mezcla la baraja 5 veces
     */
    public void mezclar5veces() {
        for (int i = 0; i < 5; i++) {
            Random r = new Random();
            int j = r.nextInt(TOTAL_CARTAS); // Replace Magic Number with Symbolic Constant
            int k = r.nextInt(TOTAL_CARTAS); // Replace Magic Number with Symbolic Constant
            String temp = cartas[k];
            cartas[k] = cartas[j];
            cartas[j] = temp;
        }
    }

    /**
     * Y este metodo 40 veces
     */
    public void mezclar40veces() {
        for (int i = 0; i < 40; i++) {
            Random r = new Random();
            int j = r.nextInt(48);
            int k = r.nextInt(48);
            String temp = cartas[k];
            cartas[k] = cartas[j];
            cartas[j] = temp;
        }
    }
}