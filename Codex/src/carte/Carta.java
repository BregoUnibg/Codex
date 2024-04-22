package carte;

public abstract class Carta {
	
	private Angolo top_left_angle;
	private Angolo top_right_angle;
	private Angolo bottom_left_angle;
	private Angolo bottom_right_angle;
	private Figura figura_centrale;
	
	
	private final Colore colore; 			//Servirà nel caso verrà implementata l'iterfaccia grafica 
	private int punti;
	private static int id_iniziale = 1;		//inizializzazione id;
	private int id;							//identificativo univoco della carta
	
	
	public Carta(Colore colore, int punti){
		
		this.top_left_angle = null;
		this.top_right_angle = null;
		this.bottom_left_angle = null;
		this.bottom_right_angle = null;
		
		this.id = Carta.id_iniziale;
		Carta.id_iniziale ++;
		
		this.punti = punti;
		this.colore = colore;
		
		selezione_figura();
		
	}
	
	public Carta(Colore colore, Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle){
		
		this.colore = colore;		
		this.top_left_angle = top_left_angle;
		this.top_right_angle = top_right_angle;
		this.bottom_left_angle = bottom_left_angle;
		this.bottom_right_angle = bottom_right_angle;
		

		this.id = Carta.id_iniziale;
		Carta.id_iniziale ++;
		
		this.punti = 0;
		
		selezione_figura();
		
	}

	public Carta(Colore colore, int punti, Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle){
		
		this.colore = colore;		
		this.top_left_angle = top_left_angle;
		this.top_right_angle = top_right_angle;
		this.bottom_left_angle = bottom_left_angle;
		this.bottom_right_angle = bottom_right_angle;
		

		this.id = Carta.id_iniziale;
		Carta.id_iniziale ++;
		
		this.punti = punti;
		
		selezione_figura();
		
	}
	
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
	
		
	public void setBottom_left_angle(Angolo bottom_left_angle) {
		this.bottom_left_angle = bottom_left_angle;
	}
	public Angolo getBottom_right_angle() {
		return bottom_right_angle;
	}
	public void setBottom_right_angle(Angolo bottom_right_angle) {
		this.bottom_right_angle = bottom_right_angle;
	}
	
	public void set_all_angles_empty(){
	
		this.top_left_angle = new Angolo();
		this.top_right_angle = new Angolo();
		this.bottom_left_angle = new Angolo();
		this.bottom_right_angle = new Angolo();
	}	
	
	public int getId(){
		return this.id;
	}
	
	public int getPunti(){
		return this.punti;
	}
}
	
