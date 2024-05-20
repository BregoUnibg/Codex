package interfaccia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GBarraStatistiche extends JPanel{
	
	private JLabel nomeGiocatore;
	private JLabel descrizioneAzione;
	
	public GBarraStatistiche(String nomeGiocatore) {
		
		this.setPreferredSize(new Dimension(100,100));
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new BorderLayout());
		
		this.nomeGiocatore = new JLabel(nomeGiocatore);
		this.nomeGiocatore.setFont(new Font("Arial", Font.BOLD, 24));
		this.nomeGiocatore.setBorder(new EmptyBorder(10, 20, 10, 20)); //Metto un po di bordo per non fare stare il nome attaccato alla parte sinistra della finestra
		this.nomeGiocatore.setPreferredSize(new Dimension(400,300));
		
		this.descrizioneAzione = new JLabel();
		//this.descrizioneAzione.setFont(new Font("Arial", Font.BOLD, 24));
		this.descrizioneAzione.setBorder(new EmptyBorder(10, 20, 10, 20)); //Metto un po di bordo per non fare stare il nome attaccato alla parte sinistra della finestra
		this.descrizioneAzione.setPreferredSize(new Dimension(400,300));
		
		
		this.add(this.nomeGiocatore, BorderLayout.WEST);
		this.add(this.descrizioneAzione, BorderLayout.EAST);
		
		
		
		this.setVisible(true);
	}
	
	public void azioneCartaIniziale(){
	
		descrizioneAzione.setText("Scegli quale faccia della carta iniziale giocare");
	
	}
	
	public void azioneCartaObiettivo(){
		
		descrizioneAzione.setText("Scegli una tra le due carte obiettivo");
	
	}
	
	public void azioneScegliCartaDaGiocare(){
		
		descrizioneAzione.setText("Gioca una carta dalla tua mano");
	
	}
	
	public void azionePosizionaCartaInCampo() {
		
		descrizioneAzione.setText("Posizione la carta nel campo da gioco");
		
	}
	
	public void azionePescaCarta(){
		
		descrizioneAzione.setText("Pesca una carta dal centro campo");
	
	}

}
