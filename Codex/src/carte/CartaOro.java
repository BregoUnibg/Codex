package carte;

import campo.CampoGioco;
import carte.*;
import requisiti.Requisito; 

public class CartaOro extends Carta{
	
	private Requisito obiettivo;	//Posso risquotere i punti?
	private Requisito piazzamento;	//Posso piazzare la carta?
	
	/*
	 * teoricamento Questi costruttori sono inutili
	 * 
	public C_oro(Colore colore, int punti){
		super(colore, punti);
	}
	
	public C_oro(Colore colore, Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle){
		super(colore, top_left_angle, top_right_angle, bottom_left_angle, bottom_right_angle);
	}
	
	*/
	
	public CartaOro(Colore colore, Requisito piazzamento,Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle){
		super(colore, top_left_angle, top_right_angle, bottom_left_angle, bottom_right_angle);
		this.piazzamento = piazzamento;
	}
	
	public CartaOro(Colore colore, Requisito piazzamento, Requisito obiettivo,Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle){
		super(colore, top_left_angle, top_right_angle, bottom_left_angle, bottom_right_angle);
		this.piazzamento = piazzamento;
		this.obiettivo = obiettivo;
	}
	
	public boolean getPiazzamento(CampoGioco c) {
		if(this.piazzamento!= null) {
			if(this.piazzamento.soddisfatto(c)==0)
				return false;
		}
		return true;
	}
	

	/**
	 * Ritorna i punti dati dalla carta, 
	 * @param c (Viene passato il campo di gioco afinchè i requisiti vengano verificati)
	 * @return
	 */
	
	public int getPunti(CampoGioco c){
		return obiettivo.soddisfatto(c)*super.getPunti();
	}
	
	public void setBack() {
		super.setBack();
		this.obiettivo = null;
		this.piazzamento = null;
	}
}