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
	
	//Questa in liena di massima sarà il metodo principale
	public void gioca(){
		
		int ngiocatori = interfaccia.numeroGiocatori(); 
		
		for(int i=0;i<ngiocatori;i++) {
			Giocatore giocatore = interfaccia.creaGiocatore(pedine);
			giocatori.add(giocatore);
		}
		
		
		
		
	}
	

}
