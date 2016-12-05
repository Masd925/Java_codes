package simple_server_and_client;

import java.net.*;
import java.io.*;
 
public class SimpleServer {
    public static void main(String[] args) {
         
        int portNumber = 9696;
        System.out.println("Server started");
        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();     
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);                   
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
        	String inputLine;
            while ((inputLine = input.readLine()) != null) {  // Reads until the stream ends
            	System.out.println("Got request: "+inputLine);
                output.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when listening to port " + portNumber + "or making connection");
            System.out.println(e.getMessage());
        } finally {
        	System.out.println("Server stopped");
        }
    }
}
