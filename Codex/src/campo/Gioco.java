package campo;

import java.util.ArrayList;

import interfaccia.Cli;

public class Gioco {
	
	//La classe gioco è ciò che gestirà tutti i turni
	//La callsse gioco è ciò che farà andare effettivamente il gioco e chiamerà  le interfacce quando sarà richiesta una scelta dall'utente
	
	
	private ArrayList <Giocatore> giocatori;
	private CentroCampo centro;
	private Tabellone tabella;
	private Cli cli;
	private ArrayList <Pedina> pedine; //Avrei voluto farlo con un set ma il mio IDE non lo importa per quallche ragione (Forse è obsoleto?)
	
	//Costrutto
	public Gioco() {
		
		giocatori = new ArrayList <Giocatore>();
		centro = new CentroCampo();
		tabella = new Tabellone();
		cli = new Cli();
		pedine = new ArrayList <Pedina>();
		 	pedine.add(Pedina.VERDE);
	        pedine.add(Pedina.ROSSA);
	        pedine.add(Pedina.NERA);
	        pedine.add(Pedina.GIALLA);
	        pedine.add(Pedina.AZZURRA);
	}	
	
	
	//Questa in liena di massima sarà il metodo principale
	public void gioca(){
		
		//C'è da implementare il selettore di interfaccia
		
		int ngiocatori = 2; //Provvvisorio ovviamente
		
		for(int i=0;i<ngiocatori;i++) {
			Giocatore giocatore = cli.creaGiocatore(pedine);
			giocatori.add(giocatore);
		}
		
		
		
		
	}
}
