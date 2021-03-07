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
	 * Se pide un n�mero y devuelve un vector inicial de 0 al n�mero y otro vector con los n�meros primos hasta ese n�mero. 
	 * 
	 * @param args Valor introducido por teclado
	 */
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el n�mero para la criba de Erat�stenes:");
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
