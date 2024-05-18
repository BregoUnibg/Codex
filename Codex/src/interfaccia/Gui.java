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
		
		ArrayList <GVisualeGioco> visualiGioco = new ArrayList <GVisualeGioco>();
	
		for(int i=0;i<nGiocatori;i++) {
			visualiGioco.add(new GVisualeGioco());
		}
		
		
		
		visualeGiocatore = visualiGioco.get(1);
		
		
		selettoreLato = new GSelettoreLato();
		tabellone = new JPanel();
		centroCampo = new GCentroCampo(this);
		
		visualeGiocatore.setVisible(true);
		
		
		
		
		//JPANEL PRINCIPALE  : ciò che metto in questo JPanel è ciò che viene visualizzato
		
		livelloVisualizzato = new JPanel();
		livelloVisualizzato.setLayout(new BorderLayout());
		
		livelloVisualizzato.add(centroCampo, BorderLayout.CENTER);
		

		
		
		this.add(livelloVisualizzato);
		this.setVisible(true);
		
	}
	
	/**
	 * Visualizzao il centroCampo
	 */
	
	public void apriCentroCampo(){
		livelloVisualizzato.removeAll();
		livelloVisualizzato.add(centroCampo, BorderLayout.CENTER);
		
		//Questi due metodi mi servono per aggioranre il pannello
		livelloVisualizzato.revalidate(); 
	    livelloVisualizzato.repaint();    
	}
	
	
	/**
	 * Chiudo qualunque evento stia venendo utilizzato e torno a visualizzare il cantrocampo
	 */
	
	public void chiudiEvento(){
		livelloVisualizzato.removeAll();
		livelloVisualizzato.add(visualeGiocatore, BorderLayout.CENTER);
		
		//Questi due metodi mi servono per aggioranre il pannello
		livelloVisualizzato.revalidate(); 
	    livelloVisualizzato.repaint();    
	}
	
	
	
	//I METODI PROVVISORI SONO SOLO PER TESTARE, DEVONO ESSERE CREATI DA PEDRO
	
	@Override
	public int numeroGiocatori() {

		//PROVVISIORIO
		
		return 3;
	}

	@Override
	public void benvenuto() {
		
		//PROVVISIORIO
		
	}

	@Override
	public Giocatore creaGiocatore(ArrayList<Pedina> pedine) {
		
		//PROVVISIORIO
		
		return new Giocatore("Marco", pedine.get(0));
		
	}

	@Override
	public void visualizzaVincitore(Giocatore g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void giocaCartaIniziale(Giocatore g, Carta cartaIniziale) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scegliCartaObiettivo(Giocatore g, Carta cartaObiettivo1, Carta cartaObiettivo2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void giocaTurno(Giocatore g, CentroCampo centroCampo) {
		// TODO Auto-generated method stub
		
	}

}
