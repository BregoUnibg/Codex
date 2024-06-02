package carte;

import campo.CampoGioco;
import requisiti.Requisito;

/**
 * Rappresenta le caratteristiche della carta obiettivo, in questo caso non è importante la gestione degli angoli di questa carta bensì gli eventuali requisiti 
 * @author Gabriele Bregolin
 * @author Matteo Megna 
 */

public class CartaObiettivo extends Carta{
	
	//Attributi
	private Requisito obiettivo;
	private String descrizione;
	
	//AGGIUNGERE AL COSTRUZIONE LA DESCRIZIONE
	//requisito obiettivo: 1 punto per ciotola
	//\n a capo \t tab
	
	//Costruttore
	public CartaObiettivo(Colore colore, int punti, Requisito obiettivo, String descrizione, String urlImmagine){
		super(colore, punti, urlImmagine);		//La carta obiettivo non ha angoli
		this.obiettivo = obiettivo;
		this.descrizione = descrizione;
	}
	
	/**
	 * Ritorna i punti dati dalla carta (0 se l'obiettivo non è soddisfatto ovvimanete), 
	 * @param c (Viene passato il campo di gioco afinchè i requisiti vengano verificati)
	 * @return
	 */
	
	public int getPunti(CampoGioco c){
		return obiettivo.soddisfatto(c, this)*super.getPunti(c);
	}
	
	/**
	 * Usata esclusivamente per mostrare quanti punti concede la carta
	 * @return
	 */
	public int getPuntistd() {
		return super.getPunti(null);
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
}
