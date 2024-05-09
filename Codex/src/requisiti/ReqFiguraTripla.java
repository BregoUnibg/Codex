package requisiti;

import campo.CampoGioco;
import carte.Carta;
import carte.Figura;

public class ReqFiguraTripla implements Requisito{

	private Figura figura1;
	private int numFigure1;
	private Figura figura2;
	private int numFigure2;
	private Figura figura3;
	private int numFigure3;
	
	public ReqFiguraTripla(Figura figura1, int numFigure1, Figura figura2, int numFigure2, Figura figura3, int numFigure3){
		
		this.figura1 = figura1;
		this.numFigure1 = numFigure1;
		this.figura2 = figura2;
		this.numFigure2 = numFigure2;
		this.figura3 = figura3;
		this.numFigure3 = numFigure3;
		
	}

	@Override
	public int soddisfatto(CampoGioco c, Carta carta) {
		
		int conta1 = ReqFiguraSingola.getContatoreFigura(figura1, c);
		int conta2 = ReqFiguraSingola.getContatoreFigura(figura2, c);
		int conta3 = ReqFiguraSingola.getContatoreFigura(figura3, c);
		
		conta1 = (int) conta1/numFigure1;
		conta2 = (int) conta2/numFigure1;
		conta3 = (int) conta3/numFigure1;
		
		return Math.min(Math.min(conta1, conta2), conta3);
	}
		
		
}
