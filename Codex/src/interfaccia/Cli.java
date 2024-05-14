package interfaccia;

import java.util.ArrayList;
import java.util.Scanner;

import campo.CentroCampo;
import campo.Giocatore;
import campo.Pedina;
import carte.Carta;
import carte.CartaIniziale;
import carte.CartaObiettivo;
import carte.CartaOro;
import carte.CartaRisorsa;

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
		System.out.println("Pedine disponibili");
		
		int i=0;
		
		for(Pedina pedina: pedine) {
			System.out.println(i+"-"+pedina);
			i++;
		}
		
		System.out.println();
		
		int scelta;
		
		do {
			try{
				System.out.println("Scegliere la pedina (0-"+(pedine.size()-1)+")");
				scelta= Integer.parseInt(sc.nextLine());	//Mi ricordo che il prof consigliava di fare così proabilmente per l'acapo
			}catch(NumberFormatException e) {
				scelta = -1;
			}
			}while(scelta<0 || scelta >= (pedine.size()));
		
		Pedina pedScelta = pedine.get(scelta);
		pedine.remove(scelta);
		
		return new Giocatore(nome, pedScelta);
		
	}

	@Override
	public int numeroGiocatori() {
		
		int scelta;
		
		do {
			System.out.println("Inserire il numero di giocatori (2-4)");
			try {
				scelta = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e) {
				scelta = 0; //Metto apposta un valore non accettabile per rifare il loop
			}
		}while(scelta<2||scelta>4);
		
		return scelta;
	}
	
	

	@Override
	public void giocaCartaIniziale(Giocatore g, Carta cartaIniziale) {
		
		System.out.println("Ciao "+g.getNome());
		
		System.out.println("Ecco la tua carta iniziale, essa verrà piazzata in centro al tuo campo di gioco e sarà la radice del tuo campo");
		
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
	
	
	
	/**
	 * Scelgi tra una di due carte obiettivo pesscate
	 */
	
	
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
			try {
			scelta = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Insrire un valore numerico");
				scelta = -1;
			}
		}while(scelta<1 || scelta>2);
		
		if(scelta==1)
			g.setCartaObiettivoNascosta((CartaObiettivo) cartaObiettivo1);
		else
			g.setCartaObiettivoNascosta((CartaObiettivo) cartaObiettivo2);
		
		
	}
	
	
	public void giocaTurno(Giocatore g, CentroCampo centro){
		
		int scelta;
		boolean cartapiazzata = false;
		
		System.out.println("E' il tuo turno "+g.getNome());
		
		//Ciclo per il piazzamento della carta (Prima parte del turno)
		
		do {
			
			do{
				
				System.out.println();
				System.out.println("Scegliere un Azione");
				System.out.println();
				System.out.println("1 - Visualizzare le carte in mano");
				System.out.println("2 - Visualizzare le carte sul proprio campo di gioco");
				System.out.println("3 - Giocare una carta");
				
				try {
					scelta = Integer.parseInt(sc.nextLine());
				}catch(NumberFormatException e) {
					scelta = 0;
				}
				
			}while(scelta<1 || scelta>3);
		
			switch(scelta) {
			
			case 1:
				
				visualizzaCarta(g.getMano().getCartaIndice(0));
				visualizzaCarta(g.getMano().getCartaIndice(1));
				visualizzaCarta(g.getMano().getCartaIndice(2));
				break;
				
			case 2:
				visualizzaCampoGioco(g);
				break;
				
			case 3:
				
				Carta cartasotto, cartasopra;
				int id, idcartagiocata;
				String angolo;
				
				do {
					
					System.out.println();
					System.out.println("Inserire l'id della carta in mano che si vuole giocare: ");
					
					try {
						id = Integer.parseInt(sc.nextLine());
					}catch(NumberFormatException e) {
						System.out.println("Inserire un id coerente");
						id = -1;
					}
					
					cartasopra = g.getMano().getCartaId(id); //devo ancora giocarla (toglierla dalla mano)
					visualizzaCarta(cartasopra);
					
					idcartagiocata = id;
					
				}while(cartasopra==null);
				
				
				String fr;	//Scelta fronte/retro
				
				System.out.println();
				
				do {
					
					System.out.println("Desideri piazzarla sul fronte o sul retro (fronte/retro):" );
					fr = sc.nextLine();
					
				}while((!fr.equals("fronte"))&&(!fr.equals("retro")));
				
				Carta cartagiocata = cartasopra.clona();
				
				if(fr.equals("retro"))
					cartagiocata.setBack();
					
		
				do {
					
					System.out.println();
					System.out.println("Inserire l'id della carta sul campo sul quale si vuole piazzare la carte precedentemenre selezionata: ");
					
					try {
						id = Integer.parseInt(sc.nextLine());
					}catch(NumberFormatException e) {
						System.out.println("Inserire un id coerente");
						id = -1;
					}
					
					cartasotto= g.getCampoGioco().getCartaPiazzataById(id);
					visualizzaCarta(cartasotto);
					
				}while(cartasotto==null);
				
				
				System.out.println("Scegli su quale angolo piazzare la carta:");
				System.out.println("tl = Top Left (angolo in alto a sinistra)");
				System.out.println("tr = Top Right (angolo in alto a destra)");
				System.out.println("bl = Bottom Left (angolo in basso a sinistra)");
				System.out.println("br = Bottom Right (angolo in basso a destra)");
				
				angolo = sc.nextLine();
					
				
				//Se la carta viene giocata correttamente
				
				if(!g.getCampoGioco().piazzaCarta(cartasotto, angolo, cartagiocata))
					System.out.println("Non è stato scelto un angolo consono al piazzamento");
				else {
					g.addPunti(cartagiocata.getPunti(g.getCampoGioco())); //Aggiunge al giocatori i punti ottenuti piazzando la carta
					g.getMano().giocaCartaId(idcartagiocata);	//La carta clonata in teroia sarà uguale a quella iniziale per eccezione 
					//Però dell'identificativo, in quanto è stato invocato un nuovo costruttore che calcola un nuovo id, questo non influisce però in alcun modo sulle funzionalità del gioco in se
					cartapiazzata = true;
				}
				break;
			
			}
			
		}while(!cartapiazzata);
		
		//Voglio far vedere i punti del giocatore dopo che è stata piazzata la carta
		
		System.out.println();
		System.out.println("Punti attuali del giocatore: "+g.getPunti());
		System.out.println("Premere INVIO per continuare...");
		sc.nextLine();
		
		//Ciclo per la selezione della nuova carta (Seconda parte del turno)
		
		System.out.println("Ecco le carte presenti nel centro campo: ");

		visualizzaCarta(centro.getCartaRisorsa1());
		visualizzaCarta(centro.getCartaRisorsa2());
		visualizzaCarta(centro.getCartaOro1());
		visualizzaCarta(centro.getCartaOro2());
			
		do {
		
			System.out.println("Scegliere un opzione tra le seguenti (1-6)");
			
			System.out.println();
			System.out.println("1 - Prendere la prima carta risorsa");
			System.out.println("2 - Prendere la seconda carta risorsa");
			System.out.println("3 - Prendere la prima carta oro");
			System.out.println("4 - Prendere la seconda carta oro");
			System.out.println("5 - Pesca dal mazzo delle carte risorsa");
			System.out.println("6 - Pesca dal mazzo delle carte oro");
			
			scelta = Integer.parseInt(sc.nextLine());
			
		}while(scelta<1 || scelta>6);
		
		switch(scelta) {
		
		case 1:
			g.getMano().pescaCarta(centro.prendiCartaRisorsa1());
			break;
		
		case 2:
			g.getMano().pescaCarta(centro.prendiCartaRisorsa2());
			break;
			
		case 3:
			g.getMano().pescaCarta(centro.prendiCartaOro1());
			break;
			
		case 4:
			g.getMano().pescaCarta(centro.prendiCartaOro2());
			break;
	
		case 5:
			g.getMano().pescaCarta(centro.pescaDalMazzoRisorsa());
			break;
		
		default:
			g.getMano().pescaCarta(centro.pescaDalMazzoOro());
			break;
			
		}
		
		
	}
	
	public void visualizzaVincitore(Giocatore g) {
		
		System.out.println("ABBIAMO UN VINCITORE!!!");
		System.out.println();
		System.out.println(g.getNome()+" ha vinto totalizzando: "+g.getPunti()+" punti");
		
	}
	
	private void visualizzaCampoGioco(Giocatore g) {
		
		ArrayList <Carta> carte = g.getCampoGioco().getCarteSulCampo();
		
		System.out.println("Carte sul campo");
		
		for(Carta c: carte) {
			System.out.println("Id: "+c.getId());
		}
		
		int scelta;
		
		do {
		
			System.out.println("Inserire l'id della carta da visualizzare (0 per uscire)");
			try {
				scelta = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Inserire un valore numerico");
				scelta = -1;
			}
			visualizzaCarta(g.getCampoGioco().getCartaPiazzataById(scelta));
			
		}while(scelta != 0);
	
		
		
	}
	
	/**
	 * Visualizza la faccia di una carta 	
	 * @param carta
	 */
	
	//Dato che a parte per il piazzamento delle carta iniziale in pratica verrà sempre chiamato questo obiettivo, possiamo ritenerci soddisfatti (per ora)
	
	private void visualizzaCarta(Carta carta) {
		
		int stdp = 10; //Padding standard delle stringhe
		
		System.out.println();
		
		if(carta == null) {
				System.out.println("Carta non reperibile");
				return;
		}
		
		System.out.println("Id carta: "+carta.getId());
		System.out.println();
		
		if(carta instanceof CartaIniziale) {
			
			
			System.out.println("Carta Iniziale");
			System.out.println();
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
			
			System.out.println("Carta Obiettivo");
			System.out.println();
			System.out.println(((CartaObiettivo) carta).getDescrizione());
			return;
		}
			
		if(carta.getFigura()==null){ //Se questa condizione è verificata la carta è stata giocata sul fronte, non è quindi necessatio mostrare la figura centrale
		
			if(carta instanceof CartaRisorsa) {
				
				int punticarta = carta.getPunti(null);

				System.out.println("Carta Risorsa");
				System.out.println();
				
				if(punticarta==0) {
				
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
					System.out.println("|                                                                              |");
					System.out.println("|                                                                              |");
					System.out.println("|                                                                              |");
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
					
				}
				else {
					
					System.out.println("|-------------------------------------------------------------------------------|");
					System.out.println("|                                      |"+carta.getPunti(null)+"|                                      |");
					System.out.print("|Scoperto: "+paddingStringa( String.valueOf(carta.getTop_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
					System.out.print("	               ---                 ");
					System.out.println("|Scoperto: "+paddingStringa( String.valueOf(carta.getTop_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
					System.out.print("|Figura:   "+paddingStringa( String.valueOf(carta.getTop_left_angle().getFigura()), stdp)+"|");
					System.out.print("	                                   ");
					System.out.println("|Figura:   "+paddingStringa( String.valueOf(carta.getTop_right_angle().getFigura()), stdp)+"|");
					System.out.println("|                                                                               |");
					System.out.println("|-------------------------------------------------------------------------------|");
					System.out.println("|                                                                               |");
					System.out.println("|                                                                               |");
					System.out.println("|                                                                               |");
					System.out.println("|-------------------------------------------------------------------------------|");
					System.out.println("|                                                                               |");
					System.out.print("|Scoperto: "+paddingStringa( String.valueOf(carta.getBottom_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
					System.out.print("	                                   ");
					System.out.println("|Scoperto: "+paddingStringa( String.valueOf(carta.getBottom_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
					System.out.print("|Figura:   "+paddingStringa( String.valueOf(carta.getBottom_left_angle().getFigura()), stdp)+"|");
					System.out.print("	                                   ");
					System.out.println("|Figura:   "+paddingStringa( String.valueOf(carta.getBottom_right_angle().getFigura()), stdp)+"|");
					System.out.println("|                                                                               |");
					System.out.println("|-------------------------------------------------------------------------------|");
					
				}
			}
			else {
				
				//Per visualizzare il punteggio hai shiftato tutto di 1
				
				System.out.println("Carta Oro");
				System.out.println();
				System.out.println(((CartaOro)carta).getDescrizione()); //Nella descrizione verrà descritto l'obiettivo e il requisito di piazzamento
				System.out.println();
				System.out.println("|-------------------------------------------------------------------------------|");
				System.out.println("|                                      |"+((CartaOro) carta).getPuntistd()+"|                                      |");
				System.out.print("|Scoperto: "+paddingStringa( String.valueOf(carta.getTop_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
				System.out.print("	               ---                 ");
				System.out.println("|Scoperto: "+paddingStringa( String.valueOf(carta.getTop_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
				System.out.print("|Figura:   "+paddingStringa( String.valueOf(carta.getTop_left_angle().getFigura()), stdp)+"|");
				System.out.print("	                                   ");
				System.out.println("|Figura:   "+paddingStringa( String.valueOf(carta.getTop_right_angle().getFigura()), stdp)+"|");
				System.out.println("|                                                                               |");
				System.out.println("|-------------------------------------------------------------------------------|");
				System.out.println("|                                                                               |");
				System.out.println("|                                                                               |");
				System.out.println("|                                                                               |");
				System.out.println("|-------------------------------------------------------------------------------|");
				System.out.println("|                                                                               |");
				System.out.print("|Scoperto: "+paddingStringa( String.valueOf(carta.getBottom_left_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top left
				System.out.print("	                                   ");
				System.out.println("|Scoperto: "+paddingStringa( String.valueOf(carta.getBottom_right_angle().getScoperto()), stdp)+"|"); //Scoperto angolo top right
				System.out.print("|Figura:   "+paddingStringa( String.valueOf(carta.getBottom_left_angle().getFigura()), stdp)+"|");
				System.out.print("	                                   ");
				System.out.println("|Figura:   "+paddingStringa( String.valueOf(carta.getBottom_right_angle().getFigura()), stdp)+"|");
				System.out.println("|                                                                               |");
				System.out.println("|-------------------------------------------------------------------------------|");
				
			}
		}
		else { //La carta è stata giocacta sul retro
			
			
			System.out.println("Carta Sul Retro");
			System.out.println();
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
			System.out.println("|                                 |"+paddingStringa("",stdp)+"|                                 |");
			System.out.println("|                                 |"+paddingStringa( String.valueOf(carta.getFigura()),stdp)+"|                                 |");
			System.out.println("|                                 |"+paddingStringa("",stdp)+"|                                 |");	
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
			
			
		}
		
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
