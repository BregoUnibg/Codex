package campo;

import carte.Angolo;
import carte.CartaIniziale;
import carte.CartaObiettivo;
import carte.CartaOro;
import carte.CartaRisorsa;
import carte.Colore;
import carte.Figura;
import requisiti.ReqCartaDoppia;
import requisiti.ReqCartaSingola;
import requisiti.ReqFiguraDoppia;
import requisiti.ReqFiguraSingola;
import requisiti.ReqFiguraTripla;

public class CentroCampo {

	private Mazzo mazzoCartaOro; 
	private Mazzo mazzoCartaRisorsa; 
	private Mazzo mazzoCartaObiettivo; 
	private Mazzo mazzoCartaIniziale; 
	
	public CentroCampo() {
		
		mazzoCartaOro = new Mazzo();
		mazzoCartaRisorsa = new Mazzo();
		mazzoCartaObiettivo = new Mazzo();
		mazzoCartaIniziale = new Mazzo();
		
	}

	public Mazzo getMazzoCartaOro() {
		return mazzoCartaOro;
	}

	public Mazzo getMazzoCartaRisorsa() {
		return mazzoCartaRisorsa;
	}

	public Mazzo getMazzoCartaObiettivo() {
		return mazzoCartaObiettivo;
	}

	public Mazzo getMazzoCartaIniziale() {
		return mazzoCartaIniziale;
	}
	
	public void preparaCentroCampo() {
		
		creaMazzoRisorsa();
		creaMazzoOro();
		creaMazzoObiettivo();
		creaMazzoIniziale();
		
	}
	
	public void creaMazzoRisorsa() {
		
		//40 CARTE RISORSA 
		
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(false)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(Figura.FUNGO), new Angolo(false),  new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(), new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(Figura.FUNGO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(), new Angolo(Figura.FUNGO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(Figura.FOGLIA), new Angolo(Figura.FUNGO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.CIOTOLA), new Angolo(Figura.FUNGO), new Angolo(false), new Angolo(Figura.LUPO)));	
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(Figura.FARFALLA), new Angolo(Figura.PERGAMENA), new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, 1, new Angolo(), new Angolo(Figura.FUNGO), new Angolo(), new Angolo(false)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, 1, new Angolo(Figura.FUNGO), new Angolo(false), new Angolo(), new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, 1, new Angolo(false), new Angolo(), new Angolo(Figura.FUNGO), new Angolo()));		

		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(Figura.FOGLIA), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(false)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(Figura.FOGLIA), new Angolo(Figura.FOGLIA), new Angolo(false), new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(), new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(Figura.FOGLIA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(), new Angolo(Figura.FOGLIA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.PIUMA), new Angolo(Figura.FOGLIA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(false), new Angolo(Figura.CIOTOLA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, 1, new Angolo(), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(false)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, 1, new Angolo(), new Angolo(), new Angolo(false), new Angolo(Figura.FOGLIA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, 1, new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(), new Angolo()));	

		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(Figura.LUPO), new Angolo(Figura.LUPO), new Angolo(), new Angolo(false)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(false), new Angolo(), new Angolo(Figura.LUPO), new Angolo(Figura.LUPO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.LUPO), new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(), new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.LUPO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.CIOTOLA), new Angolo(Figura.LUPO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.PERGAMENA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(Figura.PIUMA), new Angolo(false), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, 1, new Angolo(false), new Angolo(), new Angolo(Figura.LUPO), new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, 1, new Angolo(), new Angolo(false), new Angolo(), new Angolo(Figura.LUPO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, 1, new Angolo(), new Angolo(Figura.LUPO), new Angolo(), new Angolo(false)));	

		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo(false)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(false), new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(Figura.FARFALLA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FARFALLA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(Figura.LUPO), new Angolo(Figura.FARFALLA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.PERGAMENA), new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FUNGO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(Figura.FOGLIA), new Angolo(Figura.CIOTOLA), new Angolo(false)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, 1, new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(), new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, 1, new Angolo(), new Angolo(), new Angolo(false), new Angolo(Figura.FARFALLA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, 1, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo()));	
				 
		
	}
	
	public void creaMazzoOro() {
		
		//40 CARTE ORO
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.LUPO,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.PIUMA)));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.FOGLIA,1), new Angolo(), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.FARFALLA,1), new Angolo(Figura.PERGAMENA), new Angolo(), new Angolo(), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.LUPO,1), new Angolo(), new Angolo(), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.FOGLIA,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.FARFALLA,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(Figura.PIUMA), new Angolo(), new Angolo(false), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, new ReqFiguraSingola(Figura.FUNGO,5), new Angolo(), new Angolo(false), new Angolo(), new Angolo(false)));		

		mazzoCartaOro.add(new CartaOro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.FARFALLA,1), new Angolo(Figura.PIUMA), new Angolo(), new Angolo(), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.FUNGO,1), new Angolo(), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.LUPO,1), new Angolo(), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.FARFALLA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.LUPO,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(Figura.PERGAMENA), new Angolo(), new Angolo(false), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, new ReqFiguraSingola(Figura.FOGLIA,5), new Angolo(), new Angolo(), new Angolo(false), new Angolo(false)));	

		mazzoCartaOro.add(new CartaOro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FARFALLA,1), new Angolo(Figura.CIOTOLA), new Angolo(), new Angolo(), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FOGLIA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.PERGAMENA)));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FARFALLA,1), new Angolo(), new Angolo(), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FOGLIA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(false), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA)));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, new ReqFiguraSingola(Figura.LUPO,5), new Angolo(false), new Angolo(), new Angolo(false), new Angolo()));

		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.FOGLIA,1), new Angolo(), new Angolo(Figura.PIUMA), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.LUPO,1), new Angolo(), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.FUNGO,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.CIOTOLA)));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.LUPO,1), new Angolo(), new Angolo(), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.FOGLIA,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(false), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, new ReqFiguraSingola(Figura.FARFALLA,5), new Angolo(), new Angolo(), new Angolo(false), new Angolo(false)));
		
	}
	
	public void creaMazzoObiettivo() {
		
		//16 CARTE OBIETTIVO 
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.ROSSO, 3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.VERDE, 3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.BLU, 3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.VIOLA, 3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.ROSSO, 2, Colore.VERDE, 1)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.VERDE, 2, Colore.VIOLA, 1)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.ROSSO, 1, Colore.BLU, 2)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.BLU, 1, Colore.VIOLA, 2)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FUNGO,3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FOGLIA,3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.LUPO,3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FARFALLA,3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqFiguraTripla(Figura.CIOTOLA,1, Figura.PERGAMENA,1, Figura.PIUMA,1)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.PERGAMENA,2)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.CIOTOLA,2)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.PIUMA,2)));
		
	}
	
	public void creaMazzoIniziale() {
		
		mazzoCartaIniziale.add(new CartaIniziale(Figura.FARFALLA, null, null, new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO)));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.FUNGO, null, null, new Angolo(Figura.LUPO), new Angolo(), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO), new Angolo(Figura.FARFALLA)));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.FOGLIA, Figura.FUNGO, null, new Angolo(), new Angolo(), new Angolo(), new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA)));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.LUPO, Figura.FARFALLA, null, new Angolo(), new Angolo(), new Angolo(), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO)));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.LUPO, Figura.FARFALLA, Figura.FOGLIA, new Angolo(), new Angolo(), new Angolo(false), new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO)));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.FOGLIA, Figura.LUPO, Figura.FUNGO, new Angolo(), new Angolo(), new Angolo(false), new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(Figura.LUPO), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA)));
		
	}
	
}
