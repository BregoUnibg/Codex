package campo;

import java.util.ArrayList;

import carte.Carta;

public class Mano {
	
	private ArrayList <Carta> carteMano; //Carte tenute in mano
	
	//Per far si che in mano si tengano sempre tre carte sarebbe ideale inizializzare l'arraylist con il costruttore passando le prime tre carte
	//Per ora verrà geestito prorio così
	
	public Mano() {
		
		carteMano = new ArrayList <Carta>();
		
	}
	
	

}
