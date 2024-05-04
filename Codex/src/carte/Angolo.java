package carte;

public class Angolo {
	
	private final Figura figura;		//Una volta istanziata la carta essa rimane permanente;
	private Angolo associato;		//Si rifersice all'angolo della carta attaccata sopra
	private boolean scoperto;
	private boolean assente;

	public Angolo(){
		this.figura = null;
		this.associato= null;
		this.scoperto = true;
		this.assente= false;
	}
	
	public Angolo(Figura figura){
		this.figura = figura;
		this.associato= null;
		this.scoperto = true;
		this.assente= false;
	}
	
	public Angolo(boolean assente) {
		this.associato= null;
		this.scoperto = false;
		this.figura = null;
		this.assente= assente;
	}
	
	public Angolo getAngolo_associato() {
		return this.associato;
	}
	
	public boolean getScoperto() {
		return this.scoperto;
	}
	
	private void setAngolo_associato(Angolo associato) {
			this.associato = associato;
	}
	
	public boolean piazzaAngolo(Angolo angolo_sopra){
		
		if(piazzabile()){
			associato = angolo_sopra;
			angolo_sopra.setAngolo_associato(this);
			this.scoperto = false;
			return true;
		}
		
		return false;
	}
	
	public boolean piazzabile(){
		return (!assente)&&scoperto&&(associato==null);
	}
	
	public Figura getFigura() {
		if(scoperto)
			return this.figura;
		else
			return null;
	}
	
}
