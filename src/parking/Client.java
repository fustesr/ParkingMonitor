package parking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

	private static ServerSocket server1;
	private static ServerSocket server2;
	private static ServerSocket server3;
	
    
	
	public static void main(String[] args) {
		
		
		
		Affichage affichageClient = new Affichage();
		affichageClient.start();
		
		
		
		Thread capteur1 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					//create the socket server object
					server1 = new ServerSocket(7777);
					//keep listens indefinitely until receives 'exit' call or program terminates
					while(true){
					    //System.out.println("Waiting for data coming from capteur1");
					    //creating socket and waiting for client connection
					    Socket socket = server1.accept();
					    //read from socket to ObjectInputStream object
					    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					    //convert ObjectInputStream object to String
					    String message = (String) ois.readObject();
					    System.out.println("Message Received from capteur1: " + message);
					    Affichage.textE1.setText(" ");
					    try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					    Affichage.textE1.setText(message);
					    //close resources
					    ois.close();
					    socket.close();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	    
	    
	    Thread capteur2 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					//create the socket server object
					server2 = new ServerSocket(7778);
					//keep listens indefinitely until receives 'exit' call or program terminates
					while(true){
					    //System.out.println("Waiting for data coming from capteur2");
					    //creating socket and waiting for client connection
					    Socket socket = server2.accept();
					    //read from socket to ObjectInputStream object
					    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					    //convert ObjectInputStream object to String
					    String message = (String) ois.readObject();
					    System.out.println("Message Received from capteur2: " + message);
					    Affichage.textE2.setText(" ");
					    try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					    Affichage.textE2.setText(message);
					    //close resources
					    ois.close();
					    socket.close();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	    
		Thread capteur3 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					//create the socket server object
					server3 = new ServerSocket(7779);
					//keep listens indefinitely until receives 'exit' call or program terminates
					while(true){
					    //System.out.println("Waiting for data coming from capteur1");
					    //creating socket and waiting for client connection
					    Socket socket = server3.accept();
					    //read from socket to ObjectInputStream object
					    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					    //convert ObjectInputStream object to String
					    String message = (String) ois.readObject();
					    System.out.println("Message Received from capteur3: " + message);
					    Affichage.textE3.setText(" ");
					    try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					    Affichage.textE3.setText(message);
					    //close resources
					    ois.close();
					    socket.close();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});

	    capteur1.start();
	    capteur2.start();
	    capteur3.start();
	    
    }

}




