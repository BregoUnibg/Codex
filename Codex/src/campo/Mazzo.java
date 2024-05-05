package campo;

import java.util.ArrayList;
import java.util.Collections;
import carte.Carta;

public class Mazzo {
	
	private ArrayList <Carta> mazzo;
	
	public Mazzo() {
		
		mazzo = new ArrayList <Carta>();
		
	}
	
	/**
	 * Aggiungi una carta al mazzo 
	 * @param c carta passata
	 */
	public void add(Carta c) {
		mazzo.add(c);
	}
	
	public void mischia(){
		Collections.shuffle(mazzo);
	}
	
	
	
	/**
	 * Pesca una carta dal mazzo, rimovendola quindi da quest'utlimo
	 * @return
	 */
	
	public Carta pesca(){
		
		Carta cartaPescata = mazzo.get(0);
		mazzo.remove(0);
		//In teoria dopo aver rimosso dalla collezione l'elemnto di primo indice tutti gli altri vengono spostati in avanti di uno
		//Il mazzo si comporta automaticamente quindi come un mazzo vero
		return cartaPescata;
		
	}
	
	public boolean vuoto() {
		return mazzo.isEmpty();
	}

}
