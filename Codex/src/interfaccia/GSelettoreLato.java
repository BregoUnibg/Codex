package interfaccia;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class GSelettoreLato extends JPanel{
	
	public GSelettoreLato() {
		
		this.setPreferredSize(new Dimension(1920,1080));
		this.setLayout(new BorderLayout());
		
		JPanel carte = new JPanel(new GridLayout());
		carte.setPreferredSize(new Dimension(1000,500));
		
		
		
		
		this.setVisible(true);
		
	}

}
