package campo;

import java.util.ArrayList;
import java.util.Scanner;
import interfaccia.Cli;
import interfaccia.Gui;
import interfaccia.Interfaccia;


public class Gioco {
	
	//La classe gioco è ciò che gestirà tutti i turni
	//La callsse gioco è ciò che farà andare effettivamente il gioco e chiamerà  le interfacce quando sarà richiesta una scelta dall'utente
	
	
	private ArrayList <Giocatore> giocatori;
	private CentroCampo centro;
	private Tabellone tabella;
	private Interfaccia interfaccia;
	private ArrayList <Pedina> pedine; //Avrei voluto farlo con un set ma il mio IDE non lo importa per quallche ragione (Forse è obsoleto?)
	
	//Costrutto
	public Gioco() {
		
		sceltaInterfaccia();	//Selettore di interfaccia
		
		giocatori = new ArrayList <Giocatore>();
		centro  = new CentroCampo();
		tabella = new Tabellone();
		pedine = new ArrayList <Pedina>();
		 	pedine.add(Pedina.VERDE);
	        pedine.add(Pedina.ROSSA);
	        pedine.add(Pedina.NERA);
	        pedine.add(Pedina.GIALLA);
	        pedine.add(Pedina.AZZURRA);
	}	
	
	
	/**
	 * Scescli l'interfaccia da utilizzare
	 * Di dedfault cli
	 */
	
	private void sceltaInterfaccia() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Che interfaccia si desidera utilizzare (gui - cli (default)): " );
		
		String scelta = sc.nextLine();
		
		if(scelta.equals("gui") || scelta.equals("GUI"))
			interfaccia = new Gui();
		else
			interfaccia = new Cli();
		
		
	}
	
	
	//IMPORTANTE REGOLA DI GIOCO
	//CARTE OBIETTIVO IL PUNTEGGIO E' CALCOLATO ALLA FINE
	//CARTE ORO: REQUISITO DI PAIZZAMNTO SODDISFATTO PRIMA CHE VENGA PIAZZATA
	//CARTE ORO: REQUISITO PER FAR GUADAGNARE PUNTICALCOLATO IMMEDIATAMENTE DOPO CHE LA CARTA E' STATA PIAZZATA (poi non viene più considerato)
	//TUTTI GLI OBIETTIVI SONO INFUENZATI DA MOLTIPLICATORE
	//GLI OBIETTIVI DELLE CARTE OBIETTIVO NON INFLUISONO NEI PRIMI 20 PUNTI MA VENGONO CALCOLATI ALLA FINE COME EXTRA;
	//PER FARE PUNTI PUNTI PER ARRIVARE AI 20 SI SFRUTTANO SOLO CARTE RISORSA ORO E I LORO OBIETTIVI
	
	//Questa in liena di massima sarà il metodo principale
	public void gioca(){
		
		int ngiocatori = interfaccia.numeroGiocatori(); 
		
		//Creazione dei giocatori
		
		for(int i=0;i<ngiocatori;i++) {
			Giocatore giocatore = interfaccia.creaGiocatore(pedine);
			giocatori.add(giocatore);
		}
		
		
		
		//Il giocatore riceve la carta iniziale e decide se piazzarla sul fronte o sul retro
		
		interfaccia.benvenuto();
		
		
		for(Giocatore g: giocatori) {
			
			interfaccia.giocaCartaIniziale(g, centro.pescaDalMazzoIniziale());
			
			
		}
		
		
		//Il giocatore pesca 2 carte risorsa e 1 carta oro
		
		//Il giocatore sceglie tra una due carte obiettivo pescate
		
		
		
		//Gestione dei turni
		//I turni finiscono quando almeno uno dei giocatori realizza 20 punti senza extra delle carte obiettivo
		//Quindi probabilmente ci sarà un for che gestisce il turno perogni singolo giocatore, dentro un while che cicla i turni finchè la i 20 p sono ragggiunto o i mazzi ris e oro finiscono
		
		
		
		
	}
	

}
