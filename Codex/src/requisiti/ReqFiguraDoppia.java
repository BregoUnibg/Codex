package requisiti;

import campo.CampoGioco;
import carte.Carta;
import carte.Figura;

public class ReqFiguraDoppia implements Requisito{

	//Attributi
	private Figura figura1;
	private int numFigure1;
	private Figura figura2;
	private int numFigure2;
	
	//Costruttore
	
	/**
	 *Controlla se tot figure del tipo e quantità desiderate sono presenti sul campo per due tipi
	 * di figure diverse con relative quantità
	 * 
	 * @param figura1
	 * @param numFigure1 (qta relativa a figura1)
	 * @param figura2
	 * @param numFigure2 (qta relativa a figura2)
	 */
	
	public ReqFiguraDoppia(Figura figura1, int numFigure1, Figura figura2, int numFigure2){
		
		this.figura1 = figura1;
		this.numFigure1 = numFigure1;
		this.figura2 = figura2;
		this.numFigure2 = numFigure2;
		
		
	}
	
	/**
	 * Controlla se tot figure del tipo e quantità desiderate sono presenti sul campo per due tipi
	 * di figure diverse con relative quantità
	 * 
	 * l'obiettivo è verificato per ogni minumo comune multiplo delle quantità 
	 *  <p>
	 * 
	 * Doc metodo ereditato:<p>
	 * {@inheritDoc}
	 
	 * @param c
	 * @param carta
	 * @return
	 */
	@Override
	public int soddisfatto(CampoGioco c, Carta carta) {
		
		int conta1 = ReqFiguraSingola.getContatoreFigura(figura1, c);
		int conta2 = ReqFiguraSingola.getContatoreFigura(figura2, c);
		
		//Trovo quante volte è stato soddisfatto il req per figura e restituisco il minore dei risultati
		
		conta1 = (int)conta1/numFigure1;
		conta2 = (int)conta2/numFigure2;
		
		return Math.min(conta1, conta2);
		
	}
	
	

}
