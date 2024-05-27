package carte;

import campo.CampoGioco;

public abstract class Carta {
	
	//Attributi
	private Angolo top_left_angle;
	private Angolo top_right_angle;
	private Angolo bottom_left_angle;
	private Angolo bottom_right_angle;
	private Figura figura_centrale;
	private String urlImmagine;
	
	
	private final Colore colore; 			//Servirà nel caso verrà implementata l'iterfaccia grafica 
	private int punti;
	private static int id_iniziale = 1;		//inizializzazione id;
	private int id;							//identificativo univoco della carta
	private int num;
	
	//Costrutti
	public Carta(Colore colore, int punti, String urlImmagine){
		
		this.top_left_angle = null;
		this.top_right_angle = null;
		this.bottom_left_angle = null;
		this.bottom_right_angle = null;
		this.figura_centrale = null;
		this.urlImmagine = urlImmagine;
		
		this.id = Carta.id_iniziale;
		Carta.id_iniziale ++;
		
		this.punti = punti;
		this.colore = colore;
		
		
	}
	
	public Carta(Colore colore, Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle, String urlImmagine){

		this.colore = colore;		
		this.top_left_angle = top_left_angle;
		this.top_right_angle = top_right_angle;
		this.bottom_left_angle = bottom_left_angle;
		this.bottom_right_angle = bottom_right_angle;
		this.figura_centrale = null;
		this.urlImmagine = urlImmagine;

		this.id = Carta.id_iniziale;
		Carta.id_iniziale ++;
		
		this.punti = 0;
		
		
	}

	public Carta(Colore colore, int punti, Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle, String urlImmagine){
		
		this.colore = colore;		
		this.top_left_angle = top_left_angle;
		this.top_right_angle = top_right_angle;
		this.bottom_left_angle = bottom_left_angle;
		this.bottom_right_angle = bottom_right_angle;
		this.figura_centrale = null;
		this.urlImmagine = urlImmagine;

		this.id = Carta.id_iniziale;
		Carta.id_iniziale ++;
		
		this.punti = punti;
		
		
		
	}
	
	/**
	 * Associa al colore la regaltiva figura
	 */
	private void selezione_figura(){
	
		switch (this.colore) {
			case ROSSO:
				this.figura_centrale = Figura.FUNGO;
				break;
			case VERDE:
				this.figura_centrale = Figura.FOGLIA;
				break;
			case BLU:
				this.figura_centrale = Figura.LUPO;
				break;
			case VIOLA:
				this.figura_centrale = Figura.FARFALLA;
				break;
			default:
				this.figura_centrale = null;
		}
	}
	
	public Figura getFigura(){
		return figura_centrale;
	}
	
	/*
	public Colore getColore() {
		return colore;
	}
	*/
	//Getters & Setters Di tutti gli angoli
	
	public Angolo getTop_left_angle() {
		return top_left_angle;
	}
	public void setTop_left_angle(Angolo top_left_angle) {
		this.top_left_angle = top_left_angle;
	}
	public Angolo getTop_right_angle() {
		return top_right_angle;
	}
	public void setTop_right_angle(Angolo top_right_angle) {
		this.top_right_angle = top_right_angle;
	}
	public Angolo getBottom_left_angle() {
		return bottom_left_angle;
	}
	
	public String getUrlImamgine() {
		return this.urlImmagine;
	}
		
	public void setBottom_left_angle(Angolo bottom_left_angle) {
		this.bottom_left_angle = bottom_left_angle;
	}
	public Angolo getBottom_right_angle() {
		return bottom_right_angle;
	}
	public void setBottom_right_angle(Angolo bottom_right_angle) {
		this.bottom_right_angle = bottom_right_angle;
	}
	
	public Colore getColore(){
		return colore;
	}
	
	public void setAllAnglesEmpty(){
	
		this.top_left_angle = new Angolo();
		this.top_right_angle = new Angolo();
		this.bottom_left_angle = new Angolo();
		this.bottom_right_angle = new Angolo();
	}	
	
	/**
	 * La carta viene impostata in modo tale da essere giocata sul retro
	 * ATTENZIONE: NON REVERSIBILE
	 */
	
	public void setBack(){		//la carta viene giocata sul retro
		setAllAnglesEmpty();
		selezione_figura();
		this.punti = 0;
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getPunti(CampoGioco c){
		return this.punti;
	}
	
	public Carta clona(){
		return null;
	}
}
	
