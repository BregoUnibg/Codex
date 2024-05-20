package interfaccia;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.CountDownLatch;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GCampoGioco extends JScrollPane{

	private JPanel campogioco;
	private final int dim = 5000; //dimensioni del campo (è un quadrato)
	private int strato;
	

	//Variabili per actionlisteners
	private Dimension posizione;
	private String angolo;
	private GCarta cartaSelezionata;
	private CountDownLatch latch;
	
	public GCampoGioco() {
		
		campogioco = new JPanel();
		campogioco.setPreferredSize(new Dimension(dim,dim));
		campogioco.setLayout(null);
		
		latch = new CountDownLatch(0);
		
		this.strato = 100;
		
		GCarta c = new GCarta();
		
		
		c.setBounds(100, 100, c.getPreferredSize().width, c.getPreferredSize().height);
		
		//c.setLocation(100, 100);
		
		campogioco.add(c);
		

		
		campogioco.setVisible(true);
		this.setViewportView(campogioco);//Per mettere l'elemento desiderato nello scrollpane
		
		getViewport().setViewPosition(new Point(dim/3, (int) (dim/2.2)));
		
	}
	
	/**
	 * Piazza l'immagine della carta iniziale nella visualizzazione del campod i gioco
	 * @param cartaIniziale
	 */
	
	public void piazzaGCartaIniziale(GCarta cartaIniziale){
		
		cartaIniziale.setBounds(dim/2, dim/2, cartaIniziale.getPreferredSize().width, cartaIniziale.getPreferredSize().height);
		cartaIniziale.setPosizione(new Dimension(dim/2, dim/2)); //Imposta la posizione della carta nel centro del campo
		aggiungiListenerCarta(cartaIniziale);
		campogioco.add(cartaIniziale);
		
	}
	
	
	/**
	 * Piazza Graficamente una carta sul campo da gioco in dimensioni date
	 * @param gCarta
	 * @param posizione
	 */
	
	public void piazzaCarta(GCarta gCarta, Dimension posizione) {
		
		aggiungiListenerCarta(gCarta);
		gCarta.setBounds(posizione.width, posizione.height, gCarta.getPreferredSize().width, gCarta.getPreferredSize().height);
		
		System.out.println(
			    posizione.width + " " + 
			    posizione.height + " " + 
			    gCarta.getPreferredSize().width + " " + 
			    gCarta.getPreferredSize().height
			);
		
		
		
		gCarta.setPosizione(posizione);
		campogioco.add(gCarta);
		
		campogioco.setComponentZOrder(gCarta, 0);
		
	}
	
	/**
	 * Aggiunge i listener che mi permetto di capire quale angolo di quale carta in quale posizione è stato premuto
	 * @param g
	 */
	
	private void aggiungiListenerCarta(GCarta g){
		
		g.getbTopLeft().addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("Bottone in alto a sinistra premuto");
				
				posizione = g.getPosizione();
				angolo = "tl";
				cartaSelezionata = g;
				latch.countDown();
				
			}
			
		});
		
		g.getbTopRight().addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("Bottone in alto a destra premuto");
				
				posizione = g.getPosizione();
				angolo = "tr";
				cartaSelezionata = g;
				latch.countDown();
				
			}
			
		});
		
		g.getbBottomLeft().addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("Bottone in basso a sinistra premuto");
				
				posizione = g.getPosizione();
				angolo = "bl";
				cartaSelezionata = g;
				latch.countDown();
				
			}
			
		});
		
		g.getbBottomRight().addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("Bottone in basso a destra premuto");
				
				posizione = g.getPosizione();
				angolo = "br";
				cartaSelezionata = g;
				latch.countDown();
				
			}
			
		});
		
	}
	
	/**
	 * Passa le informazioni della carta premuta sul campo da gioco
	 * @param v
	 */
	
	public void getPiazzamento(GVisualeGioco v) {
		
		latch = new CountDownLatch(1);
		
		try {
			
			//Faccio attendere il thread finchè non viene premuto un angolo
			latch.await();
		
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		v.setPosizione(posizione);
		v.setAngolo(angolo);
		v.setCartaSelezionata(cartaSelezionata);
		
	}
	
}
