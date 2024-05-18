package interfaccia;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GCampoGioco extends JScrollPane{

	private JPanel campogioco;
	private final int dim = 5000; //dimensioni del campo (è un quadrato)
	
	
	public GCampoGioco() {
		
		campogioco = new JPanel();
		
		campogioco.setPreferredSize(new Dimension(dim,dim));
		
		campogioco.setLayout(null);
		
		
		GCarta c = new GCarta();
		
		
		c.setBounds(100, 100, c.getPreferredSize().width, c.getPreferredSize().height);
		
		//c.setLocation(100, 100);
		
		campogioco.add(c);
		

		
		campogioco.setVisible(true);
		this.setViewportView(campogioco);//Per mettere l'elemento desiderato nello scrollpane
	}
	
}
