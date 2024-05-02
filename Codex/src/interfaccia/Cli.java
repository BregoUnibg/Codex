package interfaccia;

import java.util.ArrayList;
import java.util.Scanner;

import campo.Giocatore;
import campo.Pedina;

public class Cli implements Interfaccia{
	
	//Scanner tastiera
	private Scanner sc = new Scanner(System.in);
	
	public Cli() {
		
	}
	
	public void benvenuto() {
		

		System.out.println("	  ,- _~.        \\               ");
		System.out.println("	 (' /|           \\        ,     ");
		System.out.println("	((  ||    /'\\  / \\  _-_  \\ /` ");
		System.out.println("	((  ||   || || || || || \\  \\   ");
		System.out.println("	 ( / |   || || || || ||/    /\\  ");
		System.out.println("	  -____- \\,/   \\/  \\,/  /  \\ ");
		System.out.println();
		System.out.println("Benvenuto in Codex Naturalis");
	                                 


	}

	/**
	 * Crea un nuovo giocatore, viene passato un array con le pedine rimanente,
	 */
	@Override
	public Giocatore creaGiocatore(ArrayList <Pedina> pedine) {
		
		System.out.println();

		System.out.println("Inserire il nome del giocatore: ");
		String nome = sc.nextLine();
		System.out.println("Pedinte disponibili");
		
		int i=0;
		
		for(Pedina pedina: pedine) {
			System.out.print(i+"-"+pedina+"\t");
		}
		
		System.out.println();
		System.out.println("Scegliere la pedina (0-"+pedine.size()+")");
		
		int scelta;
		
		do {
			scelta= Integer.parseInt(sc.nextLine());	//Mi ricordo che il prof consigliava di fare così proabilmente per l'acapo
		}while(scelta<0 || scelta >= pedine.size());
		
		return new Giocatore(nome, pedine.get(scelta));
		
	}
	
}
