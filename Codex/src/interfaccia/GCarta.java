package interfaccia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import carte.Carta;
import carte.CartaIniziale;

public class GCarta extends JPanel{
	
	private JLabel immagine;
	private Carta cartaLogica;	//Carta logica associata alla maschera grafica
	private Dimension posizione; //Posizione della carta nel campo una volta che è stata giocata
	
	private JButton bTopLeft;
	private JButton bTopRight;
	private JButton bBottomLeft;
	private JButton bBottomRight;
	
	public GCarta() {
		
		this.setPreferredSize(new Dimension(200, 140));
		this.setBackground(Color.ORANGE);
		this.setVisible(true);
		
		
	}
	
	/**
	 * Istanzia una nuoca carta grafica, viene 
	 * automaticamente determinata nella carta l'immagine frontale e retro
	 * è poi possibile decidere quale delle due visualizzare
	 * 
	 * @param cartaLogica
	 */
	
	public GCarta(Carta cartaLogica) {
		
		this.setPreferredSize(new Dimension(200,140));
		this.setBackground(Color.ORANGE);
		this.cartaLogica = cartaLogica;
		
		immagine = new JLabel();
		
		setImmagineCarta(cartaLogica.getUrlImamgine());

		this.setLayout(null);
		immagine.setBounds(0, 0, 200, 140);
		
		this.add(immagine);
		
		
		bTopLeft = new JButton();
		bTopLeft.setBounds(0, 0, 45, 55);
		bTopLeft.setOpaque(false);
		
		bTopRight = new JButton();
		bTopRight.setBounds(155, 0, 45, 55);
		bTopRight.setOpaque(false);
		
		bBottomLeft = new JButton();
		bBottomLeft.setBounds(0, 85, 45, 55);
		bBottomLeft.setOpaque(false);
		
		bBottomRight= new JButton();
		bBottomRight.setBounds(155, 85, 45, 55);
		bBottomRight.setOpaque(false);
		
		this.add(bTopLeft);
		this.add(bTopRight);
		this.add(bBottomLeft);
		this.add(bBottomRight);
		
		this.setVisible(true);
		
		
	}
	
	
	/**
	 * Imposta forzatamente l'immagine della carta
	 * @param urlImmagine
	 */
	
	private void setImmagineCarta(String urlImmagine) {

		ImageIcon icon = new ImageIcon(urlImmagine);
		Image img = icon.getImage();
		img = img.getScaledInstance(200, 140, 0);
		icon = new ImageIcon(img);
		immagine.setIcon(icon);
	}
	
	private void setJLabelImmagineCarta(JLabel immagine) {

		this.immagine = immagine;
	}
	
	/**
	 * Imposta l'immagine della carta grafica sul fronte
	 */
	
	public void visualizzaFronteCarta() {
		setImmagineCarta(cartaLogica.getUrlImamgine());
	}
	
	/**
	 * Imposta l'imamigne della carta grafica sul retro
	 * senza girare effettivamente la carta logica
	 */
	
	public void visualizzaRetroCarta() {
		if(cartaLogica instanceof CartaIniziale){
			setImmagineCarta(((CartaIniziale) cartaLogica).getUrlImmagineRetro());
		}
		else{
			
			switch(cartaLogica.getColore()) {
			
			case ROSSO:
				setImmagineCarta("Immagini/Carte/xretrocartarossa.png");
				break;

			case VERDE:
				setImmagineCarta("Immagini/Carte/xretrocartaverde.png");
				break;

			case BLU:
				setImmagineCarta("Immagini/Carte/xretrocartablu.png");
				break;

			case VIOLA:
				setImmagineCarta("Immagini/Carte/xretrocartaviola.png");
				break;

			case GRIGIO:
				setImmagineCarta("Immagini/Carte/xretrocartagrigia.png");
				break;
				
			}
			
		}
	}
	
	/**
	 * Imposta la carta logica associata sul retro
	 */
	
	public void setBack(){
		cartaLogica.setBack();
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
	
	public Carta getCarta() {
		return cartaLogica;
	}
	
	/**
	 * Crea un clone della carta, (por non sporcare l'originale nel caso in cui venga girata)
	 * @return
	 */
	
	public GCarta clona(){
		
		GCarta cartaClonata =  new GCarta(cartaLogica.clona());
		cartaClonata.setJLabelImmagineCarta(immagine);
		return cartaClonata;
		
	}
	
	public JButton getbTopLeft() {
		return bTopLeft;
	}

	public JButton getbTopRight() {
		return bTopRight;
	}

	public JButton getbBottomLeft() {
		return bBottomLeft;
	}

	public JButton getbBottomRight() {
		return bBottomRight;
	}

	public Dimension getPosizione() {
		return posizione;
	}

	public void setPosizione(Dimension posizione) {
		this.posizione = posizione;
	}
	
}
