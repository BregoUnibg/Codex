package interfaccia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import campo.Giocatore;

/**
 * Mano Del Giocatore che permette di visualizzare le carte effettivamente impugnate durante gli istanti della partita
 * @author Gabriele
 */

public class GMano extends JPanel{
	
	private JPanel mano;
	private JPanel selettoresx;
	private JPanel obiettivo;
	private Gui gui;
	private JProgressBar barraPunti;
	private JLabel labelPunti;
	
	//attributi per gli action listener
	private GCarta cartaScelta;
	private CountDownLatch latch;
	
	public GMano(Gui gui) {
		
		this.gui = gui;
		
		this.setPreferredSize(new Dimension(1920,200));
		this.setBackground(Color.RED);
		this.setLayout(new BorderLayout());
		
		//Bottoni delle azioni consentite
		selettoresx = new JPanel();
		selettoresx.setBackground(new Color (10, 10, 10));
		selettoresx.setPreferredSize(new Dimension(300,300));

		obiettivo = new JPanel(new FlowLayout(FlowLayout.CENTER, 25,25));
		obiettivo.setBackground(Color.BLACK);
		obiettivo.setPreferredSize(new Dimension(300,300));
		obiettivo.setBackground(new Color (10, 10, 10));
		
		//Spazio dove vengono effettivamente visualizzate le carte
		
		mano = new JPanel();
		mano.setBackground(new Color(66, 76, 85));
		
		
		
		mano.setLayout(new FlowLayout(FlowLayout.CENTER, 25,25)); //Spaziamento Vertical ed Orizzontale
		
		this.add(selettoresx, BorderLayout.WEST);
		this.add(mano, BorderLayout.CENTER);
		this.add(obiettivo, BorderLayout.EAST);
		
		
		
		//SELETTORE DI SINISTRA
		//Deve permettermi di arpire il centrocampo
		
		selettoresx.setLayout(new FlowLayout(FlowLayout.CENTER, 25,25));
		
		JButton apriCentro = new JButton("Centro Campo"); //Si in italiano si scrive tutto attaccato
		apriCentro.setPreferredSize(new Dimension(175,50));
		apriCentro.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		
		apriCentro.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e){
				
				gui.apriCentroCampo();
				
			}
			
		});
		
		this.labelPunti = new JLabel("0", SwingConstants.CENTER);
        this.labelPunti.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
        this.labelPunti.setForeground(Color.WHITE);
		this.labelPunti.setPreferredSize(new Dimension(300,20));
		
		this.barraPunti = new JProgressBar(0,20);
		this.barraPunti.setPreferredSize(new Dimension(250,15));
		this.barraPunti.setForeground(Color.GREEN);
		this.barraPunti.setBackground(Color.BLACK);
		this.barraPunti.setStringPainted(false);
		
		
		selettoresx.add(apriCentro);
		selettoresx.add(labelPunti);
		selettoresx.add(barraPunti);
		
		
		
		this.setVisible(true);
	}
	
	/**
	 * Riceve e mostra le carte aggiornate presenti nella mano
	 * @param gCarte
	 */
	
	public void aggiornaMano(ArrayList <GCarta> gCarte, Giocatore g){
		
		//Aggiorno anche la barra dei punti
		this.barraPunti.setValue(g.getPunti());
		this.labelPunti.setText(String.valueOf(g.getPunti()));
		
		mano.removeAll();
		//Non posso usare addAll in quanto è un JFrame e non una collezione
		
		aggiungiListenerCartaPremuta(gCarte.get(0));
		mano.add(gCarte.get(0));
		aggiungiListenerCartaPremuta(gCarte.get(1));
		mano.add(gCarte.get(1));
		
		try{
			
			aggiungiListenerCartaPremuta(gCarte.get(2));
			mano.add(gCarte.get(2));
		
		}catch(IndexOutOfBoundsException e) {
			
		}
	}
	
	
	/**
	 * Rimuove dalla mano la carta giocata
	 * @param cartaGiocata
	 */
	
	private void aggiungiListenerCartaPremuta(GCarta g) {
		
		
		g.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				
				System.out.println("Hai scelto la carta da giocare");
				cartaScelta = g;
				latch.countDown();
				
			}
			
		});
	
	}
	
	
	
	public void giocaCarta(GCarta cartaGiocata) {
		
		mano.remove(cartaGiocata);
		
	}
	
	public void addCarta(GCarta c){
		mano.add(c);
	}
	
	public void setGCartaObiettivoCoperto(GCarta c){
		obiettivo.add(c);
	}
	
	public void removeCarta(GCarta c){
		mano.remove(c);
	}

	public GCarta scegliCartaDaGiocare(){
		
		latch = new CountDownLatch(1);
		
		try {
			latch.await();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return cartaScelta;
		
	}
	
}
