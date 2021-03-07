public class Criba {
	private static boolean[] esPrimo;
	
	// Generar n�meros primos de 1 a max
	public static int[] generarPrimos (int max) {
		
		// Declaraciones
		int i,j;
	    
		
		
		if (max >= 2) {
			//Tama�o del array
			int dim = max + 1;
			nuevoArray(dim);
	
		
			
			// Criba
			for (i = 2; i<Math.sqrt(dim) + 1; i++) {
				if (esPrimo[i]) {
					//Eliminar los m�ltiplos de i
					for (j = 2 * i; j < dim; j+=i) { 
						esPrimo[j] = false;
					}
				}
			}
			
			// �Cu�ntos primos hay?
			int cuenta = 0;
			for (i = 0; i < dim; i++) {
				if (esPrimo[i]) {
					cuenta++;
				}
			}
			
			// Rellenar el vector de n�meros primos
			int[] primos = new int[cuenta];
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
	
}
	



