package thread_pools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client
{

	
public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int port = 4350;
		System.out.println("Ingrese la ip a la que enviara la informacion");
		String ip  = bf.readLine();
		System.out.println("Ingrese el mensaje");
		 byte [] enviarDatos = new byte[1024];
		 byte [] recibirDatos = new byte[1024];
		
		 DatagramSocket socketCliente = null;
		 try {
			 socketCliente = new DatagramSocket();
		 } 
		 catch (IOException e)
		 {
			 System.out.println("Error al crear el objeto socket cliente");
			 System.exit ( 0 );
		 }
		
		 InetAddress DireccionIP = null;
		 try 
		 {
			DireccionIP = InetAddress.getByName(ip);
		 } 
		 catch (IOException e)
		 {
			System.out.println("Error al recuperar la IP del proceso");
			System.exit ( 0 );
		 }
		while(true) 
		{
			 recibirDatos = new byte[1024];
			 String operacion = bf.readLine(); 
			 enviarDatos = operacion.getBytes();
			 DatagramPacket enviarPaquete = new DatagramPacket(enviarDatos, enviarDatos.length, DireccionIP, port);
			 socketCliente.send(enviarPaquete);
			 DatagramPacket recibirPaquete = new DatagramPacket(recibirDatos, recibirDatos.length);
			 socketCliente.receive(recibirPaquete);
			 String fraseModificada = new String(recibirPaquete.getData());
			 System.out.println(fraseModificada);
		} 
	}
}