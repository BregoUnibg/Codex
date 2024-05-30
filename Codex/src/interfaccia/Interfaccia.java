package interfaccia;
import java.util.ArrayList;
import java.util.Set;

import campo.CentroCampo;
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
	
	/**
	 * Creazione dei giocatori che affronteranno la partita
	 * @param pedine pedine rimanenti (non ancora scelte dagli altri giocatori)
	 * @return
	 */
	
	public Giocatore creaGiocatore(Set <Pedina> pedine);
	
	/**
	 * Mostra a schermo quale giocatore ha vinto la partita
	 * @param g: giocatore vincente
	 */
	
	public void visualizzaVincitore(Giocatore g);
	
	/**
	 * Fa scegliere al giocatore su quale lato (fronte/retro) vuole giocare la carta inizale nel prorio campo di gioco
	 * @param g: giocatore sul cui campo viene giocata la carta
	 * @param cartaIniziale: carta izniale da piazzare sul campo
	 */
	
	public void  giocaCartaIniziale(Giocatore g, Carta cartaIniziale);
	
	/**
	 * Fa scegliere al giocatore una carta obiettivo tra due, qualla scelta sarà la sua carta obiettivo pesonale coperta per il resto della partita
	 * @param g: giocatore che deve scewgliere l'obiettivo
	 * @param cartaObiettivo1: prima scelta
	 * @param cartaObiettivo2: seconda scelta
	 */
	
	public void scegliCartaObiettivo(Giocatore g, Carta cartaObiettivo1, Carta cartaObiettivo2);
	
	/**
	 * Permette al giocatore di giocare il pririo turno composto da due fasi:
	 * 1 : giocare una carta sul campo daa gioco
	 * 2 : pescare una carta
	 * @param g: giocatore che deve affrontare il turno
	 * @param centroCampo: centro campo da cui si pesca una carta
	 */
	
	public void giocaTurno(Giocatore g, CentroCampo centroCampo);

	
}
