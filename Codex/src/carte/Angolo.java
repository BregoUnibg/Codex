package carte;

public class Angolo {
	
	private final Figura figura;		//Una volta istanziata la carta essa rimane permanente;
	private Angolo angolo_sopra;		//Si rifersice all'angolo della carta attaccata sopra
	

	public Angolo(){
		this.figura = null;
		this.angolo_sopra = null;
	}
	
	public Angolo(Figura figura){
		this.figura = figura;
		this.angolo_sopra = null;
	}
	
	public Angolo getAngolo_sopra() {
		return this.angolo_sopra;
	}
	
	public void setAngolo_sopra(Angolo angolo_sopra) {
		if(this.angolo_sopra == null)
			this.angolo_sopra = angolo_sopra;
		else
			System.out.println("L'angolo di questa carta è gia coperto");
	}
	
}
