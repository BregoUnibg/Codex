package requisiti;

import campo.CampoGioco;
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
	public boolean soddisfatto(CampoGioco c) {
		
		int conta = getContatoreFigura(figura, c);
				
		if(conta>=numFigure)
			return true;
		
		return false;
	}
	
	protected static int getContatoreFigura(Figura figura, CampoGioco c) {
		
		switch(figura){
		
		case FARFALLA:
			return c.getContaFarfalla();
			
		case FUNGO:
			return c.getContaFungo();
		
		case LUPO:
			return c.getContaLupo();
		
		case FOGLIA:
			return c.getContaFoglia();
			
		case PERGAMENA:
			return c.getContaPergamena();
		
		case PIUMA:
			return c.getContaPiuma();
			
		case CIOTOLA:
			return c.getContaCiotola();
		
		default:
			return 0;
		}
		
	}
	

}
