package interfaccia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GVisualeGioco extends JPanel{
	
	private GMano mano;
	private GCentroCampo centro;
	private GBarraStatistiche barra;
	private GCampoGioco campo;
	
	public  GVisualeGioco() {
		
		this.setPreferredSize(new Dimension(1920,1080));
		this.setLayout(new BorderLayout());
		
		mano = new GMano();
		barra = new GBarraStatistiche();
		campo = new GCampoGioco();
		
		
		this.add(mano, BorderLayout.SOUTH);
		this.add(barra, BorderLayout.NORTH);
		this.add(campo, BorderLayout.CENTER);
		//this.add(tabellone, BorderLayout.EAST);	
		
		
		GCarta c1 = new GCarta();
		GCarta c2 = new GCarta();
		GCarta c3 = new GCarta();
		
		
		mano.addCarta(c1);
		mano.addCarta(c2);
		mano.addCarta(c3);

		
		
		this.setVisible( true);
		
	}

}
