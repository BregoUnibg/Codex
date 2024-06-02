package interfaccia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import campo.CentroCampo;
import campo.Giocatore;
import carte.Carta;

/**
 * Rappresenta l'insieme di elementi visualizzti pecugliarmente dal singolo giocatore
 * Quindi la sua mano, il campo da gioco personale e la sua barra delle statistiche
 * 
 * @author Gabriele
 *
 */

public class GVisualeGioco extends JPanel{
	
	private GMano mano;
	private GBarraStatistiche barra;
	private GCampoGioco campo;
	private Giocatore giocatore;		//Ogni visualegioco è collegara a un giocatore
	private Gui gui;
	
	//Variabili per piazzamento carta
	
	private Dimension posizione;
	private String angolo;
	
	//Variabili per actionlisteners
	private boolean piazzaFronte;
	private boolean chiudiFinestra;
	private GCarta cartaSelezionata;
	
	public  GVisualeGioco(Giocatore giocatore, Gui gui) {
		
		this.giocatore = giocatore;
		this.gui = gui;
		
		this.setPreferredSize(new Dimension(1920,1080));
		this.setLayout(new BorderLayout());
		
		
		mano = new GMano(gui);
		barra = new GBarraStatistiche(giocatore.getNome(), giocatore.getPedina());
		campo = new GCampoGioco();
		
		
		this.add(mano, BorderLayout.SOUTH);
		this.add(barra, BorderLayout.NORTH);
		this.add(campo, BorderLayout.CENTER);
		//this.add(tabellone, BorderLayout.EAST);	
		
		this.setVisible( true);
		
	}
	
	public Giocatore getGiocatore() {
		return giocatore;
	}
	
	/**
	 * Fa apparire un popup su shcermo che visualizza sia il fronte che il retro della carta Iniziale
	 * La faccia premuta dall'utente sarà quella che verrà giocata direttamente nel campo grafico e logico
	 * 
	 * @param carta
	 * @return
	 */
	
	public GCarta selezioneCartaIniziale(GCarta c) {
		
		this.barra.azioneCartaIniziale();
		GCarta cartaIniziale;
		
		do {
			cartaIniziale = scegliFronteRetro(c);
		}while(cartaIniziale == null);
		
		campo.piazzaGCartaIniziale(cartaIniziale);
		
		return cartaIniziale;
	}
	
	/**
	 * 
	 * Permette all'utente di sceglire graficamente se impostare la carta sul fronte o sul retro
	 * 
	 * @param c: Carta di cui decidere il piazzamento
	 * @return	Carta pronta per il piazzamento
	 */
	
	private GCarta scegliFronteRetro(GCarta c){
		
		//Latch che viene messo a 0 quando premo il bottone e mi permetto di ritornare la carta
		CountDownLatch latch = new CountDownLatch(1);
		
		JFrame scegliFaccia = new JFrame();
		scegliFaccia.setSize(430,200);
		scegliFaccia.setLocationRelativeTo(null);
		//scegliFaccia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Implementa con il windowslistener qualcosa che annulli il piazzamento quando chiudo il scegli fronte retro
		
		
		scegliFaccia.setLayout(new BorderLayout());
		chiudiFinestra = false;
		
		//La chiusura del frame e il premere il bottone danno lo stesso risultato
		scegliFaccia.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	chiudiFinestra = true;
                latch.countDown();
            }
        });
		
		JPanel carta = new JPanel(new FlowLayout(FlowLayout.CENTER));
		carta.setPreferredSize(new Dimension(250,200));
		JPanel selettore = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		selettore.setPreferredSize(new Dimension(180,200));
		
		scegliFaccia.add(carta, BorderLayout.WEST);
		scegliFaccia.add(selettore, BorderLayout.EAST);
		
		carta.add(c);
		
		JLabel labelSelettore = new JLabel("Scegli il lato da giocare");
		labelSelettore.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		
		selettore.add(labelSelettore);
		
		JRadioButton bFronte = new JRadioButton("Fronte");
		bFronte.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		JRadioButton bRetro = new JRadioButton("Retro");
		bRetro.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		
		bFronte.setSelected(true);
		piazzaFronte = true;
		
		bFronte.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				piazzaFronte = true;
				c.visualizzaFronteCarta();
				
			}
			
		});
		
		bRetro.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				piazzaFronte = false;
				c.visualizzaRetroCarta();
				
			}
			
		});
		
		
		ButtonGroup scelta = new ButtonGroup();
		
		JButton gioca = new JButton("Gioca");
		gioca.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		gioca.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				latch.countDown();
				
			}
			
		});
		
		scelta.add(bFronte);
		scelta.add(bRetro);
		
		selettore.add(bFronte);
		selettore.add(bRetro);
		selettore.add(gioca);
		
		scegliFaccia.setVisible(true);
		
		try {
			
			//Faccio attendere il thread finchè non viene premuto il bottone
			latch.await();
		
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		if(chiudiFinestra) {
			System.out.println("Ritorno null");
			return null;
		
		}
		
		if(!piazzaFronte)
			c.setBack();
		
		scegliFaccia.dispose();
		return c;
	}
	
	/**
	 * Permette all'utente di scegliere graficamente quale delle due carte obiettivo proposte selezionare
	 * Nel caso venga chiusa la finestra seleizona utomaticamente il primo obiettivo
	 * 
	 * @param obiettivo1
	 * @param obiettivo2
	 * @return obiettivo seleizonato
	 */
	
	public GCarta scegliCartaObiettivo(GCarta obiettivo1, GCarta obiettivo2){
		
		this.barra.azioneCartaObiettivo();
		
		CountDownLatch latch = new CountDownLatch(1);
		
		JFrame scegliObiettivo = new JFrame();
		scegliObiettivo.setSize(450,240);
		scegliObiettivo.setLocationRelativeTo(null);
		
		JLabel descrizione = new JLabel("Scegli la tua carta obiettivo coperta");
		descrizione.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		
		descrizione.setHorizontalAlignment(SwingConstants.CENTER);
		descrizione.setPreferredSize(new Dimension(450, 40));
		
		JPanel dueCarte = new JPanel();
		dueCarte.setPreferredSize(new Dimension(450, 200));
		
		scegliObiettivo.add(descrizione, BorderLayout.NORTH);
		scegliObiettivo.add(dueCarte, BorderLayout.CENTER);
		
		dueCarte.setLayout(new GridLayout(1,2));
		
		//La chiusura del frame e il premere una delle due carte danno lo stesso risultato
		scegliObiettivo.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                latch.countDown();
            }
        });
		
		
		//Pannello Obiettivo 1/2
		JPanel po1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel po2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		dueCarte.add(po1);
		dueCarte.add(po2);
		
		po1.add(obiettivo1);
		po2.add(obiettivo2);
		
		cartaSelezionata =  obiettivo1;
		
		po1.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				cartaSelezionata = obiettivo1;
				latch.countDown();
				
			}
			
		});
		
		po2.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				cartaSelezionata = obiettivo2;
				latch.countDown();
				
			}
			
		});
		
		
		
		scegliObiettivo.setVisible(true);
		
		
		try {
			
			//Faccio attendere il thread finchè non viene premuto il bottone
			latch.await();
		
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		scegliObiettivo.dispose();
		
		mano.setGCartaObiettivoCoperto(cartaSelezionata);
		return cartaSelezionata;
	}
	
	
	
	/**
	 * Sostituisce la carte presenti nella mano con qualle passate ogni turno (aggiornando quindi la mano)
	 * In quesot modo mi sto limitando a prendere ciò chee c'è a livello logico e non sto creando uno nuova logica di gioco
	 * @param gCarte
	 */
	
	public void aggiornaMano(){
		
		ArrayList <GCarta> carteInMano = new ArrayList <GCarta>();
		
		for(int i=0;i<3;i++){
			try {
				GCarta cartaInMano = new GCarta(giocatore.getMano().getCartaIndice(i));
				carteInMano.add(cartaInMano);
			}catch(IndexOutOfBoundsException e ) {
				
			}
		}
		
		mano.aggiornaMano(carteInMano, giocatore);
		
	}
	
	
	
	
	/**
	 * Fa giocare una carta sul campo al giocatore
	 * @param g
	 */
	
	public void giocaCarta(){
		
		barra.aggiornaContatori(giocatore.getCampoGioco());
		
		boolean cartaPiazzata = false;
		
		do {
			
			this.barra.azioneScegliCartaDaGiocare();
			
			GCarta cartaGiocata = mano.scegliCartaDaGiocare();
			
			//Clono la carta in modo tale da non corrompere l'originale se la giro e gioco in un punto
			
			int idCartaGiocataOriginale = cartaGiocata.getCarta().getId();
			
			cartaGiocata = cartaGiocata.clona();
			
			//Scegli se giocare la carta sul fronte o sul retro
			
			cartaGiocata = scegliFronteRetro(cartaGiocata);
			
			if(cartaGiocata != null) {
				
				this.barra.azionePosizionaCartaInCampo();
				
				
				//Riceve la carta e il realativo angolo sul quale si vuole piazzare la carta
				campo.getPiazzamento(this);
				
				
				Carta cartaLogicaSotto = cartaSelezionata.getCarta();
				
				//Visualizzo graficamente per controllare corrispondenza grafica logica
				System.out.println("Carta Giocata: ");
				Cli.visualizzaCarta(cartaGiocata.getCarta());
				System.out.println("Carta Sottostante: ");
				Cli.visualizzaCarta(cartaLogicaSotto);
				
				
				System.out.println();
				
				if(!giocatore.getCampoGioco().piazzaCarta(cartaLogicaSotto, angolo, cartaGiocata.getCarta()))
					JOptionPane.showMessageDialog(null, "Piazzamento non consentito", "Attenzione", JOptionPane.WARNING_MESSAGE);
				else{
					
					int x = (int) posizione.getWidth();
					int y = (int) posizione.getHeight();
					
					switch(angolo) {
					
					case "tl":
						x-=155;
						y-=85;
						break;
					
					case "tr":
						x+=155;
						y-=85;
						break;
					
					case "bl":
						x-=155;
						y+=85;
						break;
					
					case "br":
						x+=155;
						y+=85;
						break;
					
					}
					
					//Se il piazzamento va a buon fine aggiorno la parte logica del gioco
					
					giocatore.addPunti(cartaGiocata.getCarta().getPunti(giocatore.getCampoGioco()));
					giocatore.getMano().giocaCartaId(idCartaGiocataOriginale);
					
					campo.piazzaCarta(cartaGiocata, new Dimension(x,y));
					
					cartaPiazzata = true;
					
				}
				
			}
			
		}while(!cartaPiazzata);
		
		barra.aggiornaContatori(giocatore.getCampoGioco());
		
		revalidate();
		repaint();
	}
	
	
	
	/**
	 * Pesca una carta dal centrocampo 
	 * @param g
	 * @param c
	 */
	
	public void pescaCarta() {
		
		this.barra.azionePescaCarta();
		
	}
	
	
	public void setPosizione(Dimension posizione) {
		this.posizione = posizione;
	}
	
	public void setAngolo(String angolo) {
		this.angolo = angolo;
	}
	
	public void setCartaSelezionata(GCarta cartaSelezionata) {
		this.cartaSelezionata = cartaSelezionata;
	}
	
	public GBarraStatistiche getBarra() {
		return barra;
	}

}
