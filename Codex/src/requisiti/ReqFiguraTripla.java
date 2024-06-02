package requisiti;

import campo.CampoGioco;
import carte.Carta;
import carte.Figura;

/**
 * Contiene il requisito di un obiettivo in caso di figura tripla visibili sul campo di gioco (ad esempio: 1 ciotola, 1 pergamena, 1 piuma)
 * @author Gabriele Bregolin
 * @author Matteo Megna 
 */

public class ReqFiguraTripla implements Requisito{

	//Attributi
	private Figura figura1;
	private int numFigure1;
	private Figura figura2;
	private int numFigure2;
	private Figura figura3;
	private int numFigure3;
	
	//Costruttore
	
	/**
	 * Controlla se tot figure del tipo e quantità desiderate sono presenti sul campo per tre tipi
	 * di figure diverse con relative quantità
	 * @param figura1
	 * @param numFigure1 (qta relativa a figura1)
	 * @param figura2
	 * @param numFigure2 (qta relativa a figura2)
	 * @param figura3
	 * @param numFigure3 (qta relativa a figura3)
	 */
	
	public ReqFiguraTripla(Figura figura1, int numFigure1, Figura figura2, int numFigure2, Figura figura3, int numFigure3){
		
		this.figura1 = figura1;
		this.numFigure1 = numFigure1;
		this.figura2 = figura2;
		this.numFigure2 = numFigure2;
		this.figura3 = figura3;
		this.numFigure3 = numFigure3;
		
	}

	/**
	 * 
	 * Controlla se tot figure del tipo e quantità desiderate sono presenti sul campo per tre tipi
	 * di figure diverse con relative quantità
	 * 
	 * l'obiettivo è verificato per ogni minumo comune multiplo delle quantità 
	 * 
	 * <p>
	 * 
	 * Doc metodo ereditato:<p>
	 * {@inheritDoc}
	 * 
	 * @param c
	 * @param carta
	 * @return
	 */
	@Override
	public int soddisfatto(CampoGioco c, Carta carta) {
		
		int conta1 = ReqFiguraSingola.getContatoreFigura(figura1, c);
		int conta2 = ReqFiguraSingola.getContatoreFigura(figura2, c);
		int conta3 = ReqFiguraSingola.getContatoreFigura(figura3, c);
		
		conta1 = (int) conta1/numFigure1;
		conta2 = (int) conta2/numFigure2;
		conta3 = (int) conta3/numFigure3;
		
		return Math.min(Math.min(conta1, conta2), conta3);
	}
		
		
}
