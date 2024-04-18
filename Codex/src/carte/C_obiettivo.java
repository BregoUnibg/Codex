package carte;

public class C_obiettivo extends Carta{
	
	private Requisito obiettivo;
	
	public C_obiettivo(Colore colore, int punti, Requisito obiettivo){
		super(colore, punti);		//La carta obiettivo non ha angoli
		this.obiettivo= obiettivo;
	}
	
	public boolean soddisfatto() {
		return this.obiettivo.soddisfatto();
	}
	
}
