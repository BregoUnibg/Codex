package carte;

import requisiti.Requisito;

public class C_obiettivo extends Carta{
	
	private Requisito obiettivo;
	
	public C_obiettivo(Colore colore, int punti, Requisito obiettivo){
		super(colore, punti);		//La carta obiettivo non ha angoli
		this.obiettivo= obiettivo;
	}
	
	public boolean soddisfatto() {
		return this.obiettivo.soddisfatto();
	}
	
	public int getPunti() {
		if(soddisfatto())
			return super.getPunti();
		else
			return 0;
	}
	
}
