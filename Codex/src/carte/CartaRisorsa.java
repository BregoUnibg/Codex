package carte;

public class CartaRisorsa extends Carta {
	
	public CartaRisorsa(Colore colore, int punti, String urlImmagine){
		super(colore, punti, urlImmagine);
	}
	
	//Costrutto per carte risorsa con punti
	public CartaRisorsa(Colore colore, int punti, Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle, String urlImmagine){
		super(colore, punti, top_left_angle, top_right_angle, bottom_left_angle, bottom_right_angle, urlImmagine);
	}
	
	//Costrutto per carte risorsa senza punti 
	public CartaRisorsa(Colore colore, Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle, String urlImmagine){
		super(colore, top_left_angle, top_right_angle, bottom_left_angle, bottom_right_angle, urlImmagine);
	}
	
	public Carta clona() {		
		return new CartaRisorsa(super.getColore(), super.getPunti(null),super.getTop_left_angle(), super.getTop_right_angle(), super.getBottom_left_angle(), super.getBottom_right_angle(), this.getUrlImamgine());
	}

}
