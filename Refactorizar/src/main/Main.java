package main;

/**
 * 
 * Clase principal main. 
 * 
 * @author Alu7276
 * @version 1.0, 07/03/2021
 *  
 */

import java.util.Scanner;

import criba.Criba;

public class Main {
	
	/**
	 * Se pide un número y devuelve un vector inicial de 0 al número y otro vector con los números primos hasta ese número. 
	 * 
	 * @param args Valor introducido por teclado
	 */
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el número para la criba de Eratóstenes:");
		int dato = teclado.nextInt();
		
		int vector[] = new int[dato];
		
		System.out.println("\nVector inicial hasta :"+dato);
		for (int i = 0; i < vector.length; i++) {
			if (i%10 == 0) {
				System.out.println();
			}
			System.out.print(i + 1 + "\t");
		}
		
		vector = Criba.generarPrimos(dato);
		
		System.out.println("\nVector de primos hasta dato:" +dato);
		for (int i = 0; i < vector.length; i++) {
			if (i%10 == 0) {
				System.out.println();
				}
			System.out.print(vector[i] + "\t");
		}

	}

}
