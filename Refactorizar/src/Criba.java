public class Criba {
	private static boolean[] esPrimo;
	
	// Generar n�meros primos de 1 a max
	public static int[] generarPrimos (int max) {
		
		// Declaraciones
		int i,j;
		//Tama�o del array
		int dim = max + 1;
		
		nuevoArray(dim);
		// Criba
		cribar(dim);
		
		
		if (max >= 2) {
		    // Crear y rellenar el vector de n�meros primos
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
			// vector vac�o
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
				//Eliminar los m�ltiplos de i
				for (int j = 2 * i; j < tam; j+=i) { 
					esPrimo[j] = false;
				}
			}
		}
		
	}
	
	public static int cuentaPrimos (int tam) {
		// �Cu�ntos primos hay?
		int cuenta = 0;
		for (int i = 0; i < tam; i++) {
			if (esPrimo[i]) {
				cuenta++;
			}
		}
		return cuenta;
	}	
	
}
	



