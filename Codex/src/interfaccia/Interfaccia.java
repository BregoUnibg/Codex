package interfaccia;
import java.util.ArrayList;

import campo.Giocatore;
import campo.Pedina;
import carte.Carta;
import carte.CartaIniziale;

public interface Interfaccia {
	
	//IDEA MOLTO CARINA MA FORSE DIFFICILE DA IMPLEMENTARE
	//Ogni interfaccia o meglio gestore di interfaccia deve avere i medesi metodi erefitati da "ironicamente" un interfaccia JAVA
	//In questo istanzio una classe del gestore grafico che volgio e la tratto in modo indifferente nella classe gioco;
	
	/**
	 * Scegli il numero di giocatori che affronterà la partita (2-4)
	 * @return
	 */
	
	public int numeroGiocatori();
	
	/**
	 * Creazione dei giocatori che affronteranno la partita
	 * @param pedine pedine rimanenti (non ancora scelte dagli altri giocatori)
	 * @return
	 */
	
	public void benvenuto();
	
	public Giocatore creaGiocatore(ArrayList <Pedina> pedine);
	
	/**
	 * Visualizza il fronte e il retro della carta iniziale, se viene giocata sul fronte restituisce 1, se viene giocata sul retro 0
	 * @param cartaIniziale
	 * @return
	 */
	public void  giocaCartaIniziale(Giocatore g, Carta cartaIniziale);

	
}
