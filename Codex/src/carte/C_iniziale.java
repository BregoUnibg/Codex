package carte;

public class C_iniziale extends Carta{

	public C_iniziale(){
		super(Colore.BIANCO);		//La carte iniziale è sempre bianca
	}
	
	public C_iniziale(Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle){
		super(Colore.BIANCO, top_left_angle, top_right_angle, bottom_left_angle, bottom_right_angle);
	}
	
}
