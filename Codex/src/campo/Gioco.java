package campo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import interfaccia.Cli;
import interfaccia.Gui;
import interfaccia.Interfaccia;

/**
 * Rappresenta l'intero gioco
 * In essa è contenuta l'intera logica di gioco e invocando il metodo gioca, il gioco stesso viene lanciato
 * @author Gabriele
 */

public class Gioco {
	
	//La classe gioco è ciò che gestirà tutti i turni
	//La callsse gioco è ciò che farà andare effettivamente il gioco e chiamerà  le interfacce quando sarà richiesta una scelta dall'utente
	
	
	private ArrayList <Giocatore> giocatori;
	private CentroCampo centro;
	private Interfaccia interfaccia;
	private Set <Pedina> pedine; //Avrei voluto farlo con un set ma il mio IDE non lo importa per quallche ragione (Forse è obsoleto?)
	
	//Costrutto
	public Gioco() {
		
		sceltaInterfaccia();	//Selettore di interfaccia
		
		giocatori = new ArrayList <Giocatore>();
		centro  = new CentroCampo();
		pedine = new HashSet <Pedina>();
		 	pedine.add(Pedina.VERDE);
	        pedine.add(Pedina.ROSSA);
	        pedine.add(Pedina.NERA);
	        pedine.add(Pedina.GIALLA);
	        pedine.add(Pedina.AZZURRA);
	}	
	
	
	/**
	 * Scescli tramite console quali interfacia vuoi utilizzare
	 */
	
	private void sceltaInterfaccia() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Che interfaccia si desidera utilizzare (gui - cli (default)): " );
		
		String scelta = sc.nextLine();
		
		if(scelta.equals("gui") || scelta.equals("GUI")){
			interfaccia = new Gui();
		}else
			interfaccia = new Cli();
		
		
	}
	
	
	//IMPORTANTE REGOLA DI GIOCO
	//CARTE OBIETTIVO IL PUNTEGGIO E' CALCOLATO ALLA FINE
	//CARTE ORO: REQUISITO DI PAIZZAMNTO SODDISFATTO PRIMA CHE VENGA PIAZZATA
	//CARTE ORO: REQUISITO PER FAR GUADAGNARE PUNTICALCOLATO IMMEDIATAMENTE DOPO CHE LA CARTA E' STATA PIAZZATA (poi non viene più considerato)
	//TUTTI GLI OBIETTIVI SONO INFUENZATI DA MOLTIPLICATORE
	//GLI OBIETTIVI DELLE CARTE OBIETTIVO NON INFLUISONO NEI PRIMI 20 PUNTI MA VENGONO CALCOLATI ALLA FINE COME EXTRA;
	//PER FARE PUNTI PER ARRIVARE AI 20 SI SFRUTTANO SOLO CARTE RISORSA ORO E I LORO OBIETTIVI
	
	//Questa in liena di massima sarà il metodo principale
	
	/**
	 * Avvia Codex
	 */
	
	public void gioca(){
		
		int ngiocatori = interfaccia.numeroGiocatori(); 
		
		//Creazione dei giocatori
		
		for(int i=0;i<ngiocatori;i++) {
			Giocatore giocatore = interfaccia.creaGiocatore(pedine);
			giocatori.add(giocatore);
		}
		
		
		
		
		interfaccia.benvenuto();
		
		
		for(Giocatore g: giocatori) {
			
			
			//Per far si che anche la futura interfaccia grafica sia in grado di comunicare in maniera efficace con gioco, passo il più possibile
			
			//Il giocatore riceve la carta iniziale e decide se piazzarla sul fronte o sul retro
			
			interfaccia.giocaCartaIniziale(g, centro.pescaDalMazzoIniziale());
			
			//Il giocatore pesca 2 carte risorsa e 1 carta oro
			
			g.getMano().pescaCarta(centro.pescaDalMazzoRisorsa());		
			g.getMano().pescaCarta(centro.pescaDalMazzoRisorsa());		
			g.getMano().pescaCarta(centro.pescaDalMazzoOro());		
			
			//Il giocatore sceglie tra una due carte obiettivo pescate
			
			interfaccia.scegliCartaObiettivo(g, centro.pescaDalMazzoObiettivo(), centro.pescaDalMazzoObiettivo());
			
			
		}
		
		//Gestione dei turni
		//I turni finiscono quando almeno uno dei giocatori realizza 20 punti senza extra delle carte obiettivo
		//Quindi probabilmente ci sarà un for che gestisce il turno perogni singolo giocatore, dentro un while che cicla i turni finchè la i 20 p sono ragggiunto o i mazzi ris e oro finiscono
		
		while(fineGioco()==false){
			
			for(Giocatore g: giocatori){
				interfaccia.giocaTurno(g, centro);
				if(centro.mazziVuoti())				//Se finiscono le carte nei mazzi il gioco finisce direttamente
					break;
			}
			
		}
		
		
		//Una volta finita la fase di gioco si calcolano i punti considerando le carte obiettivo
		
		Giocatore vincitore = null;
		
		int puntiGiocatoreVincente=0;
		
		ArrayList <Integer> obbFattiGiocatore = new ArrayList <Integer>(); 
		
		for(Giocatore g: giocatori) {
			
			int obbFatti = 0;
			
			int puntiObbCoperto = g.getCartaObiettivoNascosta().getPunti(g.getCampoGioco());
			if(puntiObbCoperto > 0){
				obbFatti++;
			}
			g.addPunti(puntiObbCoperto);
			
			
			int puntiCartaObb1 = centro.getCartaObiettivo1().getPunti(g.getCampoGioco());
			if( puntiCartaObb1 > 0){
				obbFatti++;
			}
			g.addPunti(puntiCartaObb1);
			
			int puntiCartaObb2 = centro.getCartaObiettivo2().getPunti(g.getCampoGioco());
			if(puntiCartaObb2 > 0){
				obbFatti++;
			}
			g.addPunti(puntiCartaObb2);
			
			obbFattiGiocatore.add(obbFatti);
			
			if(g.getPunti()>=puntiGiocatoreVincente) {
				puntiGiocatoreVincente = g.getPunti();
				vincitore = g;
			}
			
		}
		
		//Devo controllare se due giocatori hanno raggiunto lo stesso punteggio
		
		int maxPuntiRaggiunti = maxPunti();
		int giocatoriMaxPunti = 0; //Conta quanti giocatori hanno raggiunto il punteggio massimo
		
		for(Giocatore g: giocatori) {
			if(maxPuntiRaggiunti == g.getPunti())
				giocatoriMaxPunti++;
		}
		
		//se più di un giocatore hanno raggiunto i punti massimi controllo chi ha completato più carte obiettivo
		
		ArrayList <Giocatore> vincitori = new ArrayList <Giocatore>();
		
		if(giocatoriMaxPunti > 1) {
			
			int maxObb = Collections.max(obbFattiGiocatore);
			
			for(int i = 0;i<giocatori.size();i++) {
				
				//Aggiungo ai vincitori tutti quelli che hanno totalizzato il numero massimo di punti e di carte obiettivo soddisfatte
				
				if((obbFattiGiocatore.get(i) == maxObb) && (giocatori.get(i).getPunti() == maxPuntiRaggiunti)) {
					
					vincitori.add(giocatori.get(i));
					
				}
				
				
			}
			
		}
		else{
			vincitori.add(vincitore);
		}
		
		
		
		interfaccia.visualizzaVincitore(vincitori);
		
		//Ora i punteggi sono aggiornati 
		
		
		
	}
	
	/**
	 * Rileva quando i venti punti sono stati raggiunti o si sono svuotati i mazzi, ed è quindi giunta la fase 
	 * del calcolo del punteggio definitivo
	 * @return (true se la partita è giunta al termine)
	 */
	
	private boolean fineGioco(){
		
				return ((maxPunti()>=20) || centro.mazziVuoti());
				
	}
	
	/**
	 * Stabilisce qual'è il maggior punteggio totalizzato dai giocatori
	 * @return (punti massimi totalizzati)
	 */
	
	private int maxPunti(){
		
		int puntig, max = 0;
		
		for(Giocatore g: giocatori){
			puntig = g.getPunti();
			if(puntig>max) {
				max = puntig;
			}
		}
		
		return max;
		
	}
	

}
