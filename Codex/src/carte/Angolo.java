package carte;

/**
 * Contiene tutte le caratteristiche e gli opportuni controlli da svolgere sugli angoli delle carte 
 * @author Gabriele Bregolin
 * @author Matteo Megna 
 */

public class Angolo {
	
	//Attributi
	private final Figura figura;		//Una volta istanziata la carta essa rimane permanente;
	private Angolo associato;			//Si rifersice all'angolo della carta attaccata sopra
	private boolean scoperto;
	private boolean assente;

	//Costruttori
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
	
	//Getter
	public Angolo getAngolo_associato() {
		return this.associato;
	}
	
	public boolean getScoperto() {
		return this.scoperto;
	}
	
	private void setAngolo_associato(Angolo associato) {
			this.associato = associato;
	}
	
	/**
	 * Verifica se è possibile associare a questo angolo l'angolo passato, 
	 * in caso affermativo gli angoli vengono associati quindi la carta "piazzata"
	 * @param angolo_sopra
	 * @return
	 */
	public boolean piazzaAngolo(Angolo angolo_sopra){
		
		if(piazzabile()){
			associato = angolo_sopra;
			angolo_sopra.setAngolo_associato(this);
			this.scoperto = false;
			return true;
		}
		
		return false;
	}
	/**
	 * Verifica se una carta è piazzabile in quell'angolo
	 * @return
	 */
	public boolean piazzabile(){
		return (!assente)&&scoperto&&(associato==null);
	}
	
	/**
	 * controlla le figure degli angoli in caso di piazzamento di una carta
	 * @return
	 */
	public Figura getFigura() {
		if(scoperto)
			return this.figura;
		else
			return null;
	}
	
}
