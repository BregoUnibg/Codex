package campo;

public class Centro_campo {

	private Mazzo mazzoCartaOro; 
	private Mazzo mazzoCartaRiserva; 
	private Mazzo mazzoCartaObiettivo; 
	private Mazzo mazzoCartaIniziale; 
	
	public Centro_campo() {
		
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
