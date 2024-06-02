package interfaccia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.CountDownLatch;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import campo.CentroCampo;
import carte.Carta;
import carte.CartaRisorsa;
import carte.Colore;

/**
 * Rappresenta il centro campo ove vi sono mazzi e le quattro carte centrali e le sue carte obiettivo condivise
 * @author Gabriele
 *
 */

public class GCentroCampo extends JPanel{
	
	private Gui gui;
	private CentroCampo centroCampoLogico;
	
	private	JPanel cella1;
	private	JPanel cella2;
	private	JPanel cella3;
	private	JPanel cella4;
	private	JPanel cella5;
	private	JPanel cella6;
	private	JPanel cella7;
	private	JPanel cella8;
	
	private GCarta cartaSelezionata;	//Mi serve per il metodo selezionaCarta che simula il pescaggio della carta
	private CountDownLatch latch;			//latch che mi permette di gestire i thread quando aspetto che una carta venga cliccata
	
	
	public GCentroCampo(Gui gui) {
		
		this.gui = gui;
		
		this.setPreferredSize(gui.getPreferredSize());
		this.setLayout(new GridBagLayout());
       
		JPanel selettoreCarta = new JPanel();
		
		/*
		
		//Distanziamento dall'alto e da sinistra
		JPanel spazioTop = new JPanel();
		JPanel spazioLeft = new JPanel();
		JPanel spazioRight = new JPanel();
		JPanel spazioBottom = new JPanel();
		
		
		//Questo funziona ma non prende le dimensioni attuali della finestra quando viene crata a li simensioni del setSize in Gui
		
		spazioTop.setPreferredSize(new Dimension(100, (int) gui.getHeight()/6));
		spazioLeft.setPreferredSize(new Dimension((int) (gui.getWidth()/5),100));
		spazioBottom.setPreferredSize(new Dimension(100, (int) gui.getHeight()/6));
		spazioRight.setPreferredSize(new Dimension((int) (gui.getWidth()/5),100));
		
		*/
		
		//selettoreCarta.setPreferredSize(new Dimension(500,400));		Ababstanza inutile dati che è il Layout che gestisce la dimensione
		selettoreCarta.setLayout(new BorderLayout());
		Dimension sizeSelettore =new Dimension(1050,600);
		selettoreCarta.setPreferredSize(sizeSelettore);
		selettoreCarta.setMinimumSize(sizeSelettore);
		selettoreCarta.setMaximumSize(sizeSelettore);
		
		//Carte disponibili
		
		JPanel carte = new JPanel();
		carte.setLayout(new GridLayout(2,4));
		
		
		cella1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10 ,(int) gui.getHeight()/15));
		cella2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10 ,(int) gui.getHeight()/15));
		cella3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10 ,(int) gui.getHeight()/15));
		cella4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10 ,(int) gui.getHeight()/15));
		cella5 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10 ,(int) gui.getHeight()/15));
		cella6 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10 ,(int) gui.getHeight()/15));
		cella7 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10 ,(int) gui.getHeight()/15));
		cella8 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10 ,(int) gui.getHeight()/15));
		
		carte.add(cella1);	
		carte.add(cella2);	
		carte.add(cella3);	
		carte.add(cella4);	
		carte.add(cella5);	
		carte.add(cella6);	
		carte.add(cella7);	
		carte.add(cella8);	
		
		cella1.add(new GCarta(new CartaRisorsa(Colore.ROSSO, 0, "Immagini/Carte/xRetroVerdeRisorsa.png")));
		cella2.add(new GCarta());
		cella3.add(new GCarta());
		cella4.add(new GCarta());
		cella5.add(new GCarta(new CartaRisorsa(Colore.ROSSO, 0, "Immagini/Carte/xRetroRossaOro.png")));
		cella6.add(new GCarta());
		cella7.add(new GCarta());
		cella8.add(new GCarta());
		
		addActionListenerCella(cella1, "m1");
		addActionListenerCella(cella2, "r1");
		addActionListenerCella(cella3, "r2");
		addActionListenerCella(cella4, "");
		addActionListenerCella(cella5, "m2");
		addActionListenerCella(cella6, "o1");
		addActionListenerCella(cella7, "o2");
		addActionListenerCella(cella8, "");

		
		//Tasto esci in basso 
		
		JPanel esci = new JPanel();
		esci.setPreferredSize(new Dimension(100,100));
		
		
		JLabel croce = new JLabel();		
		ImageIcon icon = new ImageIcon("Immagini/croce.png");
		Image img = icon.getImage();
		img = img.getScaledInstance(50, 50, 0);
		icon = new ImageIcon(img);
		
		
		
		croce.setIcon(icon);
		croce.setText("Esci");
		croce.setForeground(Color.LIGHT_GRAY);
		croce.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		
		croce.setBorder(BorderFactory.createEmptyBorder(24, 0, 0, 0));
		
		croce.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
					System.out.println("Stai chiudendo il cantrocampo");
					gui.apriVisualeGiocatore(); 
			}
			
		});

		esci.add(croce);
		
		selettoreCarta.add(carte, BorderLayout.CENTER);
		selettoreCarta.add(esci, BorderLayout.SOUTH);
		
		
		   GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.weightx = 1.0;
	        gbc.weighty = 1.0;
	        gbc.anchor = GridBagConstraints.CENTER;

	        // Aggiunta del JPanel al JFrame
	        this.add(selettoreCarta, gbc);
		
		
		
		/*
		this.add(spazioTop, BorderLayout.NORTH);
		this.add(spazioBottom, BorderLayout.SOUTH);
		this.add(spazioLeft, BorderLayout.WEST);		
		this.add(spazioRight, BorderLayout.EAST);
		*/
		
		this.setVisible(true);
	}
	
	
	
	
	/**
	 * Permette di rilevare quando una cella è stata premuta e di conseguenza la carta selezionata
	 * @param cella
	 */
	
	private void addActionListenerCella(JPanel cella, String tipoCella) {
		
		cella.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				cartaSelezionata = ((GCarta) cella.getComponent(0));
				boolean cartaPescata = false;
				
				try {
				
				switch(tipoCella) {
				
				case "m1":
					
					cartaSelezionata = new GCarta(centroCampoLogico.pescaDalMazzoRisorsa());
					cartaPescata = true;
					break;
				
				case "m2":
					cartaSelezionata = new GCarta(centroCampoLogico.pescaDalMazzoOro());
					cartaPescata = true;
					break;
				
				case "r1":
					centroCampoLogico.prendiCartaRisorsa1();
					cartaPescata = true;
					break;
				
				case "r2":
					centroCampoLogico.prendiCartaRisorsa2();
					cartaPescata = true;
					break;
				
				case "o1":
					centroCampoLogico.prendiCartaOro1();
					cartaPescata = true;
					break;
				
				case "o2":
					centroCampoLogico.prendiCartaOro2();
					cartaPescata = true;
					break;
				
				default:
					break;
				}
				
				
				}catch(NullPointerException ex) {
					System.out.println("Non è il momento di pescare la carta");
				}
				
				System.out.println("Ho selezionato la carta");
				
				try {
					//Abbasso il latch per notificare il thread che la carta è stata scelta
					if(cartaPescata)
						latch.countDown();
				
				}catch(NullPointerException e1) {
					System.out.println("Non devo scegliere una carta");
				}
				
			}
			
		});
		
	}
	
	public GCarta pescaCarta(CentroCampo centroCampoLogico) {
		
		this.revalidate(); 
		this.repaint();
		
		
		this.centroCampoLogico = centroCampoLogico;
		
		latch = new CountDownLatch(1);
		
		try {
			
			latch.await();
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return cartaSelezionata;
	}
	
	
	public void setCartaRisorsa1(GCarta g){
		cella2.removeAll();
		cella2.add(g);
	}
	
	public void setCartaRisorsa2(GCarta g){
		cella3.removeAll();
		cella3.add(g);
	}
	
	public void setCartaOro1(GCarta g){
		cella6.removeAll();
		cella6.add(g);
	}
	
	public void setCartaOro2(GCarta g){
		cella7.removeAll();
		cella7.add(g);
	}

	public void setCartaObiettivo1(GCarta g){
		cella4.removeAll();
		cella4.add(g);
	}
	
	public void setCartaObiettivo2(GCarta g){
		cella8.removeAll();
		cella8.add(g);
	}
	
}
