package carte;

import carte.*; 

public class C_oro extends Carta{
	
	private Requisito obiettivo;	//Posso risquotere i punti?
	private Requisito piazzamento;	//Posso piazzare la carta?
	
	public C_oro(Colore colore, int punti){
		super(colore, punti);
	}
	
	public C_oro(Colore colore, Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle){
		super(colore, top_left_angle, top_right_angle, bottom_left_angle, bottom_right_angle);
	}
	
	public boolean getObiettivo() {
		return this.obiettivo.soddisfatto();
	}
	
	public boolean getPiazzamento() {
		return this.piazzamento.soddisfatto();
	}
}
