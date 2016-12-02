package simple_server_and_client;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;

public class SimpleServer {
    
	public static void main(String[] args){
				
		while(true) {
			ServerSocket srvSocket = null;
			Socket socket = null;
			PrintWriter out = null;
			System.out.println("Server started");
		    try {
			    srvSocket = new ServerSocket(9696);
		        while(true) {
		    	    socket = srvSocket.accept();
		    	    out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Test response");
                    out.println("More response text");
		        }
		    }
		    catch (IOException ioe) {
			    System.out.println("Problem with connection: ");
			    System.out.println(ioe.getMessage());
			    ioe.printStackTrace();
		    }
		    finally {
			    try {
			    	if (out != null) out.close();
			    	if (socket != null) socket.close();
			        if (srvSocket != null) srvSocket.close();
			    }
			    catch (IOException ioe) {
			    	System.out.println("Problem closing connection: ");
				    System.out.println(ioe.getMessage());
				    ioe.printStackTrace();
		    	}
			    System.out.println("Restarting server...");
		    }  
		}
        
    }
	
}
