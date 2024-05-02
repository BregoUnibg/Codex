package carte;

public class CartaRisorsa extends Carta {
	
	public CartaRisorsa(Colore colore, int punti){
		super(colore, punti);
	}
	
	//Costrutto per carte risorsa con punti
	public CartaRisorsa(Colore colore, int punti, Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle){
		super(colore, punti, top_left_angle, top_right_angle, bottom_left_angle, bottom_right_angle);
	}
	
	//Costrutto per carte risorsa senza punti 
	public CartaRisorsa(Colore colore, Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle){
		super(colore, top_left_angle, top_right_angle, bottom_left_angle, bottom_right_angle);
	}

}
