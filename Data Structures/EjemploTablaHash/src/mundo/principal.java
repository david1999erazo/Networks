package mundo;

import java.util.Enumeration;
import java.util.Hashtable;

public class principal {

	
	
	
	public principal() {
	
	}
	
	
	public static void main(String[] args) {
		Hashtable<String,String> contenedor = new Hashtable<String , String>(); // Crear tabla Hash
		contenedor.put("111", "David");
		contenedor.put("222", "Juan");
		contenedor.put("333", "Steven");
		contenedor.put("444", "Galvis");
		
		//Recorrer la tabla
		Enumeration<String> enumeracion = contenedor.elements();
		while (enumeracion.hasMoreElements()) {
			System.out.println(""+"hashtable valores: "+ enumeracion.nextElement());
		}
		
		//Saber las claves
		Enumeration<String> llaves = contenedor.keys();
		while(llaves.hasMoreElements()) {
			System.out.println(""+"hashtable llaves: "+ llaves.nextElement());
		}
			
		//System.out.println("Calves: "+ contenedor.keys().toString());
		
		
	}
	
	
	
	
	
}
