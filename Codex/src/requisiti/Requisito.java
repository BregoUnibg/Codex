package requisiti;

import java.util.ArrayList;

import campo.CampoGioco;
import carte.Carta;

public abstract interface Requisito {
	
	/**
	 * Restituisce il numero di volte per qui è soddisfatto singolaremnte il requisito, 
	 * utile gestirlo in questo modo in quanto gli obiettivi sono influenzati da moltiplicatori
	 * Nel caso sia un requisito di pizzamento può anche semplicemente restituire un valore diverso da 0
	 * @param campo (campo da gioco) 
	 * @param carta (carta) 
	 * @return n di volte per cui l'obiettivo è stato soddisfatto
	 */
	
	public abstract int soddisfatto(CampoGioco campo, Carta carta);	//Gli passo il campo sul quale controlla che il requisito sia verificato
	
	
	
	//Devo calcolare quante volete individualmente (quindi non sovrapponendo gli stessi elementi che soddisfano l'obiettivo una singola volta) 
	//Quante volte l'obiettivo è soddisfatto
	
	
	/**
	 * Controlla se una carta è presente in un arraylist di carte 
	 * (si ho reinventato la ruota)
	 * @param cartaCercata
	 * @param carteContate
	 * @return
	 */
	
	public static boolean presente(Carta cartaCercata, ArrayList <Carta> carteContate){
		for(Carta c: carteContate) {
			if(c==cartaCercata)
				return true;
		}
		return false;
	}
	
	
	
	
	//Se il requisito è soddisfatto restituisce il numero di volte che è stato soddisfatto individualmente 
	//Ciò è necessario per calcolare i punti che genera
	
	//Da quel che mi icordo posso creare un oggetto a nome di una superclasse nel quale mettere oggetti delle 
	//sotoclassi che estendono appunto la superclasse
	
	//questa classe estenderà delle sottoclassi con requisiti in particolare, quindi con un metodo
	//personalizzato, in questo modo risco a istanziare comunqe delle carte con delle classe std.
	
	
	
	//CONSIGLIO DEL PROF: IMPLEMENTA L'INTERFACCIA 
}
