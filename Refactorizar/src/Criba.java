public class Criba {
	private static boolean[] esPrimo;
	
	// Generar números primos de 1 a max
	public static int[] generarPrimos (int max) {
		
		// Declaraciones
		int i,j;
		//Tamaño del array
		int dim = max + 1;
		
		nuevoArray(dim);
		// Criba
		cribar(dim);
		
		
		if (max >= 2) {
		    // Crear y rellenar el vector de números primos
			int[] primos = new int[cuentaPrimos(dim)];
			for (i = 0, j = 0; i < dim; i++) {
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
	
	public static int cuentaPrimos (int tam) {
		// ¿Cuántos primos hay?
		int cuenta = 0;
		for (int i = 0; i < tam; i++) {
			if (esPrimo[i]) {
				cuenta++;
			}
		}
		return cuenta;
	}	
	
}
	



