package estropeado;

/**
 * Clase principal de la aplicación.
 *
 * @author Carlos
 * @version 1.0
 * @see Baraja
 */

public class Main {

	/**
	 * Metodo principal
	 *
	 * @param args argumentos de linea de comandos
	 */

	public static void main(String[] args) {
		// main para hacer pruebas
		// crea baraja
		Baraja baraja = new Baraja();
		// imprimir baraja
		System.out.println("Baraja:");
		baraja.imprimir(false);
		// barajar 5 veces
		baraja.mezclar(5); // Metodo parametrizado
		//imprimir baraja
		System.out.println("\nBaraja tras barajar:");
		baraja.imprimir(true);
		// barajar 40 veces
		baraja.mezclar(40);
		// imprimir baraja
		System.out.println("\nBaraja tras barajar:");
		baraja.imprimir(false);

		// scar carta de la baraja
		System.out.println("\nSaco una carta e intengo añadirla");
		String otraCarta = baraja.sacar();
		// devolver carta a la baraja
		baraja.meter(otraCarta);

		// saco dos cartas
		String carta = baraja.sacar();
		String carta2 = baraja.sacar();
		// se imprimen las dos cartas
		System.out.println();
		System.out.println("Carta 1: " + carta);
		System.out.println("Carta 2: " + carta2);
		//se mete una de las cartas
		baraja.meter(carta2);
		// se imprime la baraja con una carta menos
		baraja.imprimir(false);
	}

}
