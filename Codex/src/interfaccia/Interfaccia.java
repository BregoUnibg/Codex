package interfaccia;
import java.util.ArrayList;

import campo.Giocatore;
import campo.Pedina;

public interface Interfaccia {
	
	//IDEA MOLTO CARINA MA FORSE DIFFICILE DA IMPLEMENTARE
	//Ogni interfaccia o meglio gestore di interfaccia deve avere i medesi metodi erefitati da "ironicamente" un interfaccia JAVA
	//In questo istanzio una classe del gestore grafico che volgio e la tratto in modo indifferente nella classe gioco;
	
	public int numeroGiocatori();
	public Giocatore creaGiocatore(ArrayList <Pedina> pedine);

}
