package carte;

import campo.Campo_gioco;
import requisiti.Requisito;

public class C_obiettivo extends Carta{
	
	private Requisito obiettivo;
	
	public C_obiettivo(Colore colore, int punti, Requisito obiettivo){
		super(colore, punti);		//La carta obiettivo non ha angoli
		this.obiettivo= obiettivo;
	}
	
	public boolean soddisfatto(Campo_gioco c) {
		return this.obiettivo.soddisfatto(c);
	}
	
	/**
	 * Ritorna i punti dati dalla carta, 
	 * @param c (Viene passato il campo di gioco afinchè i requisiti vengano verificati)
	 * @return
	 */
	
	public int getPunti(Campo_gioco c) {
		if(soddisfatto(c))
			return super.getPunti();
		else
			return 0;
	}
	
}
