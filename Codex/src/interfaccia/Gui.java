package interfaccia;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import campo.CentroCampo;
import campo.Giocatore;
import campo.Pedina;
import carte.Carta;
import carte.CartaIniziale;
import carte.CartaObiettivo;

/**
 * Classe che si interfaccia alla logica di gioco tramite finestre grafiche
 * In essa vi è l'applicazione delle logica di gioco atraverso un interfaccia grafica interattiva da utilizzare tramite input da mouse
 * @author Gabriele
 *
 */

public class Gui extends JFrame implements Interfaccia{
	
	
	private JPanel visualeGiocatore;
	private GCentroCampo gCentroCampo;
	private JPanel livelloVisualizzato;
	private ArrayList <GVisualeGioco> visualiGioco;
	
	
	//private Dimension dimensioniSchermo;

	
	public Gui() {
		
		GMenu.finestraGioca();
		
		this.setSize(1920,1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); //Mi apre la finsetra in centro
		this.setTitle("Codex");
		
		ImageIcon imageIcon = new ImageIcon("Immagini/Icon.png"); // Carica l'immagine del logo
	    this.setIconImage(imageIcon.getImage()); // Definisce l'icona della finestra
		
		//NIENTE LAYEREDPANE
		//Per gestire il gioco non uso in layered in quanto non mi consentono di ridimensionare la fienstra
		
		//ATTENAZIONE:Ciclo invece in un singolo pane i pane che volgio visualizzare
		
		//Uno per il gioco effettivo
		//Uno per il CentroCampo
		//Uno per la scelta delle carta fronte retro
		//Uno per visualizzare il tabellone dei giocatori;
		
		
		//CERAZIONE VISUALI DI GIOCO
		
		//Livelli del gestore di visuali di gioco per il singolo giocatore
		//(Posso gestire questi livelli in un arraylist
		//Sarà quindi possibile gestire i turni in un semplice ciclo che appunto cicla l'arraylist)
		
		visualiGioco = new ArrayList <GVisualeGioco>();
		gCentroCampo = new GCentroCampo(this);
		
		//JPANEL PRINCIPALE  : ciò che metto in questo JPanel è ciò che viene visualizzato
		
		livelloVisualizzato = new JPanel();
		livelloVisualizzato.setLayout(new BorderLayout());
		
		this.add(livelloVisualizzato);
	
		//Il Frame verrà reso visibile una volta chiamata la funzione benvenuto
		//Quindi successivamente all'inserimento dei giocatori
		
	}
	
	/**
	 * Visualizzao il centroCampo
	 */
	
	public void apriCentroCampo(){
		livelloVisualizzato.removeAll();
		livelloVisualizzato.add(gCentroCampo, BorderLayout.CENTER);
		aggiornaPannello();
	}
	
	
	/**
	 * Visualizzo la visuale giocatore
	 */
	
	public void apriVisualeGiocatore(){
		livelloVisualizzato.removeAll();
		livelloVisualizzato.add(visualeGiocatore, BorderLayout.CENTER);
		aggiornaPannello();    
	}
	
	/**
	 * Cambia la visuale di gioco da quella di un giocatore all'altro
	 */
	
	public void selezionaVisualeGiocatore(GVisualeGioco v){
		this.visualeGiocatore = v;
		aggiornaPannello();
	}
	
	private void aggiornaPannello(){
		//Questi due metodi mi servono per aggioranre il pannello
		livelloVisualizzato.revalidate(); 
		livelloVisualizzato.repaint();
	}
	
	//I METODI PROVVISORI SONO SOLO PER TESTARE, DEVONO ESSERE CREATI DA PEDRO
	
	
	@Override
	public int numeroGiocatori() {

		return GMenu.slezionaNumGiocatori();
		
	}

	@Override
	public void benvenuto() {
		
		this.setVisible(true);
		
	}

	@Override
	public Giocatore creaGiocatore(Set<Pedina> pedine) {
		
		Giocatore giocatore = GMenu.creaGiocatoriConDettagli(pedine);
		visualiGioco.add(new GVisualeGioco(giocatore, this));
		return giocatore;
		
	}

	
	/**
	 * Restituiscec la visuale di gioco relativa al giocatore passato
	 * Nel caso il giocatore non sia presente tra quelli in partita viene lanciata una GiocatoreNotFoundException
	 * 
	 * @param g (Giocatore)
	 * @return	(VisualeGioco relativa all giocatore)
	 * @throws GiocatoreNotFoundException
	 */
	
	private GVisualeGioco getVisuale(Giocatore g) throws GiocatoreNotFoundException {
		
		GVisualeGioco visualeGiocatore = null;
		
		for(GVisualeGioco v: visualiGioco) {
			if(v.getGiocatore() == g){
				visualeGiocatore = v;
			}
		}
		
		if(visualeGiocatore == null)
			throw new GiocatoreNotFoundException();
		
		return visualeGiocatore;
	}
	
	
	@Override
	public void giocaCartaIniziale(Giocatore g, Carta cartaIniziale) {
		
		GVisualeGioco visualeGiocatore = null;
		
		try {
			visualeGiocatore = getVisuale(g);
		}catch(GiocatoreNotFoundException ge) {
			
			System.out.println("Fatal Error: giocatore non trovato");
			
			
		}
		//QUI POTREI METTERE UN ECCEZIONE CONTROLLATA (se un giocatore non è stato traovato lancio giocaotrenotfuondexception)
		
		selezionaVisualeGiocatore(visualeGiocatore);
		apriVisualeGiocatore();
		
		
		GCarta gCartaIniziale = new GCarta(cartaIniziale);
		
		GCarta gCartaRestituita = visualeGiocatore.selezioneCartaIniziale(gCartaIniziale);
		
		
		g.getCampoGioco().piazzaCartaIniziale((CartaIniziale) gCartaRestituita.getCarta());
		
	}

	@Override
	public void scegliCartaObiettivo(Giocatore g, Carta cartaObiettivo1, Carta cartaObiettivo2) {
		
		GVisualeGioco visualeGiocatore = null;
		
		try {
			visualeGiocatore = getVisuale(g);
		}catch(GiocatoreNotFoundException ge) {
			
			System.out.println("Fatal Error: giocatore non trovato");
			
		}
		
		//QUI POTREI METTERE UN ECCEZZIONE CONTROLLATA (se un giocatore non è stato traovato lancio giocaotrenotfuondexception)
		
		selezionaVisualeGiocatore(visualeGiocatore);
		apriVisualeGiocatore();
		
		GCarta gCartaobiettivo1 = new GCarta(cartaObiettivo1);
		GCarta gCartaobiettivo2 = new GCarta(cartaObiettivo2);
		
		GCarta gCartaRestituita = visualeGiocatore.scegliCartaObiettivo(gCartaobiettivo1, gCartaobiettivo2);
		
		
		g.setCartaObiettivoNascosto((CartaObiettivo) gCartaRestituita.getCarta());
		
		aggiornaPannello();
		
	}

	@Override
	public void giocaTurno(Giocatore g, CentroCampo centroCampo) {
		
		
		GVisualeGioco visualeGiocatore = null;
		
		try {
			visualeGiocatore = getVisuale(g);
		}catch(GiocatoreNotFoundException ge) {
			
			System.out.println("Fatal Error: giocatore non trovato");
			
		}
		
		//QUI POTREI METTERE UN ECCEZZIONE CONTROLLATA (se un giocatore non è stato traovato lancio giocatoreNotFuondException)
		
		selezionaVisualeGiocatore(visualeGiocatore);
		apriVisualeGiocatore();
		
		
		
		
		//Primaa di tutto devco aggiornare la mano caricando (o aggiornando) le carte che ho in mano
		
		
		visualeGiocatore.aggiornaMano();
		
		//Aggiorno il centrocampo
		
		
		this.gCentroCampo.setCartaRisorsa1(new GCarta(centroCampo.getCartaRisorsa1()));
		this.gCentroCampo.setCartaRisorsa2(new GCarta(centroCampo.getCartaRisorsa2()));
		this.gCentroCampo.setCartaOro1(new GCarta(centroCampo.getCartaOro1()));
		this.gCentroCampo.setCartaOro2(new GCarta(centroCampo.getCartaOro2()));
		
		//In Realtà le carte obiettivo sono fisse quindi andrebbero caricate una singola volta, per ora sono comodo così
		this.gCentroCampo.setCartaObiettivo1(new GCarta(centroCampo.getCartaObiettivo1()));
		this.gCentroCampo.setCartaObiettivo2(new GCarta(centroCampo.getCartaObiettivo2()));
		
		
		
		//Gioco una carta
		
		visualeGiocatore.giocaCarta();
		
		visualeGiocatore.aggiornaMano();
		aggiornaPannello();
		
		//Pesco una carta dal centrocampo
		
		visualeGiocatore.pescaCarta();

		GCarta gCartaPescata = gCentroCampo.pescaCarta(centroCampo);
		
		g.getMano().pescaCarta(gCartaPescata.getCarta());
		
		
	}

	@Override
	public void visualizzaVincitore(Giocatore g) {
		
		for(GVisualeGioco visGioco: visualiGioco) {
			visGioco.getBarra().azioneGiocoTerminato();
		}
		
		JOptionPane.showMessageDialog(null, "Il giocatore: "+g.getNome()+" ha vinto totalizzando "+String.valueOf(g.getPunti())+" punti!", "Vincitore", JOptionPane.INFORMATION_MESSAGE);
		
	}
}
