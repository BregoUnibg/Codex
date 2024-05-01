package campo;

import java.util.ArrayList;
import java.util.Collections;
import carte.Carta;

public class Mazzo {
	
	private ArrayList <Carta> mazzo;
	
	public Mazzo() {
		
		mazzo = new ArrayList <Carta>();
		
	}
	
	//*Aggiungi una carta al mazzo;
	public void add(Carta c) {
		mazzo.add(c);
	}
	
	public void mischia(){
		Collections.shuffle(mazzo);
	}
	
	public Carta pesca(){
		
		Carta cartaPescata = mazzo.get(0);
		mazzo.remove(0);
		return cartaPescata;
		
	}
	
	
	
	

}
