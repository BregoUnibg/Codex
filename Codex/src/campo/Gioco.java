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
		System.out.println("giocatore: "+this.giocatori[1]+ " creato correttamente ");
		Ngiocatori=sc.nextInt();
	;
		for(int i=1; i<=Ngiocatori; i++)
		{
			if(this.giocatori[i]==null)
			{
				this.giocatori[0]=new Giocatore(nome);
				System.out.println("giocatore: "+this.giocatori[0]+ " creato correttamente ");
			}
					
		}
	}
}
