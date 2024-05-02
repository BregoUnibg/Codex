package carte;

import campo.CampoGioco;
import requisiti.Requisito;

public class CartaObiettivo extends Carta{
	
	private Requisito obiettivo;
	
	public CartaObiettivo(Colore colore, int punti, Requisito obiettivo){
		super(colore, punti);		//La carta obiettivo non ha angoli
		this.obiettivo= obiettivo;
	}
	
	public boolean soddisfatto(CampoGioco c) {
		return this.obiettivo.soddisfatto(c);
	}
	
	/**
	 * Ritorna i punti dati dalla carta, 
	 * @param c (Viene passato il campo di gioco afinchè i requisiti vengano verificati)
	 * @return
	 */
	
	public int getPunti(CampoGioco c) {
		if(soddisfatto(c))
			return super.getPunti();
		else
			return 0;
	}
	
}
