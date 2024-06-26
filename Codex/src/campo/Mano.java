package campo;

import java.util.ArrayList;

import carte.Carta;
import carte.CartaOro;
import carte.CartaRisorsa;

/**
 * Rappresenta la mano del giocatore, quindi le (soletimante 3) carte che pesca e gioca
 * @author Gabriele Bregolin
 * @author Matteo Megna
 *
 */

public class Mano {
	
	private ArrayList <Carta> carteMano; //Carte tenute in mano
	
	//Per far si che in mano si tengano sempre tre carte sarebbe ideale inizializzare l'arraylist con il costruttore passando le prime tre carte
	//Per ora verrà geestito prorio così
	//Piazzamento della carta inizalie non viene gestito nella mano
	
	//costruttore
	public Mano(CartaOro cartaoro, CartaRisorsa cartarisorsa1, CartaRisorsa cartarisorsa2) {
		
		carteMano = new ArrayList <Carta>();
		
		carteMano.add(cartaoro);
		carteMano.add(cartarisorsa1);
		carteMano.add(cartarisorsa2);
		
	}
	
	public Mano() {

		carteMano = new ArrayList <Carta>();

	}
	
	/**
	 * Restituisce la carta in mano di indice i
	 * @param i
	 * @return
	 */
	
	public Carta getCartaIndice(int i){
		return carteMano.get(i);
		
	}
	
	/**
	 * Restituisce la carta in mano di un certo id
	 * @param i
	 * @return
	 */
	
	public Carta getCartaId(int id){
		
		for(Carta carta: carteMano) {
			if(carta.getId()==id)
				return carta;
		}
		return null;
		
	}
	
	
	/**
	 * Scegli una carta in mano in base all'indice che ha nella mano 
	 * La restituisce togliendola dalla mano
	 * @return
	 */
	
	public Carta giocaCartaIndice(int i) {
		
		Carta cartaGiocata= carteMano.get(i); 
		carteMano.remove(i);
		return cartaGiocata;
		
	}
	

	/**
	 * Scegli una carta in mano in base all'id che ha nella mano 
	 * La restituisce togliendola dalla mano
	 * @return
	 */
	
	public Carta giocaCartaId(int id) {
		
		Carta cartaGiocata = getCartaId(id); 
		if(cartaGiocata != null) {
			carteMano.remove(cartaGiocata);
			return cartaGiocata;
		}
		return null;
		
	}
	
	/**
	 * Aggiunge la carta appena pescata
	 * @param carta
	 */
	
	public void  pescaCarta(Carta carta) {
		carteMano.add(carta);
	}
	
	
	

}
