/**
 * @author Nicolas Biojo Bermeo & David Alejandro Erazo Ochoa
 * @version 03/02/2019
 */
package Workshop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {	

	/**
	 * David's IP Address
	 */
	public static final String LOCAL_HOST = "localhost";
	/**
	 * Free port to establish connection
	 */
	public static final int PORT = 8000;
	/**
	 * Socket which allowing connection
	 */
	private static Socket socket;
	

	public static void main(String[] args) {
		
		//They allow us to write and read in binary files
		DataInputStream in;
		DataOutputStream out;

		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			System.out.println("*****Cliente disponible para ser atendido*****");
			
			//socket = new Socket(192.168.1.55", PORT); // Server address
			socket = new Socket( LOCAL_HOST, PORT); // Server address
			
			
			String request = br.readLine();
		
			//initialize data Input/Output Stream
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("Ingrese la frase que desea encriptar");
			
			//Send the request
			out.writeUTF(request);
			
			//Receives the answer
			String mensajeDelServidor = in.readUTF();
			bw.write("la frase encriptada es: " + mensajeDelServidor);
			
			//close buffered and socket
			bw.flush();
			bw.close();
			br.close();
			socket.close();
			in.close();
			out.close();

		} catch (Exception e) {

		}
	}
}
