package interfaccia;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import campo.CentroCampo;
import campo.Giocatore;
import campo.Pedina;
import carte.Carta;

public class Gui extends JFrame implements Interfaccia{

	
	
	private JPanel visualeGiocatore;
	private JPanel selettoreLato;
	private JPanel tabellone;
	private JPanel centroCampo;
	private JPanel livelloVisualizzato;
	private ArrayList <GVisualeGioco> visualiGioco;
	
	private final int nGiocatori;
	
	//private Dimension dimensioniSchermo;

	
	public Gui() {
		
		
		
		this.setSize(1920,1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); //Mi apre la finsetra in centro
		this.setTitle("Codex");
		
		nGiocatori = 2; //Ovviamente è temporanea come cosa
		
		
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
		selettoreLato = new GSelettoreLato();
		tabellone = new JPanel();
		centroCampo = new GCentroCampo(this);
		
		//JPANEL PRINCIPALE  : ciò che metto in questo JPanel è ciò che viene visualizzato
		
		livelloVisualizzato = new JPanel();
		livelloVisualizzato.setLayout(new BorderLayout());
		
		this.add(livelloVisualizzato);
		this.setVisible(true);
		
	}
	
	/**
	 * Visualizzao il centroCampo
	 */
	
	public void apriCentroCampo(){
		livelloVisualizzato.removeAll();
		livelloVisualizzato.add(centroCampo, BorderLayout.CENTER);
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

		//PROVVISIORIO
		
		return nGiocatori;
	}

	@Override
	public void benvenuto() {
		
		//PROVVISIORIO
		
	}

	@Override
	public Giocatore creaGiocatore(ArrayList<Pedina> pedine) {
		
		//PROVVISIORIO
		
		Giocatore giocatore = new Giocatore("Marco", pedine.get(0));
		visualiGioco.add(new GVisualeGioco(giocatore));
		return giocatore;
		
	}

	@Override
	public void visualizzaVincitore(Giocatore g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void giocaCartaIniziale(Giocatore g, Carta cartaIniziale) {
		
		GVisualeGioco visualeGiocatore = null;
		
		for(GVisualeGioco v: visualiGioco) {
			if(v.getGiocatore() == g){
				visualeGiocatore = v;
			}
		}
		
		//QUI POTREI METTERE UN ECCEZZIONE CONTROLLATA (se un giocatore non è stato traovato lancio giocaotrenotfuondexception)
		
		selezionaVisualeGiocatore(visualeGiocatore);
		
		GCarta gCartaIniziale = new GCarta(cartaIniziale);
		
		visualeGiocatore.selezioneCartaIniziale(gCartaIniziale);
		
		apriVisualeGiocatore();
		
		
		
	}

	@Override
	public void scegliCartaObiettivo(Giocatore g, Carta cartaObiettivo1, Carta cartaObiettivo2) {
		
		GVisualeGioco visualeGiocatore = null;
		
		for(GVisualeGioco v: visualiGioco) {
			if(v.getGiocatore() == g){
				visualeGiocatore = v;
			}
		}
		
		//QUI POTREI METTERE UN ECCEZZIONE CONTROLLATA (se un giocatore non è stato traovato lancio giocaotrenotfuondexception)
		
		selezionaVisualeGiocatore(visualeGiocatore);
		
		GCarta gCartaobiettivo1 = new GCarta(cartaObiettivo1);
		GCarta gCartaobiettivo2 = new GCarta(cartaObiettivo2);
		
		visualeGiocatore.scegliCartaObiettivo(gCartaobiettivo1, gCartaobiettivo2);
		
		apriVisualeGiocatore();
		
	}

	@Override
	public void giocaTurno(Giocatore g, CentroCampo centroCampo) {
		// TODO Auto-generated method stub
		
	}

}
