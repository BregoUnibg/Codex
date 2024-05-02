package campo;

public class CentroCampo {

	private Mazzo mazzoCartaOro; 
	private Mazzo mazzoCartaRiserva; 
	private Mazzo mazzoCartaObiettivo; 
	private Mazzo mazzoCartaIniziale; 
	
	public CentroCampo() {
		
		mazzoCartaOro = new Mazzo();
		mazzoCartaRiserva = new Mazzo();
		mazzoCartaObiettivo = new Mazzo();
		mazzoCartaIniziale = new Mazzo();
		
	}

	public Mazzo getMazzoCartaOro() {
		return mazzoCartaOro;
	}

	public Mazzo getMazzoCartaRiserva() {
		return mazzoCartaRiserva;
	}

	public Mazzo getMazzoCartaObiettivo() {
		return mazzoCartaObiettivo;
	}

	public Mazzo getMazzoCartaIniziale() {
		return mazzoCartaIniziale;
	}
	
	
	
}
