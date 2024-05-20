package requisiti;

import campo.CampoGioco;
import carte.Carta;
import carte.Figura;

public class ReqFiguraDoppia implements Requisito{


	private Figura figura1;
	private int numFigure1;
	private Figura figura2;
	private int numFigure2;
	
	public ReqFiguraDoppia(Figura figura1, int numFigure1, Figura figura2, int numFigure2){
		
		this.figura1 = figura1;
		this.numFigure1 = numFigure1;
		this.figura2 = figura2;
		this.numFigure2 = numFigure2;
		
		
	}
	
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
