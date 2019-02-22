/**
 * @author Nicolas Biojo Bermeo & David Alejandro Erazo Ochoa
 * @version 03/02/2019
 */

package Workshop;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	
	/**
	 * Free port to establish connection
	 */
	public static final int PORT = 8000;
	
	/**
	 * Socket which allowing connection whit clients
	 */
	private static  ServerSocket serverSocket;
	/**
	 * Socket which allowing connection
	 */
	private static Socket socket;
	

	
	
	public static void main(String[] args) {
		
		DataInputStream in;
		DataOutputStream out;
		
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("*****Servidor esperando por un posible cliente*****");
			
			while(true) {
				
				//inicialize socket 
				socket = serverSocket.accept();
				System.out.println("El cliente se ha conectado!");
				
				//initialize data Input/Output Stream
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
				
				//read the request
				String client_Request = in.readUTF();
				System.out.println("El mensaje enviado por el cliente fue : " + client_Request);
				
				//Call the Service method
				String Server_Answer = metodoServicioServer(client_Request);
				
				//Send the answer
				out.writeUTF(Server_Answer);
				
				//Close the socket
				socket.close();
				System.out.println("*****El cliente fue desconectado del servidor*****");
			
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/**
	 * 
	 * @param Client_Request
	 * 	Phrase that the client wants to encrypt
	 * @return String with encryption result
	 */
	private static String metodoServicioServer(String Client_Request) {
		
		String x = "";
		for (int i = 0; i < Client_Request.length(); i++) {
			char a  = Client_Request.charAt(i);
			String y = Character.toString((char)(a+2));
			x+=y;
		}
		return  x;
	}
	
}
