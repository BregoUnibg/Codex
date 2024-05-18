package interfaccia;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GCarta extends JPanel{
	
	public GCarta() {
		
		this.setPreferredSize(new Dimension(200,150));
		this.setBackground(Color.ORANGE);
		this.setVisible(true);
		
		
	}
	
	
	
	//Funzione inutile mi serviva solo per testare
	public void cambiaColore() {
		
		try {
			Thread.sleep(2000);
			this.setBackground(Color.BLUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
