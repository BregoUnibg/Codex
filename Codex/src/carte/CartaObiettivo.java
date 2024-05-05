package carte;

import campo.CampoGioco;
import requisiti.Requisito;

public class CartaObiettivo extends Carta{
	
	private Requisito obiettivo;
	private String descrizione;
	
	//AGGIUNGERE AL COSTRUZIONE LA DESCRIZIONE
	
	public CartaObiettivo(Colore colore, int punti, Requisito obiettivo){
		super(colore, punti);		//La carta obiettivo non ha angoli
		this.obiettivo= obiettivo;
	}
	
	/**
	 * Ritorna i punti dati dalla carta (0 se l'obiettivo non è soddisfatto ovvimanete), 
	 * @param c (Viene passato il campo di gioco afinchè i requisiti vengano verificati)
	 * @return
	 */
	
	public int getPunti(CampoGioco c){
		return obiettivo.soddisfatto(c)*super.getPunti();
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
}
