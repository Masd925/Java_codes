package simple_server_and_client;

import java.io.*;
import java.net.*;
 
public class SimpleClient {
    public static void main(String[] args) {
         
        String hostName = "localhost";
        int portNumber = 9696;
        
        System.out.println("Client started");
        try (
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;
            System.out.println("Type request for the server: ");
            while ((userInput = stdIn.readLine()) != null) {
            	if (userInput.equals("exit")) break;
                output.println(userInput);
                System.out.println("Got server response: " + input.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + hostName);
        } catch (IOException e) {
            System.err.println("Exception caught making connection to: " + hostName + "using port: " + portNumber);
        } finally {
        	System.out.println("Client stopped");
        }
    }
}