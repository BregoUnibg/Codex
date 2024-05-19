package interfaccia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import carte.Carta;
import carte.CartaIniziale;

public class GCarta extends JPanel{
	
	private JLabel immagine;
	private Carta cartaLogica;	//Carta logica associata alla maschera grafica
	
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
		
		this.setVisible(true);
		
		
	}
	
	
	private void setImmagineCarta(String urlImmagine) {

		ImageIcon icon = new ImageIcon(urlImmagine);
		Image img = icon.getImage();
		img = img.getScaledInstance(200, 140, 0);
		icon = new ImageIcon(img);
		immagine.setIcon(icon);
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

}
