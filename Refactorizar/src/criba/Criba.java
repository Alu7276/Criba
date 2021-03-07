package criba;
/**
 * 
 * Clase para generar n�meros primos desde 1 hasta un n�mero m�ximo especificado por el usuario.
 * @version 1.0, 07/03/2021
 * 
 * @author Alu7276
 *
 */

public class Criba {
	
	private static boolean[] esPrimo;
	
	 /**
	 * M�todo para generar n�meros primos de 1 a max de la clase <code>Criba</code>. 
	 * Se crea un array, se criba y se genera un array primos con los n�meros primos.
	 * 
	 * @param max n�mero m�ximo.
	 * @return primos vector de n�meros primos si max es mayor que dos o vector vac�o si max es menor que 2.
	 */
	
	public static int[] generarPrimos (int max) {
		
		//Tama�o del array
		int dim = max + 1;
		
		nuevoArray(dim);
		
		cribar(dim);
		
		if (max >= 2) {
		    
			int[] primos = new int[cuentaPrimos(dim)];
			for (int i = 0, j = 0; i < dim; i++) {
				if (esPrimo[i]) {
					primos[j++] = i;
				}
			}
			return primos;
		} else { 
			//max < 2
			return new int[0];
			// vector vac�o
		}
	}
	
	/**
	 * M�todo para crear un array booleano de tama�o tam.
	 * Inicializa en false la posici�n 1 y 2.
	 *	 * 
	 * @param tam especifica el tama�o del array.
	 * @return esPrimo array booleano de tama�o tam.
	 */
	
	public static boolean[] nuevoArray (int tam) {
		// Inicializar el array
		esPrimo = new boolean[tam];
		
		for (int i = 0; i < tam; i++) {
			esPrimo[i] = true;
		}
		
		// Eliminar el 0 y el 1, que no son primos
				
		esPrimo[0] = esPrimo[1] = false;
				
		return esPrimo;
	}
	
	/**
	 * M�todo para criba de Erat�stenes.
	 * Dado un vector de enteros empezando por 2 se ponen a false todos los m�ltiplos de este. Se busca el siguiente true y se tachan sus m�ltiplos.
	 * As� hasta el final del vector.
	 * 
	 * @param tam indica el tama�o del vector.
	 */
	
	public static void cribar (int tam) {
		for (int i = 2; i<Math.sqrt(tam) + 1; i++) {
			if (esPrimo[i]) {
				//Eliminar los m�ltiplos de i
				for (int j = 2 * i; j < tam; j+=i) { 
					esPrimo[j] = false;
				}
			}
		}
		
	}
	
	/**
	 * M�todo que cuenta los n�meros primos de un array.
	 * 
	 * @param tam n�mero del tama�o del array.
	 * @return cuenta entero con el n�mero de primos en el array.
	 */
	
	public static int cuentaPrimos (int tam) {
		int cuenta = 0;
		for (int i = 0; i < tam; i++) {
			if (esPrimo[i]) {
				cuenta++;
			}
		}
		return cuenta;
	}	
	
}