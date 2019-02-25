package thread_pools;

import java.io.*;
import java.net.*;

public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		System.out.println("El servidor va a ponerse a la escucha, un momento mientras se leen los parametros");
		int port = 4350;
		DatagramSocket socketServidor = null;

		try {
			socketServidor = new DatagramSocket(port);
		} catch (IOException e) {
			System.out.println("Error al crear el objeto socket servidor");
		}
		
		byte[] recibirDatos = null;
		byte[] enviarDatos = null;
		byte[] enviarDatos2 = null;
		
		while (true) {

			recibirDatos = new byte[1024];
			enviarDatos = new byte[1024];
			enviarDatos2 = new byte[1024];

			DatagramPacket recibirPaquete = new DatagramPacket(recibirDatos, recibirDatos.length);

			try {
				socketServidor.receive(recibirPaquete);

			} catch (IOException e)

			{
				System.out.println("Error al recibir");
				System.exit(0);

			}
			
			String frase = new String(recibirPaquete.getData());
			InetAddress DireccionIP = recibirPaquete.getAddress();
			int puerto = recibirPaquete.getPort();
			
			String respuesta = manejoDeDatos1(frase);
			enviarDatos = respuesta.getBytes();
			DatagramPacket enviarPaquete = new DatagramPacket(enviarDatos, enviarDatos.length, DireccionIP, puerto);
			
			try {
				socketServidor.send(enviarPaquete);
			} catch (IOException e) {
				System.out.println("Error al recibir");
				System.exit(0);

			}

			// String fraseMayusculas = frase.toUpperCase();
		}
	}
	/*
	 * private static String manejoDeDatos(String frase) { double valor = 0;
	 * String[] caracteres = frase.split(","); switch (caracteres[1]) { case "-":
	 * valor = Integer.parseInt(caracteres[0].trim()) -
	 * Integer.parseInt(caracteres[2].trim()); break;
	 * 
	 * case "*": valor = Integer.parseInt(caracteres[0].trim()) *
	 * Integer.parseInt(caracteres[2].trim()); break;
	 * 
	 * case "/": valor = Integer.parseInt(caracteres[0].trim()) /
	 * Integer.parseInt(caracteres[2].trim()); break;
	 * 
	 * default: int x = Integer.parseInt(caracteres[0].trim()); int y =
	 * Integer.parseInt(caracteres[2].trim()); valor = x + y; break; }
	 * 
	 * return valor + ""; }
	 */

	private static String manejoDeDatos1(String frase) {
		String mensaje = "";
		if (frase != null && frase != "") {
			try {
				System.out.println(frase);
				BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

				mensaje = bf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mensaje;

	}

}
