package carte;

public class C_risorsa extends Carta {
	
	public C_risorsa(Colore colore){
		super(colore);
	}
	
	public C_risorsa(Colore colore, Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle){
		super(colore, top_left_angle, top_right_angle, bottom_left_angle, bottom_right_angle);
	}

}
