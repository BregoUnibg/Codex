package main;

import carte.*;
import requisiti.*;
import requisiti.Requisito;
import campo.*;

public class Main {
	public static void main(String args[]) {
		
		
		Gioco gioco = new Gioco();
		
		gioco.gioca();
		
		
		
		
		
		
		
		/*
		 * 
		 * LA CREAZIONE DELLE CARTE NON DOVRA' ESSERE NEL MAIN, PER ORA E' STATA PASSATA ALLA CLASSE CentroCampo
		 * 
		Carta carte [] = new Carta [102]; //vettore temp //1(sup sinistra) , 2(sup destra) , 3(inf sinistra) , 4 (inf destra)
		
		//40 CARTE RISORSA 
		carte[0] = new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(false));
		carte[1] = new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(Figura.FUNGO), new Angolo(false),  new Angolo());
		carte[2] = new CartaRisorsa(Colore.ROSSO, new Angolo(), new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(Figura.FUNGO));
		carte[3] = new CartaRisorsa(Colore.ROSSO, new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(), new Angolo(Figura.FUNGO));
		carte[4] = new CartaRisorsa(Colore.ROSSO, new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(Figura.FOGLIA), new Angolo(Figura.FUNGO));
		carte[5] = new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.CIOTOLA), new Angolo(Figura.FUNGO), new Angolo(false), new Angolo(Figura.LUPO));	
		carte[6] = new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(Figura.FARFALLA), new Angolo(Figura.PERGAMENA), new Angolo());
		carte[7] = new CartaRisorsa(Colore.ROSSO, 1, new Angolo(), new Angolo(Figura.FUNGO), new Angolo(), new Angolo(false));
		carte[8] = new CartaRisorsa(Colore.ROSSO, 1, new Angolo(Figura.FUNGO), new Angolo(false), new Angolo(), new Angolo());
		carte[9] = new CartaRisorsa(Colore.ROSSO, 1, new Angolo(false), new Angolo(), new Angolo(Figura.FUNGO), new Angolo());		

		carte[10] = new CartaRisorsa(Colore.VERDE, new Angolo(Figura.FOGLIA), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(false));
		carte[11] = new CartaRisorsa(Colore.VERDE, new Angolo(Figura.FOGLIA), new Angolo(Figura.FOGLIA), new Angolo(false), new Angolo());
		carte[12] = new CartaRisorsa(Colore.VERDE, new Angolo(), new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(Figura.FOGLIA));
		carte[13] = new CartaRisorsa(Colore.VERDE, new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(), new Angolo(Figura.FOGLIA));
		carte[14] = new CartaRisorsa(Colore.VERDE, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.PIUMA), new Angolo(Figura.FOGLIA));
		carte[15] = new CartaRisorsa(Colore.VERDE, new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(false), new Angolo(Figura.CIOTOLA));
		carte[16] = new CartaRisorsa(Colore.VERDE, new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO));
		carte[17] = new CartaRisorsa(Colore.VERDE, 1, new Angolo(), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(false));
		carte[18] = new CartaRisorsa(Colore.VERDE, 1, new Angolo(), new Angolo(), new Angolo(false), new Angolo(Figura.FOGLIA));
		carte[19] = new CartaRisorsa(Colore.VERDE, 1, new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(), new Angolo());	

		carte[20] = new CartaRisorsa(Colore.BLU, new Angolo(Figura.LUPO), new Angolo(Figura.LUPO), new Angolo(), new Angolo(false));
		carte[21] = new CartaRisorsa(Colore.BLU, new Angolo(false), new Angolo(), new Angolo(Figura.LUPO), new Angolo(Figura.LUPO));
		carte[22] = new CartaRisorsa(Colore.BLU, new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.LUPO), new Angolo());
		carte[23] = new CartaRisorsa(Colore.BLU, new Angolo(), new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.LUPO));
		carte[24] = new CartaRisorsa(Colore.BLU, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.CIOTOLA), new Angolo(Figura.LUPO));
		carte[25] = new CartaRisorsa(Colore.BLU, new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.PERGAMENA));
		carte[26] = new CartaRisorsa(Colore.BLU, new Angolo(Figura.PIUMA), new Angolo(false), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO));
		carte[27] = new CartaRisorsa(Colore.BLU, 1, new Angolo(false), new Angolo(), new Angolo(Figura.LUPO), new Angolo());
		carte[28] = new CartaRisorsa(Colore.BLU, 1, new Angolo(), new Angolo(false), new Angolo(), new Angolo(Figura.LUPO));
		carte[29] = new CartaRisorsa(Colore.BLU, 1, new Angolo(), new Angolo(Figura.LUPO), new Angolo(), new Angolo(false));	

		carte[30] = new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo(false));
		carte[31] = new CartaRisorsa(Colore.VIOLA, new Angolo(false), new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(Figura.FARFALLA));
		carte[32] = new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo());
		carte[33] = new CartaRisorsa(Colore.VIOLA, new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FARFALLA));
		carte[34] = new CartaRisorsa(Colore.VIOLA, new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(Figura.LUPO), new Angolo(Figura.FARFALLA));
		carte[35] = new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.PERGAMENA), new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FUNGO));
		carte[36] = new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(Figura.FOGLIA), new Angolo(Figura.CIOTOLA), new Angolo(false));
		carte[37] = new CartaRisorsa(Colore.VIOLA, 1, new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(), new Angolo());
		carte[38] = new CartaRisorsa(Colore.VIOLA, 1, new Angolo(), new Angolo(), new Angolo(false), new Angolo(Figura.FARFALLA));
		carte[39] = new CartaRisorsa(Colore.VIOLA, 1, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo());	


		//40 CARTE ORO
		carte[40] = new CartaOro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.LUPO,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.PIUMA));
		carte[41] = new CartaOro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.FOGLIA,1), new Angolo(), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo());
		carte[42] = new CartaOro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.FARFALLA,1), new Angolo(Figura.PERGAMENA), new Angolo(), new Angolo(), new Angolo(false));
		carte[43] = new CartaOro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.LUPO,1), new Angolo(), new Angolo(), new Angolo(false), new Angolo());
		carte[44] = new CartaOro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.FOGLIA,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false));
		carte[45] = new CartaOro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.FARFALLA,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo());
		carte[46] = new CartaOro(Colore.ROSSO, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo(false));
		carte[47] = new CartaOro(Colore.ROSSO, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(Figura.PIUMA), new Angolo(), new Angolo(false), new Angolo(false));
		carte[48] = new CartaOro(Colore.ROSSO, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo());
		carte[49] = new CartaOro(Colore.ROSSO, new ReqFiguraSingola(Figura.FUNGO,5), new Angolo(), new Angolo(false), new Angolo(), new Angolo(false));		

		carte[50] = new CartaOro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.FARFALLA,1), new Angolo(Figura.PIUMA), new Angolo(), new Angolo(), new Angolo(false));
		carte[51] = new CartaOro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.FUNGO,1), new Angolo(), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo());
		carte[52] = new CartaOro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.LUPO,1), new Angolo(), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo());
		carte[53] = new CartaOro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.FARFALLA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo());
		carte[54] = new CartaOro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.LUPO,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false));
		carte[55] = new CartaOro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo());
		carte[56] = new CartaOro(Colore.VERDE, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(false));
		carte[57] = new CartaOro(Colore.VERDE, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(Figura.PERGAMENA), new Angolo(), new Angolo(false), new Angolo(false));
		carte[58] = new CartaOro(Colore.VERDE, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo());
		carte[59] = new CartaOro(Colore.VERDE, new ReqFiguraSingola(Figura.FOGLIA,5), new Angolo(), new Angolo(), new Angolo(false), new Angolo(false));	

		carte[60] = new CartaOro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FARFALLA,1), new Angolo(Figura.CIOTOLA), new Angolo(), new Angolo(), new Angolo(false));
		carte[61] = new CartaOro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FOGLIA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.PERGAMENA));
		carte[62] = new CartaOro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo());
		carte[63] = new CartaOro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FARFALLA,1), new Angolo(), new Angolo(), new Angolo(false), new Angolo());
		carte[64] = new CartaOro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo());
		carte[65] = new CartaOro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FOGLIA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo());
		carte[66] = new CartaOro(Colore.BLU, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo(false));
		carte[67] = new CartaOro(Colore.BLU, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(false));
		carte[68] = new CartaOro(Colore.BLU, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(false), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA));
		carte[69] = new CartaOro(Colore.BLU, new ReqFiguraSingola(Figura.LUPO,5), new Angolo(false), new Angolo(), new Angolo(false), new Angolo());

		carte[70] = new CartaOro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.FOGLIA,1), new Angolo(), new Angolo(Figura.PIUMA), new Angolo(false), new Angolo());
		carte[71] = new CartaOro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.LUPO,1), new Angolo(), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo());
		carte[72] = new CartaOro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.FUNGO,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.CIOTOLA));
		carte[73] = new CartaOro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.LUPO,1), new Angolo(), new Angolo(), new Angolo(false), new Angolo());
		carte[74] = new CartaOro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.FOGLIA,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false));
		carte[75] = new CartaOro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo());
		carte[76] = new CartaOro(Colore.VIOLA, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(), new Angolo(false));
		carte[77] = new CartaOro(Colore.VIOLA, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(false));
		carte[78] = new CartaOro(Colore.VIOLA, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(false), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo());
		carte[79] = new CartaOro(Colore.VIOLA, new ReqFiguraSingola(Figura.FARFALLA,5), new Angolo(), new Angolo(), new Angolo(false), new Angolo(false));

		//6 CARTE INIZIALI 
		carte[80] = new CartaIniziale(Figura.FARFALLA, null, null, new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO));
		carte[81] = new CartaIniziale(Figura.FUNGO, null, null, new Angolo(Figura.LUPO), new Angolo(), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO), new Angolo(Figura.FARFALLA));
		carte[82] = new CartaIniziale(Figura.FOGLIA, Figura.FUNGO, null, new Angolo(), new Angolo(), new Angolo(), new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA));
		carte[83] = new CartaIniziale(Figura.LUPO, Figura.FARFALLA, null, new Angolo(), new Angolo(), new Angolo(), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO));
		carte[84] = new CartaIniziale(Figura.LUPO, Figura.FARFALLA, Figura.FOGLIA, new Angolo(), new Angolo(), new Angolo(false), new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO));
		carte[85] = new CartaIniziale(Figura.FOGLIA, Figura.LUPO, Figura.FUNGO, new Angolo(), new Angolo(), new Angolo(false), new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(Figura.LUPO), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA));
		
		//16 CARTE OBIETTIVO 
		carte[86] = new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.ROSSO, 3));
		carte[87] = new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.VERDE, 3));
		carte[88] = new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.BLU, 3));
		carte[89] = new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.VIOLA, 3));
		carte[90] = new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.ROSSO, 2, Colore.VERDE, 1));
		carte[91] = new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.VERDE, 2, Colore.VIOLA, 1));
		carte[92] = new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.ROSSO, 1, Colore.BLU, 2));
		carte[93] = new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.BLU, 1, Colore.VIOLA, 2));
		carte[94] = new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FUNGO,3));
		carte[95] = new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FOGLIA,3));
		carte[96] = new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.LUPO,3));
		carte[97] = new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FARFALLA,3));
		carte[98] = new CartaObiettivo(Colore.GRIGIO, 3, new ReqFiguraTripla(Figura.CIOTOLA,1, Figura.PERGAMENA,1, Figura.PIUMA,1));
		carte[99] = new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.PERGAMENA,2));
		carte[100] = new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.CIOTOLA,2));
		carte[101] = new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.PIUMA,2));
		
		*/

	}

}
