package simple_server_and_client;

import java.net.*;
import java.io.*;

public class SimpleServer {
	public static void main(String[] args) {

		int portNumber = 9696;

		serverLoop: while (true) {
			System.out.println("Server started");
			try (ServerSocket serverSocket = new ServerSocket(portNumber);
				 Socket clientSocket = serverSocket.accept();
				 PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
				 BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			) {
				System.out.println("Made connection with client");
				String inputLine;
				while ((inputLine = input.readLine()) != null) { // Reads until the stream ends
					if (inputLine.equals("stop")) break serverLoop;
					System.out.println("Got request: " + inputLine);
					output.println(inputLine);
				}
				System.out.println("Client ended connection");
			} catch (IOException e) {
				System.out.println("Exception caught when listening to port " + portNumber + "or making connection");
				System.out.println(e.getMessage());
			} finally {
				System.out.println("Server stopped");
				System.out.println("Restarting server...");
			}
		}
        System.out.println("Server shutdown");
	}
}
