package interfaccia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GMano extends JPanel{
	
	private JPanel mano;
	private JPanel selettoresx;
	private JPanel obiettivo;
	
	public GMano() {
		
		this.setPreferredSize(new Dimension(1920,200));
		this.setBackground(Color.RED);
		
		this.setLayout(new BorderLayout());
		
		//Bottoni delle azioni consentite
		selettoresx = new JPanel();
		selettoresx.setBackground(Color.BLACK);
		selettoresx.setPreferredSize(new Dimension(300,300));

		obiettivo = new JPanel(new FlowLayout(FlowLayout.CENTER, 25,25));
		obiettivo.setBackground(Color.BLACK);
		obiettivo.setPreferredSize(new Dimension(300,300));

		
		//Spazio dove vengono effettivamente visualizzate le carte
		
		mano = new JPanel();
		mano.setBackground(Color.DARK_GRAY);
		
		
		
		mano.setLayout(new FlowLayout(FlowLayout.CENTER, 25,25)); //Spaziamento Vertical ed Orizzontale
		
		

		
		this.add(selettoresx, BorderLayout.WEST);
		this.add(mano, BorderLayout.CENTER);
		this.add(obiettivo, BorderLayout.EAST);
		 
		this.setVisible(true);
	}
	
	public void addCarta(GCarta c){
		mano.add(c);
	}
	
	public void setGCartaObiettivoCoperto(GCarta c){
		obiettivo.add(c);
	}
	
	public void removeCarta(GCarta c){
		mano.remove(c);
	}

}
