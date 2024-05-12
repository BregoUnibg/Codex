package carte;

import campo.CampoGioco;
import requisiti.ReqCartaFalse;
import requisiti.ReqCartaTrue;
import requisiti.Requisito; 

public class CartaOro extends Carta{
	
	private Requisito obiettivo;	//Posso risquotere i punti?
	private Requisito piazzamento;	//Posso piazzare la carta?
	private String descrizione;
	
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
	
	//AGGIUNGERE AI COSTRUTTORI LA DESCRIZIONE
	//requisito piazzamento: 3 figure farfalla
	//requisito obiettivo: 1 punto per ciotola
	
	public CartaOro(Colore colore, int punti, Requisito piazzamento,Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle, String descrizione){
		super(colore, punti, top_left_angle, top_right_angle, bottom_left_angle, bottom_right_angle);
		this.piazzamento = piazzamento;
		this.obiettivo = new ReqCartaTrue();
		this.descrizione=descrizione;
	}
	
	public CartaOro(Colore colore, int punti, Requisito piazzamento, Requisito obiettivo,Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle, String descrizione){
		super(colore, punti, top_left_angle, top_right_angle, bottom_left_angle, bottom_right_angle);
		this.piazzamento = piazzamento;
		this.obiettivo = obiettivo;
		this.descrizione=descrizione;
	}
	
	public boolean getPiazzamento(CampoGioco c) {
		if(this.piazzamento!= null) {
			if(this.piazzamento.soddisfatto(c, this)==0)
				return false;
		}
		return true;
	}
	

	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * Ritorna i punti dati dalla carta, 
	 * @param c (Viene passato il campo di gioco afinchè i requisiti vengano verificati)
	 * @return
	 */
	
	public int getPunti(CampoGioco c){
		return obiettivo.soddisfatto(c, this)*super.getPunti(c);
	}
	
	/**
	 * Usata esclusivamente per mostrare quanti punti concede la carta
	 * @return
	 */
	public int getPuntistd() {
		return super.getPunti(null);
	}
	
	public void setBack() {
		super.setBack();
		this.obiettivo = new ReqCartaFalse();
		this.piazzamento = new ReqCartaTrue();
	}
	
	/**
	 * Clona un oggetto cartaoro
	 * @return
	 */
	public Carta clona() {		
		return new CartaOro(super.getColore(), super.getPunti(null), this.piazzamento,this.obiettivo,super.getTop_left_angle(), super.getTop_right_angle(), super.getBottom_left_angle(), super.getBottom_right_angle(), this.descrizione);
	}
}
