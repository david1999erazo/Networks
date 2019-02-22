package mundo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Tradicional {

	StringBuilder instrucciones;
	
	public Tradicional () {
		instrucciones = new StringBuilder();
	}
	

	public  String tradicional (String a, String b) {
		String retorno = "";
		
		instrucciones.append("Los numeros a multiplicar son: \n  " + a + "\nx " + b + "\n");
		
		if (a.charAt(0) == '-') {
			a = a.substring(1, a.length());
			if (b.charAt(0) == '-') {
				b = b.substring(1, b.length());
			} else {
				retorno += "-";
			}
		} else if (b.charAt(0) == '-') {
			b = b.substring(1, b.length());
			retorno += "-";
		}
		
		int resultado [] = new int [a.length() + b.length()];
		
		instrucciones.append("Cada dígito de " + b + ", se multiplicara por el numero " + a + ", de derecha a izquierda, tal como se nos enseñó a multiplicar en la primaria \n");
		
		for (int i = b.length() - 1; i >= 0; i--) {
			
			instrucciones.append("Se multiplica el dígito " + b.charAt(i) + " con el primer numero ( " + a + " ) \n");
			
			int resto = 0;
			
			instrucciones.append("Ahora, se invierte el proceso, es decir, cada dígito de " + a + " se multiplica con " + b.charAt(i) + " y se le añade el resto correspondiente\n");
			
			for (int j = a.length() - 1; j >= 0; j--) {
			
				instrucciones.append("Para continuar, se multiplica " + b.charAt(i) + " con " + a.charAt(j) + "\n");
				
				
				resultado [i + j + 1] += resto + Integer.parseInt(a.charAt(j)+ "") * Integer.parseInt(b.charAt(i) + "");
				
				
				instrucciones.append("Tras hacer la multiplicacion y sumar el resto, se obtiene " + (resto + Integer.parseInt(a.charAt(j)+ "") * Integer.parseInt(b.charAt(i) + "")) + "\n");
				instrucciones.append("Como " + b.charAt(i) +  " es el " + (b.length() - i) + "° termino de "+ b + ", de derecha a izquierda\ny " + a.charAt(j)
				+ " es el " + (a.length() - j) + "° termino de " + a + " , de derecha a izquierda, \nentonces el resultado se se suma al dígito en la "
				+ (b.length() - i - 1 + a.length() - j) + "° pocision de derecha a izquierda del resultado total, con lo que se tiene " + (resultado [i + j + 1] <10 ? "0" +resultado [i + j + 1] : resultado [i + j + 1] ) + "\n");
				
				
				resto = resultado [i + j + 1] / 10;
				resultado [i+j + 1] = resultado [i + j + 1] % 10;
				
				
				instrucciones.append("Tras hacer la suma, el primer digito del resultado, en este caso " + resto + " se toma como resto \n"
						+ "El segundo digito del resultado, en este caso " + resultado [i + j + 1] + ", es el valor que se pondrá en la pocisión correspondiente \n");
				instrucciones.append("Por ahora, el resultado es: ");
				for (int k = 0; k < resultado.length; k++) {
					instrucciones.append(resultado[k]);	
				}
				
				instrucciones.append("\n");
			}
			instrucciones.append("Tras haber terminado de multiplicar por el numero " + a + ", el ultimo resto obtenido (" + resto +  ") se ubica en"
					+ " la " + (b.length() - i + a.length()) + "° pocision, de derecha a izquierda, del resultado total (Esto es, la pocision anterior a la que "
							+ "ocupa " + b.charAt(i) + " en el numero " + b + " añadido al numero de digitos en " + a + ")\n" );
			
			
			resultado [i] = resto;
			
			
			instrucciones.append("Por ahora, el resultado es: ");
			for (int k = 0; k < resultado.length; k++) {
				instrucciones.append(resultado[k]);	
			}
			instrucciones.append("\n");
		}
		
		
		boolean encontrado = false;
		for (int i = 0; i < resultado.length; i++) {
			if(resultado[i]!=0) {					
				encontrado=true;
			}
			if(encontrado) {
				retorno += resultado [i];	
			}
		}
		if (retorno.length() == 0) {
			retorno = "0";
		}
		
		
		instrucciones.append("El resultado final de la multiplicacion es " + retorno);
		System.out.println(instrucciones);
		
		
		return retorno;
	}
	
	public StringBuilder getInstrucciones() {
		return instrucciones;
	}
	public void setInstrucciones(StringBuilder instrucciones) {
		this.instrucciones = instrucciones;
	}
}

