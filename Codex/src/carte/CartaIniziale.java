package carte;
import java.util.ArrayList;

/**
 * Rappresenta le caratteristiche delle carte iniziali, sia della parte frontale che quella posteriore della carta
 * estende la classe Carta
 * @author Gabriele Bregolin
 * @author Matteo Megna  
 */

public class CartaIniziale extends Carta{
	//attributi
	private Angolo back_top_left_angle;
	private Angolo back_top_right_angle;
	private Angolo back_bottom_left_angle;
	private Angolo back_bottom_right_angle;
	private String urlImmagineRetro;
	
	private ArrayList<Figura> figure;
	
	//Costruttore
	public CartaIniziale(Figura figura1, Figura figura2, Figura figura3, Angolo top_left_angle, Angolo top_right_angle, Angolo bottom_left_angle, Angolo bottom_right_angle,
			Angolo back_top_left_angle, Angolo back_top_right_angle, Angolo back_bottom_left_angle, Angolo back_bottom_right_angle, String urlImmagineFronte, String urlImmagineRetro
			){
		
		super(Colore.BIANCO, top_left_angle, top_right_angle, bottom_left_angle, bottom_right_angle, urlImmagineFronte);
		
		this.back_top_left_angle = back_top_left_angle; 
		this.back_top_right_angle = back_top_right_angle;
		this.back_bottom_left_angle = back_bottom_left_angle;
		this.back_bottom_right_angle = back_bottom_right_angle;
		this.urlImmagineRetro = urlImmagineRetro;
		
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
		this.figure.set(0, null);
		this.figure.set(1, null);
		this.figure.set(2, null);
	}

	//Getter degli angoli
	public Angolo getBack_top_left_angle() {
		return back_top_left_angle;
	}

	public Angolo getBack_top_right_angle() {
		return back_top_right_angle;
	}

	public Angolo getBack_bottom_left_angle() {
		return back_bottom_left_angle;
	}

	public Angolo getBack_bottom_right_angle() {
		return back_bottom_right_angle;
	}
	
	public String getUrlImmagineRetro() {
		return urlImmagineRetro;
	}
}
