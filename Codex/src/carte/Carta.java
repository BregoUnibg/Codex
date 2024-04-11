package carte;

public abstract class Carta {
	
	public Angolo top_left_angle;
	public Angolo top_right_angle;
	public Angolo bottom_left_angle;
	public Angolo bottom_right_angle;
	
	
	
	//Getters & Setters autogenerati	
	
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
	
	
	
	
		
}
