package interfaccia;

import java.util.ArrayList;
import java.util.Scanner;

import campo.Giocatore;
import campo.Pedina;
import carte.Carta;
import carte.CartaIniziale;
import carte.CartaObiettivo;

public class Cli implements Interfaccia{
	
	//Scanner tastiera
	private Scanner sc = new Scanner(System.in);
	
	public Cli() {
		
	}
	
	public void benvenuto() {
		
		System.out.println();
		System.out.println("	  ,- _~.        \\               ");
		System.out.println("	 (' /|           \\        ,     ");
		System.out.println("	((  ||    /'\\  / \\  _-_  \\ /` ");
		System.out.println("	((  ||   || || || || || \\  \\   ");
		System.out.println("	 ( / |   || || || || ||/    /\\  ");
		System.out.println("	  -____- \\,/   \\/  \\,/  /  \\ ");
		System.out.println();
		System.out.println("Benvenuto in Codex Naturalis");
	    System.out.println();                             


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
	public void giocaCartaIniziale(Giocatore g, Carta cartaIniziale) {
		
		System.out.println("Ciao "+g.getNome());
		
		System.out.println("Ecco la tua carta inizale, essa verrà piazzata in centro al tuo campo di gioco e sarà la radice del tuo campo");
		
		visualizzaCartaFronteRetro(cartaIniziale);
		
		String scelta = null; 
		
		do {
		
			System.out.println("Desideri piazzarla sul fronte o sul retro (fronte/retro):" );
			scelta = sc.nextLine();
			
		}while((!scelta.equals("fronte"))&&(!scelta.equals("retro")));
		
		if(scelta.equals("retro"))
			((CartaIniziale) cartaIniziale).setBack();
		
		//return (CartaIniziale)cartaIniziale;
		
		g.getCampoGioco().piazzaCartaIniziale((CartaIniziale)cartaIniziale);
		
	}
	
	
	
	
	
	
	public void scegliCartaObiettivo(Giocatore g, Carta cartaObiettivo1, Carta cartaObiettivo2) {
		
		System.out.println("Scegli tra una delle carte obiettivo proposte");
		
		System.out.println("Opzione 1:");
		System.out.println();
		
		visualizzaCarta(cartaObiettivo1);
		
		System.out.println("Opzione 2:");
		System.out.println();
		
		visualizzaCarta(cartaObiettivo2);
		
		int scelta;		
		
		do {
			System.out.println("Scegliere una tra le carte porposte (1-2)");
			scelta = Integer.parseInt(sc.nextLine());
		}while(scelta<1 || scelta>2);
		
		if(scelta==1)
			g.setCartaObiettivoNascosta((CartaObiettivo) cartaObiettivo1);
		else
			g.setCartaObiettivoNascosta((CartaObiettivo) cartaObiettivo2);
		
		
	}
	
	
	
	
	
	
	
	
	/**
	 * Visualizza la faccia di una carta 	
	 * @param carta
	 */
	
	private void visualizzaCarta(Carta carta) {
		
		int stdp = 10; //Padding standard delle stringhe
		
		

		if(carta instanceof CartaIniziale) {
			
			
			System.out.println("|------------------------------------------------------------------------------|");
			System.out.println("|                                                                              |");
			System.out.print("|Scoperto: "+paddingStringa( String.valueOf(carta.getTop_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
			System.out.print("	                                  ");
			System.out.println("|Scoperto: "+paddingStringa( String.valueOf(carta.getTop_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
			System.out.print("|Figura:   "+paddingStringa( String.valueOf(carta.getTop_left_angle().getFigura()), stdp)+"|");
			System.out.print("	                                  ");
			System.out.println("|Figura:   "+paddingStringa( String.valueOf(carta.getTop_right_angle().getFigura()), stdp)+"|");
			System.out.println("|                                                                              |");
			System.out.println("|------------------------------------------------------------------------------|");
			System.out.println("|                                 |"+paddingStringa( String.valueOf(((CartaIniziale) carta).getFigure().get(0)),stdp)+"|                                 |");
			System.out.println("|                                 |"+paddingStringa( String.valueOf(((CartaIniziale) carta).getFigure().get(1)),stdp)+"|                                 |");
			System.out.println("|                                 |"+paddingStringa( String.valueOf(((CartaIniziale) carta).getFigure().get(2)),stdp)+"|                                 |");	
			System.out.println("|------------------------------------------------------------------------------|");
			System.out.println("|                                                                              |");
			System.out.print("|Scoperto: "+paddingStringa( String.valueOf(carta.getBottom_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
			System.out.print("	                                  ");
			System.out.println("|Scoperto: "+paddingStringa( String.valueOf(carta.getBottom_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
			System.out.print("|Figura:   "+paddingStringa( String.valueOf(carta.getBottom_left_angle().getFigura()), stdp)+"|");
			System.out.print("	                                  ");
			System.out.println("|Figura:   "+paddingStringa( String.valueOf(carta.getBottom_right_angle().getFigura()), stdp)+"|");
			System.out.println("|                                                                              |");
			System.out.println("|------------------------------------------------------------------------------|");
			
			return;
			
		}
		
		if(carta instanceof CartaObiettivo) {
			
			System.out.println(((CartaObiettivo) carta).getDescrizione());
			return;
		}
			
		
		
		System.out.println("|------------------------------------------------------------------------------|");
		System.out.println("|                                                                              |");
		System.out.print("|Scoperto: "+paddingStringa( String.valueOf(carta.getTop_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
		System.out.print("			                                             ");
		System.out.println("|Scoperto: "+paddingStringa( String.valueOf(carta.getTop_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
		System.out.print("|Figura:   "+paddingStringa( String.valueOf(carta.getTop_left_angle().getFigura()), stdp)+"|");
		System.out.print("			                                             ");
		System.out.println("|Figura:   "+paddingStringa( String.valueOf(carta.getTop_right_angle().getFigura()), stdp)+"|");
		System.out.println("|                                                                              |");
		System.out.println("|------------------------------------------------------------------------------|");
		System.out.println("|                                                                              |");
		System.out.println("|                                                                              |");
		System.out.println("|                                                                              |");
		System.out.println("|------------------------------------------------------------------------------|");
		System.out.println("|                                                                              |");
		System.out.print("|Scoperto: "+paddingStringa( String.valueOf(carta.getBottom_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
		System.out.print("			                                             ");
		System.out.println("|Scoperto: "+paddingStringa( String.valueOf(carta.getBottom_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
		System.out.print("|Figura:   "+paddingStringa( String.valueOf(carta.getBottom_left_angle().getFigura()), stdp)+"|");
		System.out.print("			                                             ");
		System.out.println("|Figura:   "+paddingStringa( String.valueOf(carta.getBottom_right_angle().getFigura()), stdp)+"|");
		System.out.println("|                                                                              |");
		System.out.println("|------------------------------------------------------------------------------|");
		
	}
	
	
	
	private void visualizzaCartaFronteRetro(Carta carta) {
		
		int stdp = 10; //Padding standard delle stringhe
		
		

		if(carta instanceof CartaIniziale) {
			
			CartaIniziale ci = (CartaIniziale) carta;
			
			System.out.println("Fronte della carta");
			
			System.out.println("|------------------------------------------------------------------------------|");
			System.out.println("|                                                                              |");
			System.out.print("|Scoperto: "+paddingStringa( String.valueOf(carta.getTop_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
			System.out.print("	                                  ");
			System.out.println("|Scoperto: "+paddingStringa( String.valueOf(carta.getTop_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
			System.out.print("|Figura:   "+paddingStringa( String.valueOf(carta.getTop_left_angle().getFigura()), stdp)+"|");
			System.out.print("	                                  ");
			System.out.println("|Figura:   "+paddingStringa( String.valueOf(carta.getTop_right_angle().getFigura()), stdp)+"|");
			System.out.println("|                                                                              |");
			System.out.println("|------------------------------------------------------------------------------|");
			System.out.println("|                                 |"+paddingStringa( String.valueOf(((CartaIniziale) carta).getFigure().get(0)),stdp)+"|                                 |");
			System.out.println("|                                 |"+paddingStringa( String.valueOf(((CartaIniziale) carta).getFigure().get(1)),stdp)+"|                                 |");
			System.out.println("|                                 |"+paddingStringa( String.valueOf(((CartaIniziale) carta).getFigure().get(2)),stdp)+"|                                 |");	
			System.out.println("|------------------------------------------------------------------------------|");
			System.out.println("|                                                                              |");
			System.out.print("|Scoperto: "+paddingStringa( String.valueOf(carta.getBottom_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
			System.out.print("	                                  ");
			System.out.println("|Scoperto: "+paddingStringa( String.valueOf(carta.getBottom_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
			System.out.print("|Figura:   "+paddingStringa( String.valueOf(carta.getBottom_left_angle().getFigura()), stdp)+"|");
			System.out.print("	                                  ");
			System.out.println("|Figura:   "+paddingStringa( String.valueOf(carta.getBottom_right_angle().getFigura()), stdp)+"|");
			System.out.println("|                                                                              |");
			System.out.println("|------------------------------------------------------------------------------|");
			System.out.println();
			
			
			System.out.println("Retro Delle carta");
			
			System.out.println();
			System.out.println("|------------------------------------------------------------------------------|");
			System.out.println("|                                                                              |");
			System.out.print("|Scoperto: "+paddingStringa( String.valueOf(ci.getBack_top_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
			System.out.print("	                                  ");
			System.out.println("|Scoperto: "+paddingStringa( String.valueOf(ci.getBack_top_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
			System.out.print("|Figura:   "+paddingStringa( String.valueOf(ci.getBack_top_left_angle().getFigura()), stdp)+"|");
			System.out.print("	                                  ");
			System.out.println("|Figura:   "+paddingStringa( String.valueOf(ci.getBack_top_right_angle().getFigura()), stdp)+"|");
			System.out.println("|                                                                              |");
			System.out.println("|------------------------------------------------------------------------------|");
			System.out.println("|                                                                              |");
			System.out.println("|                                                                              |");
			System.out.println("|                                                                              |");
			System.out.println("|------------------------------------------------------------------------------|");
			System.out.println("|                                                                              |");
			System.out.print("|Scoperto: "+paddingStringa( String.valueOf(ci.getBack_bottom_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
			System.out.print("	                                  ");
			System.out.println("|Scoperto: "+paddingStringa( String.valueOf(ci.getBack_bottom_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
			System.out.print("|Figura:   "+paddingStringa( String.valueOf(ci.getBack_bottom_left_angle().getFigura()), stdp)+"|");
			System.out.print("	                                  ");
			System.out.println("|Figura:   "+paddingStringa( String.valueOf(ci.getBack_bottom_right_angle().getFigura()), stdp)+"|");
			System.out.println("|                                                                              |");
			System.out.println("|------------------------------------------------------------------------------|");
			
			return;
			
		}
			
		
		
		System.out.println("|------------------------------------------------------------------------------|");
		System.out.println("|");
		System.out.print("|Scoperto: "+paddingStringa( String.valueOf(carta.getTop_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
		System.out.print("	                                  ");
		System.out.println("|Scoperto: "+paddingStringa( String.valueOf(carta.getTop_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
		System.out.print("|Figura:   "+paddingStringa( String.valueOf(carta.getTop_left_angle().getFigura()), stdp)+"|");
		System.out.print("	                                  ");
		System.out.println("|Figura: "+paddingStringa( String.valueOf(carta.getTop_right_angle().getFigura()), stdp)+"|");
		System.out.println("|");
		System.out.println("|------------------------------------------------------------------------------|");
		System.out.println("|                                                                              |");
		System.out.println("|                                                                              |");
		System.out.println("|                                                                              |");
		System.out.println("|------------------------------------------------------------------------------|");
		System.out.println("|");
		System.out.print("|Scoperto: "+paddingStringa( String.valueOf(carta.getBottom_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
		System.out.print("	                                  ");
		System.out.println("|Scoperto: "+paddingStringa( String.valueOf(carta.getBottom_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
		System.out.print("|Figura:   "+paddingStringa( String.valueOf(carta.getBottom_left_angle().getFigura()), stdp)+"|");
		System.out.print("	                                  ");
		System.out.println("|Figura: "+paddingStringa( String.valueOf(carta.getBottom_right_angle().getFigura()), stdp)+"|");
		System.out.println("|");
		System.out.println("|------------------------------------------------------------------------------|");
		
	}
	
	
	
	/**
	 * Conferisce un certo padding a uni stringa
	 */
	
	private String paddingStringa(String s, int len){
		
		String modificata = new String(s);
		
		
		if(len>s.length()){
			int surpluss= len-s.length();
			for(int i=0;i<surpluss;i++) {
				modificata+=" ";
			}			
		}
		
		return modificata;
		
	}


}
