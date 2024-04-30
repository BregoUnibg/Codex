package requisiti;

import campo.Campo_gioco;
import carte.Figura;

public class ReqFiguraDoppia implements Requisito{


	private Figura figura1;
	private int numFigure1;
	private Figura figura2;
	private int numFigure2;
	
	ReqFiguraDoppia(Figura figura1, int numFigure1, Figura figura2, int numFigure2){
		
		this.figura1 = figura1;
		this.numFigure1 = numFigure1;
		this.figura2 = figura2;
		this.numFigure2 = numFigure2;
		
		
	}
	
	@Override
	public boolean soddisfatto(Campo_gioco c) {
		
		int conta1 = ReqFiguraSingola.getContatoreFigura(figura1, c);
		int conta2 = ReqFiguraSingola.getContatoreFigura(figura2, c);
		
		if((conta1>= numFigure1)&&(conta2>=numFigure2))
			return true;
		
		return false;
	}
	
	

}
