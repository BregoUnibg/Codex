package interfaccia;

import java.util.ArrayList;
import java.util.Scanner;

import campo.Giocatore;
import campo.Pedina;
import carte.Carta;

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
			System.out.println(i+"-"+pedina);
			i++;
		}
		
		System.out.println();
		System.out.println("Scegliere la pedina (0-"+(pedine.size()-1)+")");
		
		int scelta;
		
		do {
			scelta= Integer.parseInt(sc.nextLine());	//Mi ricordo che il prof consigliava di fare così proabilmente per l'acapo
		}while(scelta<0 || scelta >= (pedine.size()));
		
		Pedina pedScelta = pedine.get(scelta);
		pedine.remove(scelta);
		
		return new Giocatore(nome, pedScelta);
		
	}

	@Override
	public int numeroGiocatori() {
		
		int scelta;
		
		do {
			System.out.println("Inserire il nuemro di giocatori (2-4)");
			scelta = Integer.parseInt(sc.nextLine());
		}while(scelta<2||scelta>4);
		
		return scelta;
	}
	
	

	@Override
	public int giocaCartaIniziale(Carta cartaIniziale) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void visualizzaCarta(Carta carta) {
		
		int stdp = 10; //Padding standard delle stringhe
		
		
		
		System.out.println("/-------------------------------------------------------------------------------------------------|");
		System.out.println("|");
		System.out.print("|Scoperto: "+paddingStringa( String.valueOf(carta.getTop_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
		System.out.print("\t\t\t");
		System.out.println("|Scoperto: "+paddingStringa( String.valueOf(carta.getTop_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
		System.out.print("|Figura:   "+paddingStringa( String.valueOf(carta.getTop_left_angle().getFigura()), stdp)+"|");
		System.out.print("\t\t\t");
		System.out.println("|Figura: "+paddingStringa( String.valueOf(carta.getTop_right_angle().getFigura()), stdp)+"|");
		System.out.println("|");
		System.out.println("|-------------------------------------------------------------------------------------------------|");
		System.out.println("|                                                                                                 |");
		System.out.println("|                                                                                                 |");
		System.out.println("/-------------------------------------------------------------------------------------------------|");
		System.out.println("|");
		System.out.print("|Scoperto: "+paddingStringa( String.valueOf(carta.getBottom_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
		System.out.print("\t\t\t");
		System.out.println("|Scoperto: "+paddingStringa( String.valueOf(carta.getBottom_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
		System.out.print("|Figura:   "+paddingStringa( String.valueOf(carta.getBottom_left_angle().getFigura()), stdp)+"|");
		System.out.print("\t\t\t");
		System.out.println("|Figura: "+paddingStringa( String.valueOf(carta.getBottom_right_angle().getFigura()), stdp)+"|");
		System.out.println("|");
		System.out.println("|-------------------------------------------------------------------------------------------------|");
		
	}
	
	/**
	 * Conferisce un certo padding a uni stringa
	 */
	
	private String paddingStringa(String s, int len){
		
		String modificata = new String(s);
		
		
		if(len<s.length()){
			int surpluss= len-s.length();
			for(int i=0;i<surpluss;i++) {
				modificata+=" ";
			}			
		}
		
		return modificata;
		
	}

}
