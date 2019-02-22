package mundo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class fibonacci {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int n0=0,n1=1,n2=1,fibo=0,i=0;
		System.out.print("Hasta que numero calcular la sucesion:");
		BufferedReader linea = new BufferedReader(new InputStreamReader(System.in));
		fibo=Integer.parseInt(linea.readLine());
	
		for(i=0; i<fibo; i++) {
			if(i==0) {
				System.out.println(n0);
			} else if(i==1) {
				System.out.println(n1);
			} else {
				n2=n2+n1;
				n1=n2-n1;
				System.out.println(n2);
			}
		}
	
	}
	
	
}
