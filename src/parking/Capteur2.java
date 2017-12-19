package parking;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class Capteur2 extends Thread {
	
	
	private int id;
	private int frequence;
	private int range;
	private Timer t;
	private int oldEtat = -1;
	private int etat = 0;
	
	private String currentData;
	private String tmpProcessing;
	private String afterProcessing;
	
	
	public Capteur2(int id, int frequence, int range) {
		this.id = id;
		this.frequence = frequence;
		this.range = range;
		
		t = new Timer();
	}
	
	
	public void run() {
		
		
		t.schedule(new TimerTask() {
		    @Override
		    public void run() {
		    	try {
		    		
		    		currentData = Serveur.getDataFromFile(1);
		    		tmpProcessing = Serveur.filtre1(currentData);
		    		if(tmpProcessing.equals("RIEN"))
		    			etat = 0;
		    		else
		    			etat = 1;
		    		afterProcessing = Serveur.filtre2(tmpProcessing, etat, oldEtat);
		    		if(!afterProcessing.equals("NA")) {
		    			
		    			oldEtat = etat;
		    			
		    			Socket socket = null;
			            ObjectOutputStream oos = null;

		                //establish socket connection to server
		                socket = new Socket("127.0.0.1", 7778);
		                //write to socket using ObjectOutputStream
		                oos = new ObjectOutputStream(socket.getOutputStream());
		                System.out.println("[Capteur2] : Sending data to client");
		                
		                oos.writeObject("" + afterProcessing);

		                //close resources
		                oos.close();
		                Thread.sleep(100);
		            
		    		
		                socket.close();

		    		}
		    		
		    		
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}
		    }
		}, 0, frequence);
		
		
	}

}
