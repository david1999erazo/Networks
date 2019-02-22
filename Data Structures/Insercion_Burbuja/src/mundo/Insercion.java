package mundo;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Insercion {

	// Arreglo de entrada

	public static void main(String[] args) {

		int numeros[] = {5,3,2,8,1};
		long tiempo = System.nanoTime();
		//DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		//df.applyPattern("#.####");
		ordenarInsercion(numeros);
		tiempo = System.nanoTime() - tiempo;
		imprimirInsercion(numeros, tiempo);
		
		
		long tiempo2 = System.nanoTime();
		//DecimalFormat dg = (DecimalFormat) NumberFormat.getInstance();
		//dg.applyPattern("#.####");
		ordenarBurbuja(numeros);
		tiempo2 = System.nanoTime()-tiempo2;
		imprimirBurbuja(numeros, tiempo2);
	}

	public static void ordenarInsercion(int numeros[]) {

		for (int i = 1; i < numeros.length; i++) {
			for (int j = i; j > 0 && numeros[j - 1] > numeros[j]; j--) {

				int temp = numeros[j];
				numeros[j] = numeros[j - 1];
				numeros[j - 1] = temp;

			}

		}

	}

	public static void ordenarBurbuja(int numeros[]) {

		for (int i = numeros.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {

				if (numeros[j] > numeros[j + 1]) {
					int temp = numeros[j];
					numeros[j] = numeros[j + 1];
					numeros[j + 1] = temp;
				}
			}
		}

	}

	public static void imprimirInsercion(int numeros[], long time) {
		String mensaje = "";
		for (int i = 0; i < numeros.length; i++) {
			mensaje += numeros[i];
		}
		System.out.println("Insercion: " + mensaje + " Tiempo: "+time);
	}

	public static void imprimirBurbuja(int numeros[],long time) {
		String mensaje = "";
		for (int i = 0; i < numeros.length; i++) {
			mensaje += numeros[i];
		}
		System.out.println("Burbuja: " + mensaje + " Tiempo: "+time);
	}

}
