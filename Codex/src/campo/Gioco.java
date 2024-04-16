package campo;

import java.util.Scanner;

public class Gioco {

	//Creo scanner
	Scanner sc = new Scanner(System.in);

	private Giocatore[] giocatori;
	private int Ngiocatori=0;
	
	//Costrutto
	public Gioco() {
		this.giocatori=new Giocatore[4];
	}	
	
	public void inserisciGiocatore(String nome) {
		
		//Chiedo all'utente quando sono i giocatori 
		System.out.println("Quanti sono i giocatori? ");
		Ngiocatori=sc.nextInt();
	;
		for(int i=1; i<=Ngiocatori; i++)
		{
			if(this.giocatori[i]==null)
			{
				this.giocatori[i]=new Giocatore(nome);
				System.out.println("Giocatore: "+this.giocatori[i].getNome()+ " creato correttamente ");
			}
					
		}
	}
}
