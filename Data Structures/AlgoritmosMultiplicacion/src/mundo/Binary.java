package mundo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Binary {

	StringBuilder proceso;
	String mensaje ;
	
	public Binary() {

		proceso = new StringBuilder();
		
	}

	public String binarioDefinitivo(String b1, String b2) {
		
		String men ="";
		if (b1.charAt(0) == '-') {
			b1 = b1.substring(1, b1.length());
			if (b2.charAt(0) == '-') {
				b2 = b2.substring(1, b2.length());
			} else {
				men = "-";
			}
		} else if (b2.charAt(0) == '-') {
			b2 = b2.substring(1, b2.length());
			men = "-";
		}
		
		BigInteger num1 = new BigInteger(b1);
		BigInteger num2 = new BigInteger(b2);
		BigInteger resultado = new BigInteger(binario(num1.toString(2), num2.toString(2)), 2);


		return men+resultado.toString();
	}

	public StringBuilder getProceso() {
		return proceso;
	}

	public void setProceso(StringBuilder proceso) {
		this.proceso = proceso;
	}

	public String binario(String b1, String b2) {

		
		proceso.append("Para multiplicar los números, primero se deben pasar a binarios \n quedando la multiplicación así: \n " + b1 + "\nx " + b2 + "\n ");
		proceso.append("_________");
			
		long time = System.nanoTime();
		int t = b2.length();
		int[] regla = new int[b1.length() + b2.length() + 2];
		
		if (b1.charAt(b1.length() - 1) != '0') { // Agrega el binario del factor a la suma 
			for (int i = b2.length() - 1, j = 0; i >= 0; i--, j++) {
				regla[j] = Integer.parseInt(b2.charAt(i) + "");
				//	proceso.append("\n____Como el último número del primer factor es 1, entonces se agrega a la suma el binario del segundo factor y se le agrega un 0");				
			}
		}
		
		if(b1.charAt(b1.length()-1) == '1') {
			proceso.append("\nPrimero verificamos el ultimo digito del primer factor a multiplicar, y como es 1, entonces se agrega a la suma el binario del segundo número a multiplicar \nluego seguimos verificando con el anterior número del primer factor a multiplicar");
			
			//proceso.append("\\n____Como el digito a verificar del primer factor es 1, entonces se agrega a la suma el binario del segundo factor y se le agrega un 0");
		}else {
			if(b1.charAt(b1.length()-1) == '0') {
				proceso.append("\nPrimero verificamos el ultimo digito del primer factor a multiplicar, y como es 0, entonces No se agrega a la suma el binario del segundo número a multiplicar \nluego seguimos verificando con el anterior número del primer factor a multiplicar");
				
				//proceso.append("\n _-_-Como el digito a verificar del primer factor a multiplicar es 0 \n entonces No se agrega el binario del segundo número en la sumatoria \n pero de igual forma se le agrega un 0 al final");
			}
		}
		
		
		
		String binarioActual = b2;
		for (int i = 1; i < b1.length(); i++) {
			binarioActual = binarioActual + "0";
			if (b1.charAt(b1.length() - (i + 1 )) == '1') { 
				
				proceso.append("\nComo el digito a verificar del primer factor es 1, entonces se agrega a la suma el binario del segundo factor y se le agrega un 0");				
				int indice = t + i;
				for (int j = 0; j < indice; j++) {
					int num = Integer.parseInt(binarioActual.charAt(indice - (j + 1)) + "");
					regla[j] += num;
				}
			}else {
				proceso.append("\n Como el digito a verificar del primer factor a multiplicar es 0 \n entonces No se agrega el binario del segundo número en la sumatoria \n pero de igual forma se le agrega un 0 al final");
			}
			
			proceso.append("\n El segundo número binario quedaría : "+binarioActual);
		}

		String men = "";
		for (int i = 0; i < regla.length - 1; i++) {
			int temp = regla[i];
			if (temp % 2 == 0) {
				regla[i] = 0;
				men = "0" + men;
			} else {
				regla[i] = 1;
				men = "1" + men;
			}
			regla[i + 1] += (int) (temp / 2);
		}
		time = System.nanoTime() - time;
			
		proceso.append("\n__________________________________________");
		proceso.append("\nSumamos todos los binarios que tomamos");
		proceso.append("\nResultado en binario = "+men);
		
			
	
		return men;

	}

	/*
	 * public static void imprimir(int[]a){ String m=""; for(int
	 * i=a.length-1;i>=0;i--){ m+=a[i]; } System.out.println(m); }
	 */
}
