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
	private JPanel selettoredx;
	
	public GMano() {
		
		this.setPreferredSize(new Dimension(1920,200));
		this.setBackground(Color.RED);
		
		this.setLayout(new BorderLayout());
		
		//Bottoni delle azioni consentite
		selettoresx = new JPanel();
		selettoresx.setBackground(Color.BLACK);
		selettoresx.setPreferredSize(new Dimension(300,300));

		selettoredx = new JPanel();
		selettoredx.setBackground(Color.BLACK);
		selettoredx.setPreferredSize(new Dimension(300,300));

		
		//Spazio dove vengono effettivamente visualizzate le carte
		
		mano = new JPanel();
		mano.setBackground(Color.DARK_GRAY);
		
		
		
		mano.setLayout(new FlowLayout(FlowLayout.CENTER, 25,25)); //Spaziamento Vertical ed Orizzontale
		
		

		
		this.add(selettoresx, BorderLayout.WEST);
		this.add(mano, BorderLayout.CENTER);
		this.add(selettoredx, BorderLayout.EAST);
		 
		this.setVisible(true);
	}
	
	
	/**
	 * Fa apparire un popup su shcermo che visualizza sia il fronte che il retro della carta
	 * La faccia premuta dall'utente sarà quella che verrà giocata
	 * 
	 * @param carta
	 * @return
	 */
	
	private GCarta scegliFronteRetro(GCarta c){
		
		JFrame scegliFaccia = new JFrame();
		scegliFaccia.setSize(430,200);
		scegliFaccia.setLocationRelativeTo(null);
		
		scegliFaccia.setLayout(new GridLayout(2,1));
		
		JPanel pFronte = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel pRetro = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		scegliFaccia.add(pFronte);
		scegliFaccia.add(pRetro);
		
		scegliFaccia.setVisible(true);
		return c;
	}
	
	public void addCarta(GCarta c){
		mano.add(c);
	}
	
	public void removeCarta(GCarta c){
		mano.remove(c);
	}

}
