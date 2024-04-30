package requisiti;

import campo.Campo_gioco;
import carte.Figura;

//Requisito relativo al controllare che ci siano tot figure di un certo tipo visibili sul campo di gioco

public class ReqFiguraSingola implements Requisito{

	private Figura figura;
	private int numFigure;
	
	public ReqFiguraSingola(Figura figura, int numFigure) {
		
		this.figura = figura;
		this.numFigure = numFigure;	
		
	}
	@Override
	public boolean soddisfatto(Campo_gioco c) {
		
		int conta;
		
		switch(figura){
		
		case FARFALLA:
			conta = c.getContaFarfalla();
			break;
			
		case FUNGO:
			conta = c.getContaFungo();
			break;
		
		case LUPO:
			conta = c.getContaLupo();
			break;
		
		case FOGLIA:
			conta = c.getContaFoglia();
			break;
			
		case PERGAMENA:
			conta = c.getContaPergamena();
			break;
		
		case PIUMA:
			conta = c.getContaPiuma();
			break;
			
		case CIOTOLA:
			conta = c.getContaCiotola();
			break;
		
		default:
			return false;
		}
		
		if(conta>=numFigure)
			return true;
		
		return false;
	}
	
	

}
