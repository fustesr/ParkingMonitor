package parking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Serveur {

	private static File fichier;
	static Scanner sc;
	Thread capteur1,capteur2, capteur3;
	
	public Serveur() {
		
		fichier = new File("data.txt");

		
		capteur1 = new Capteur1(1, 5000, 180);
		capteur2 = new Capteur2(2, 5000, 180);
		capteur3 = new Capteur3(3, 5000, 180);
		
	}
	
	
	public void startServer() throws FileNotFoundException {
		
		capteur1.start();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		capteur2.start();
		capteur3.start();
		
	}
	
	
	public static synchronized String getDataFromFile(int nbLine) throws Exception {
		
		try {
			sc = new Scanner(fichier);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int i = 0;
		String res = null;

		while(sc.hasNext()) {
			String tmp = sc.nextLine();
			
			if(i== nbLine) {
				res = tmp;
			}
			i++;
		}
		if (res == null) {
				throw new Exception("Format de fichier incorrect");
		}
		return res;
	}
	
	public static String filtre1(String s) {
	
		if (s.charAt(s.length()-1) == '0') {
			return "RIEN";
		} else {
			return "DETECT";
		} 
	}
	
	public static String filtre2(String s, int etat, int oldEtat) {
		
		if(etat != oldEtat) {
			return s;
		}
		else return "NA";
	}

	
}
