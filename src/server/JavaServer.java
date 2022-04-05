package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class JavaServer {
	
	public static void connectToServer() {
		try(ServerSocket serverSocket = new ServerSocket(9991)){
			Socket connectionSocket = serverSocket.accept();
			
			InputStream inputToServer = connectionSocket.getInputStream();
			OutputStream outputFromServer = connectionSocket.getOutputStream();
			
			Scanner scanner = new Scanner(inputToServer, "UTF-8");
			PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(outputFromServer, "UTF-8"), true);
			
			boolean done = false;
			while(!done && scanner.hasNextLine()) {
				String line = scanner.nextLine();
				serverPrintOut.println("Echo form <Your Name Here> Server: " + line);
				
				if(line.toLowerCase().trim().equals("peace")){
					done = true;
				}
			}
			
			
			scanner.close();
			
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		connectToServer();
	}

}
