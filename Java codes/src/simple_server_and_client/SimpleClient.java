package simple_server_and_client;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.Socket;

public class SimpleClient {
    
	public static void main(String[] args) {
        Socket socket = null;
		BufferedReader input = null;
        
        try {
        	socket = new Socket("localhost", 9696);
        	input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line=input.readLine())!=null) System.out.println("Client got response: " + line);
        }
        catch (IOException ioe) {
        	System.out.println("Problem with connection.");
        	System.out.println(ioe.getMessage());
		    ioe.printStackTrace();
        }
        finally {
        	try {
		        if (input != null) input.close();
		        if (socket != null) socket.close();
		    }
		    catch (IOException ioe) {
		    	System.out.println("Problem closing connection: ");
			    System.out.println(ioe.getMessage());
			    ioe.printStackTrace();
	    	}
        }
		
	}

}
