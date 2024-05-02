package carte;
import java.util.ArrayList;

public class CartaIniziale extends Carta{
	
	private Angolo back_top_left_angle;
	private Angolo back_top_right_angle;
	private Angolo back_bottom_left_angle;
	private Angolo back_bottom_right_angle;
	
	private ArrayList<Figura> figure;
	
	
	public CartaIniziale(Figura figura1, Figura figura2, Figura figura3, Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle,
			Angolo back_top_left_angle, Angolo back_top_right_angle, Angolo back_bottom_left_angle, Angolo back_bottom_right_angle
			){
		
		super(Colore.BIANCO, top_left_angle, top_right_angle, bottom_left_angle, bottom_right_angle);
		
		this.back_top_left_angle = back_top_left_angle; 
		this.back_top_right_angle = back_top_right_angle;
		this.back_bottom_left_angle = back_bottom_left_angle;
		this.back_bottom_right_angle = back_bottom_right_angle;
		
		figure = new ArrayList<Figura>();
		figure.add(figura1);
		figure.add(figura2);
		figure.add(figura3);
		
	}
	
	public ArrayList<Figura> getFigure(){
		return this.figure;
	}
	
	
	public void setBack() {
		super.setTop_left_angle(back_top_left_angle);
		super.setTop_right_angle(back_top_right_angle);
		super.setBottom_left_angle(back_bottom_left_angle);
		super.setBottom_right_angle(back_bottom_right_angle);
		this.figure.clear();
	}
}
