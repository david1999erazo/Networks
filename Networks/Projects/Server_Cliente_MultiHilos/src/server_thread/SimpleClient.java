package server_thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class SimpleClient {

	
	public static void main(String[] args) {
		System.out.println("Client started");
		
		try {
			
			//Se instancia los elementos para la conección con el servidor
			Socket socket = new Socket("localhost",5000); //Se crea el socket del servidor
			System.out.println("connected to server");
			PrintStream out = new PrintStream(socket.getOutputStream());
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			//Se ejcutan las peticiones del cliente
			String partName = "Axle";
			out.println(partName);
			System.out.println(partName + " request sent");
			System.out.println("Response: "+ br.readLine());
		

			partName = "Wheel";
			out.println(partName);
			System.out.println(partName + " request sent");
			System.out.println("Response: "+ br.readLine());
			

			partName = "Quit";
			out.println(partName);
			socket.close();
			
		} catch (Exception e) {
			System.out.println("problem");
		}

		System.out.println("client Terminated");
	}
	
}
