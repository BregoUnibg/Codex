package interfaccia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import campo.Giocatore;

public class GMano extends JPanel{
	
	private JPanel mano;
	private JPanel selettoresx;
	private JPanel obiettivo;
	private Gui gui;
	private JProgressBar barraPunti;
	
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
		selettoresx.setBackground(Color.BLACK);
		selettoresx.setPreferredSize(new Dimension(300,300));

		obiettivo = new JPanel(new FlowLayout(FlowLayout.CENTER, 25,25));
		obiettivo.setBackground(Color.BLACK);
		obiettivo.setPreferredSize(new Dimension(300,300));

		
		//Spazio dove vengono effettivamente visualizzate le carte
		
		mano = new JPanel();
		mano.setBackground(Color.DARK_GRAY);
		
		
		
		mano.setLayout(new FlowLayout(FlowLayout.CENTER, 25,25)); //Spaziamento Vertical ed Orizzontale
		
		this.add(selettoresx, BorderLayout.WEST);
		this.add(mano, BorderLayout.CENTER);
		this.add(obiettivo, BorderLayout.EAST);
		
		
		
		//SELETTORE DI SINISTRA
		//Deve permettermi di arpire il centrocampo
		
		selettoresx.setLayout(new FlowLayout(FlowLayout.CENTER, 25,25));
		
		JButton apriCentro = new JButton("Centro Campo"); //Si in italiano si scrive tutto attaccato
		apriCentro.setPreferredSize(new Dimension(150,40));
		
		apriCentro.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e){
				
				gui.apriCentroCampo();
				
			}
			
		});
		
		this.barraPunti = new JProgressBar(0,20);
		this.barraPunti.setPreferredSize(new Dimension(250,50));
		this.barraPunti.setForeground(Color.GREEN);
		this.barraPunti.setBackground(Color.BLACK);
		this.barraPunti.setFont(new Font("Arial", Font.BOLD, 25));
		this.barraPunti.setStringPainted(true);
		
		
		selettoresx.add(apriCentro);
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
		this.barraPunti.setString(String.valueOf(barraPunti.getValue()));
		
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
			public void mouseClicked(MouseEvent e) {
				
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
