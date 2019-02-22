package mundo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class numerosPrimos {
	
	
	
	public numerosPrimos() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea = br.readLine();
		
		int num = Integer.parseInt(linea);
		int a = 0;
		
		for (int i=1; i<(num+1);i++) {
			if(num%i==0) {
				a++;
			}
		}
		if(a!=2) {
			//No es primo
			System.out.println("No es primo");
		}else {
			//Es primo
			System.out.println("Es primo");
		}
		
		
	}
	
	

}
