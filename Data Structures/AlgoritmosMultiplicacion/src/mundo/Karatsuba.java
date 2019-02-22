package mundo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Karatsuba {
	
	private StringBuilder  men;
	
	public String suma (String n1, String n2) {
		String imprimir = "";
		
		int [] resultado = new int [Math.max(n1.length(), n2.length()) + 1];
		int resto = 0;
		for (int i = 1; i <= Math.max(n1.length(), n2.length()); i++) {
			if (i <= n1.length()) {
				if (i <= n2.length()) {
					resultado [resultado.length - i] = resto + Integer.parseInt(n1.charAt(n1.length() - i) + "") + Integer.parseInt(n2.charAt(n2.length() - i) + "");
				} else {
					resultado [resultado.length - i] = resto + Integer.parseInt(n1.charAt(n1.length() - i) + "");
				}
			} else {
				resultado [resultado.length - i] = resto + Integer.parseInt(n2.charAt(n2.length() - i) + "");
			}
			resto = resultado [resultado.length - i] / 10;
			resultado [resultado.length - i] = resultado [resultado.length - i] % 10;
		}
		resultado [0] = resto;
		
		if (resultado [0] != 0) {
			imprimir += resultado [0];
		}
		for (int i = 1; i < resultado.length; i++) {
			imprimir += resultado[i];
		}
		return imprimir;
	}
	
	
	public String resta (String n1, String n2) {
		String imprimir = "";
		String a = "";
		String b = "";
			a = n1;
			b = n2;
		int [] resultado = new int [a.length()];
		int resto = 0;
		for (int i = 1; i <= a.length(); i++) {
			if ( i <= b.length()) {
				resultado [a.length() - i] = Integer.parseInt(a.charAt(a.length() - i) + "") - (resto + Integer.parseInt(b.charAt(b.length() - i) + ""));
			} else {
				resultado [a.length() - i] = Integer.parseInt(a.charAt(a.length() - i) + "") - resto;
			}
			if (resultado [a.length() - i] < 0) {
				resto = 1;
				resultado [a.length() - i] += 10;
			} else {
				resto = 0;
			}
		}
		boolean encontrado = false;
		for (int i = 0; i < resultado.length; i++) {
			
			if(resultado[i]!=0) {					
				encontrado=true;
			}
			if(encontrado) {
				imprimir += resultado [i];	
			}
		}
		if (imprimir.length() == 0) {
			imprimir += "0";
		}
		
		return imprimir;
	}
	
	public String multiplicacionDefinitiva(String n1,String n2){
		String resul="";
		men=new StringBuilder();
		if(n1.charAt(0)=='-'&&n2.charAt(0)=='-'){
			String num1=n1.substring(1, n1.length());
			String num2=n2.substring(1,n2.length());
			resul=multiplicacion(num1, num2);
		}else if(n1.charAt(0)=='-'){
			String num1=n1.substring(1,n1.length());
			resul=multiplicacion(num1, n2);
			resul="-"+resul;
		}else if(n2.charAt(0)=='-'){
			String num2=n2.substring(1,n2.length());
			resul=multiplicacion(n1, num2);
			resul="-"+resul;
		}else{
			resul=multiplicacion(n1, n2);
		}
		return resul;
	}
	
	public String multiplicacion(String n1, String n2){
		
		String mensa=" ";
		if(n1.length()<=2 &&n2.length()<=2){
			int num=Integer.parseInt(n1)*Integer.parseInt(n2);

			mensa+=n1+"*"+n2+"="+num+"\n";
			men.append(mensa);
			return num+"";
		}
		
		String x0="";
		String x1="";
		String y0="";
		String y1="";
		int in=0;
		if(n1.length()>n2.length()){
			in=n1.length()/2;
			
		}else{
			in=n2.length()/2;
		}
		
		if(n1.length()==1||n1.length()<=in){
			x1="0";
			x0=n1+"";
		}else{
			x1=n1.substring(0, n1.length()-in);
			x0=n1.substring(n1.length()-in,n1.length());
		}
		
		if(n2.length()==1|| n2.length()<=in){
			y1="0";
			y0=n2+"";
		}else{
			y1=n2.substring(0, n2.length()-in);
			y0=n2.substring(n2.length()-in,n2.length());
		}

		String z2=multiplicacion(x1, y1);
		
		String x1x0 = suma(x1, x0);
		String y1y0 = suma(y1, y0);
		String z1=multiplicacion(x1x0, y1y0);
		String z0=multiplicacion(x0, y0);
		
		String zz1 = z1;   
		zz1=resta(zz1, z2);
		zz1 =resta(zz1,z0);
		z1=zz1;

		mensa+="Numero1: "+n1+" Número2: "+n2+"\n";
		mensa+="z2= "+x1+"x"+y1+"="+z2+"\n";
		mensa+="z1= ("+x1+"+"+x0+")("+y1+"+"+y0+")-"+z2+"-"+z0+"="+z1+"\n";
		mensa+="z0= "+x0+"x"+y0+"="+z1+"\n";
		mensa+="resultado= "+z2+" 10^(2"+in+")+"+z1+" 10^"+in+"+"+z0+"=";
		for(int i=0;i<in;i++){
			z2+="00";
			z1+="0";	
		}
		
		String result = z2;
		result = suma(result, z0);

		result = suma(result, z1);
		
		
		boolean encontrado = false;
		for (int i = 0; i < result.length()&& !encontrado; i++) {
			if(result.charAt(i)!='0') {					
				encontrado=true;
			}
			if(encontrado) {
				result = result.substring(i, result.length());	
			}
		}
		
		
		mensa+=result+"\n";
		mensa+="----------------------------------------------\n";
		if(mensa!= null){
			men.append(mensa);			
		}
		return result;
	}
	
	public String devolverProceso(){
		return men.toString();
//		return "";
	}
}
