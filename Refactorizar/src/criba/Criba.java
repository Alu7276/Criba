package criba;
/**
 * 
 * Clase para generar números primos desde 1 hasta un número máximo especificado por el usuario.
 * @version 1.0, 07/03/2021
 * 
 * @author Alu7276
 *
 */

public class Criba {
	
	private static boolean[] esPrimo;
	
	 /**
	 * Método para generar números primos de 1 a max de la clase <code>Criba</code>. 
	 * Se crea un array, se criba y se genera un array primos con los números primos.
	 * 
	 * @param max número máximo.
	 * @return primos vector de números primos si max es mayor que dos o vector vacío si max es menor que 2.
	 */
	
	public static int[] generarPrimos (int max) {
		
		//Tamaño del array
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
			// vector vacío
		}
	}
	
	/**
	 * Método para crear un array booleano de tamaño tam.
	 * Inicializa en false la posición 1 y 2.
	 *	 * 
	 * @param tam especifica el tamaño del array.
	 * @return esPrimo array booleano de tamaño tam.
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
	 * Método para criba de Eratóstenes.
	 * Dado un vector de enteros empezando por 2 se ponen a false todos los múltiplos de este. Se busca el siguiente true y se tachan sus múltiplos.
	 * Así hasta el final del vector.
	 * 
	 * @param tam indica el tamaño del vector.
	 */
	
	public static void cribar (int tam) {
		for (int i = 2; i<Math.sqrt(tam) + 1; i++) {
			if (esPrimo[i]) {
				//Eliminar los múltiplos de i
				for (int j = 2 * i; j < tam; j+=i) { 
					esPrimo[j] = false;
				}
			}
		}
		
	}
	
	/**
	 * Método que cuenta los números primos de un array.
	 * 
	 * @param tam número del tamaño del array.
	 * @return cuenta entero con el número de primos en el array.
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