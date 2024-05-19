package interfaccia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.CountDownLatch;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GCentroCampo extends JPanel{
	
	private Gui gui;
	
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
	private boolean sceltaCartaAttiva;
	
	
	public GCentroCampo(Gui gui) {
		
		this.setBackground(Color.WHITE);
		
		this.gui = gui;
		this.sceltaCartaAttiva = false;
		
		this.setPreferredSize(gui.getPreferredSize());
		this.setLayout(new BorderLayout());
		
		JPanel selettoreCarta = new JPanel();
		
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
		
		
		//selettoreCarta.setPreferredSize(new Dimension(500,400));		Ababstanza inutile dati che è il Layout che gestisce la dimensione
		selettoreCarta.setLayout(new BorderLayout());
		
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
		
		cella1.add(new GCarta());
		cella2.add(new GCarta());
		cella3.add(new GCarta());
		cella4.add(new GCarta());
		cella5.add(new GCarta());
		cella6.add(new GCarta());
		cella7.add(new GCarta());
		cella8.add(new GCarta());
		
		addActionListenerCella(cella1);
		addActionListenerCella(cella2);
		addActionListenerCella(cella3);
		addActionListenerCella(cella4);
		addActionListenerCella(cella5);
		addActionListenerCella(cella6);
		addActionListenerCella(cella7);
		addActionListenerCella(cella8);

		
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
		croce.setFont(new Font("", Font.BOLD, 20));
		
		croce.setBorder(BorderFactory.createEmptyBorder(24, 0, 0, 0));
		
		croce.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(!sceltaCartaAttiva) {
					System.out.println("Stai chiudendo il cantrocampo");
					gui.apriVisualeGiocatore(); 
				}
			}
			
		});

		esci.add(croce);
		
		selettoreCarta.add(carte, BorderLayout.CENTER);
		selettoreCarta.add(esci, BorderLayout.SOUTH);
		
		this.add(selettoreCarta, BorderLayout.CENTER);
		this.add(spazioTop, BorderLayout.NORTH);
		this.add(spazioBottom, BorderLayout.SOUTH);
		this.add(spazioLeft, BorderLayout.WEST);		
		this.add(spazioRight, BorderLayout.EAST);
		
		
		this.setVisible(true);
	}
	
	
	
	
	/**
	 * Permette di rilevare quando una cella è stata premuta e di conseguenza la carta selezionata
	 * @param cella
	 */
	
	private void addActionListenerCella(JPanel cella) {
		
		cella.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				cartaSelezionata = ((GCarta) cella.getComponent(0));
				System.out.println("Ho selezionato la carta");
				
				try {
				//Abbasso il latch per notificare il thread che la carta è stata scelta
				latch.countDown();
				}catch(NullPointerException e1) {
					System.out.println("Non devo scegliere una carta");
				}
				
			}
			
		});
		
	}
	
	public GCarta pescaCarta() {
		
		this.sceltaCartaAttiva = true;
		latch = new CountDownLatch(1);
		
		try {
			
			latch.await();
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		this.sceltaCartaAttiva = false;
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
