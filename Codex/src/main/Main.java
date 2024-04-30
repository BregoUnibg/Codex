package main;

import carte.*;
import requisiti.*;
import requisiti.Requisito;
import campo.*;

public class Main {
	public static void main(String args[]) {
		
		
		/*
		Carta ca= new C_risorsa(Colore.ROSSO, 2, null, null, null, null);
		Carta cb= new C_risorsa(Colore.ROSSO,2);
		Carta cc= new C_oro(Colore.ROSSO, null, null, null, null);
		Carta cd= new C_oro(Colore.ROSSO, null, null, null, null);
		
		Carta mano [] = new Carta [2];
		
		mano[0] = new C_risorsa(Colore.BLU, 2);
		mano[1] = cc;
		
		System.out.println(ca.getId());
		System.out.println(cb.getId());
		System.out.println(cd.getId());
		*/
		
		Carta carte [] = new Carta [102]; //vettore temp //1(sup sinistra) , 2(sup destra) , 3(inf sinistra) , 4 (inf destra)

		//40 CARTE RISORSA 
		carte[0] = new C_risorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(false));
		carte[1] = new C_risorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(Figura.FUNGO), new Angolo(false),  new Angolo());
		carte[2] = new C_risorsa(Colore.ROSSO, new Angolo(), new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(Figura.FUNGO));
		carte[3] = new C_risorsa(Colore.ROSSO, new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(), new Angolo(Figura.FUNGO));
		carte[4] = new C_risorsa(Colore.ROSSO, new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(Figura.FOGLIA), new Angolo(Figura.FUNGO));
		carte[5] = new C_risorsa(Colore.ROSSO, new Angolo(Figura.CIOTOLA), new Angolo(Figura.FUNGO), new Angolo(false), new Angolo(Figura.LUPO));	
		carte[6] = new C_risorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(Figura.FARFALLA), new Angolo(Figura.PERGAMENA), new Angolo());
		carte[7] = new C_risorsa(Colore.ROSSO, 1, new Angolo(), new Angolo(Figura.FUNGO), new Angolo(), new Angolo(false));
		carte[8] = new C_risorsa(Colore.ROSSO, 1, new Angolo(Figura.FUNGO), new Angolo(false), new Angolo(), new Angolo());
		carte[9] = new C_risorsa(Colore.ROSSO, 1, new Angolo(false), new Angolo(), new Angolo(Figura.FUNGO), new Angolo());		

		carte[10] = new C_risorsa(Colore.VERDE, new Angolo(Figura.FOGLIA), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(false));
		carte[11] = new C_risorsa(Colore.VERDE, new Angolo(Figura.FOGLIA), new Angolo(Figura.FOGLIA), new Angolo(false), new Angolo());
		carte[12] = new C_risorsa(Colore.VERDE, new Angolo(), new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(Figura.FOGLIA));
		carte[13] = new C_risorsa(Colore.VERDE, new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(), new Angolo(Figura.FOGLIA));
		carte[14] = new C_risorsa(Colore.VERDE, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.PIUMA), new Angolo(Figura.FOGLIA));
		carte[15] = new C_risorsa(Colore.VERDE, new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(false), new Angolo(Figura.CIOTOLA));
		carte[16] = new C_risorsa(Colore.VERDE, new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO));
		carte[17] = new C_risorsa(Colore.VERDE, 1, new Angolo(), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(false));
		carte[18] = new C_risorsa(Colore.VERDE, 1, new Angolo(), new Angolo(), new Angolo(false), new Angolo(Figura.FOGLIA));
		carte[19] = new C_risorsa(Colore.VERDE, 1, new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(), new Angolo());	

		carte[20] = new C_risorsa(Colore.BLU, new Angolo(Figura.LUPO), new Angolo(Figura.LUPO), new Angolo(), new Angolo(false));
		carte[21] = new C_risorsa(Colore.BLU, new Angolo(false), new Angolo(), new Angolo(Figura.LUPO), new Angolo(Figura.LUPO));
		carte[22] = new C_risorsa(Colore.BLU, new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.LUPO), new Angolo());
		carte[23] = new C_risorsa(Colore.BLU, new Angolo(), new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.LUPO));
		carte[24] = new C_risorsa(Colore.BLU, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.CIOTOLA), new Angolo(Figura.LUPO));
		carte[25] = new C_risorsa(Colore.BLU, new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.PERGAMENA));
		carte[26] = new C_risorsa(Colore.BLU, new Angolo(Figura.PIUMA), new Angolo(false), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO));
		carte[27] = new C_risorsa(Colore.BLU, 1, new Angolo(false), new Angolo(), new Angolo(Figura.LUPO), new Angolo());
		carte[28] = new C_risorsa(Colore.BLU, 1, new Angolo(), new Angolo(false), new Angolo(), new Angolo(Figura.LUPO));
		carte[29] = new C_risorsa(Colore.BLU, 1, new Angolo(), new Angolo(Figura.LUPO), new Angolo(), new Angolo(false));	

		carte[30] = new C_risorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo(false));
		carte[31] = new C_risorsa(Colore.VIOLA, new Angolo(false), new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(Figura.FARFALLA));
		carte[32] = new C_risorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo());
		carte[33] = new C_risorsa(Colore.VIOLA, new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FARFALLA));
		carte[34] = new C_risorsa(Colore.VIOLA, new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(Figura.LUPO), new Angolo(Figura.FARFALLA));
		carte[35] = new C_risorsa(Colore.VIOLA, new Angolo(Figura.PERGAMENA), new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FUNGO));
		carte[36] = new C_risorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(Figura.FOGLIA), new Angolo(Figura.CIOTOLA), new Angolo(false));
		carte[37] = new C_risorsa(Colore.VIOLA, 1, new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(), new Angolo());
		carte[38] = new C_risorsa(Colore.VIOLA, 1, new Angolo(), new Angolo(), new Angolo(false), new Angolo(Figura.FARFALLA));
		carte[39] = new C_risorsa(Colore.VIOLA, 1, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo());	


		//40 CARTE ORO
		carte[40] = new C_oro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.LUPO,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.PIUMA));
		carte[41] = new C_oro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.FOGLIA,1), new Angolo(), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo());
		carte[42] = new C_oro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.FARFALLA,1), new Angolo(Figura.PERGAMENA), new Angolo(), new Angolo(), new Angolo(false));
		carte[43] = new C_oro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.LUPO,1), new Angolo(), new Angolo(), new Angolo(false), new Angolo());
		carte[44] = new C_oro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.FOGLIA,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false));
		carte[45] = new C_oro(Colore.ROSSO, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.FARFALLA,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo());
		carte[46] = new C_oro(Colore.ROSSO, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo(false));
		carte[47] = new C_oro(Colore.ROSSO, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(Figura.PIUMA), new Angolo(), new Angolo(false), new Angolo(false));
		carte[48] = new C_oro(Colore.ROSSO, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo());
		carte[49] = new C_oro(Colore.ROSSO, new ReqFiguraSingola(Figura.FUNGO,5), new Angolo(), new Angolo(false), new Angolo(), new Angolo(false));		

		carte[50] = new C_oro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.FARFALLA,1), new Angolo(Figura.PIUMA), new Angolo(), new Angolo(), new Angolo(false));
		carte[51] = new C_oro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.FUNGO,1), new Angolo(), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo());
		carte[52] = new C_oro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.LUPO,1), new Angolo(), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo());
		carte[53] = new C_oro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.FARFALLA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo());
		carte[54] = new C_oro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.LUPO,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false));
		carte[55] = new C_oro(Colore.VERDE, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo());
		carte[56] = new C_oro(Colore.VERDE, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(false));
		carte[57] = new C_oro(Colore.VERDE, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(Figura.PERGAMENA), new Angolo(), new Angolo(false), new Angolo(false));
		carte[58] = new C_oro(Colore.VERDE, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo());
		carte[59] = new C_oro(Colore.VERDE, new ReqFiguraSingola(Figura.FOGLIA,5), new Angolo(), new Angolo(), new Angolo(false), new Angolo(false));	

		carte[60] = new C_oro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FARFALLA,1), new Angolo(Figura.CIOTOLA), new Angolo(), new Angolo(), new Angolo(false));
		carte[61] = new C_oro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FOGLIA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.PERGAMENA));
		carte[62] = new C_oro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo());
		carte[63] = new C_oro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FARFALLA,1), new Angolo(), new Angolo(), new Angolo(false), new Angolo());
		carte[64] = new C_oro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo());
		carte[65] = new C_oro(Colore.BLU, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FOGLIA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo());
		carte[66] = new C_oro(Colore.BLU, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo(false));
		carte[67] = new C_oro(Colore.BLU, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(false));
		carte[68] = new C_oro(Colore.BLU, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(false), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA));
		carte[69] = new C_oro(Colore.BLU, new ReqFiguraSingola(Figura.LUPO,5), new Angolo(false), new Angolo(), new Angolo(false), new Angolo());

		carte[70] = new C_oro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.FOGLIA,1), new Angolo(), new Angolo(Figura.PIUMA), new Angolo(false), new Angolo());
		carte[71] = new C_oro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.LUPO,1), new Angolo(), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo());
		carte[72] = new C_oro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.FUNGO,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.CIOTOLA));
		carte[73] = new C_oro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.LUPO,1), new Angolo(), new Angolo(), new Angolo(false), new Angolo());
		carte[74] = new C_oro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.FOGLIA,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false));
		carte[75] = new C_oro(Colore.VIOLA, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo());
		carte[76] = new C_oro(Colore.VIOLA, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(), new Angolo(false));
		carte[77] = new C_oro(Colore.VIOLA, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(false));
		carte[78] = new C_oro(Colore.VIOLA, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(false), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo());
		carte[79] = new C_oro(Colore.VIOLA, new ReqFiguraSingola(Figura.FARFALLA,5), new Angolo(), new Angolo(), new Angolo(false), new Angolo(false));

		//6 CARTE INIZIALI 
		carte[80] = new C_iniziale(Figura.FARFALLA, null, null, new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO));
		carte[81] = new C_iniziale(Figura.FUNGO, null, null, new Angolo(Figura.LUPO), new Angolo(), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO), new Angolo(Figura.FARFALLA));
		carte[82] = new C_iniziale(Figura.FOGLIA, Figura.FUNGO, null, new Angolo(), new Angolo(), new Angolo(), new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA));
		carte[83] = new C_iniziale(Figura.LUPO, Figura.FARFALLA, null, new Angolo(), new Angolo(), new Angolo(), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO));
		carte[84] = new C_iniziale(Figura.LUPO, Figura.FARFALLA, Figura.FOGLIA, new Angolo(), new Angolo(), new Angolo(false), new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO));
		carte[85] = new C_iniziale(Figura.FOGLIA, Figura.LUPO, Figura.FUNGO, new Angolo(), new Angolo(), new Angolo(false), new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(Figura.LUPO), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA));
		
		//16 CARTE OBIETTIVO 
		carte[86] = new C_obiettivo(Colore.GRIGIO, 2, new Requisito());
		carte[87] = new C_obiettivo(Colore.GRIGIO, 2, new Requisito());
		carte[88] = new C_obiettivo(Colore.GRIGIO, 2, new Requisito());
		carte[89] = new C_obiettivo(Colore.GRIGIO, 2, new Requisito());
		carte[90] = new C_obiettivo(Colore.GRIGIO, 3, new Requisito());
		carte[91] = new C_obiettivo(Colore.GRIGIO, 3, new Requisito());
		carte[92] = new C_obiettivo(Colore.GRIGIO, 3, new Requisito());
		carte[93] = new C_obiettivo(Colore.GRIGIO, 3, new Requisito());
		carte[94] = new C_obiettivo(Colore.GRIGIO, 2, new Requisito());
		carte[95] = new C_obiettivo(Colore.GRIGIO, 2, new Requisito());
		carte[96] = new C_obiettivo(Colore.GRIGIO, 2, new Requisito());
		carte[97] = new C_obiettivo(Colore.GRIGIO, 2, new Requisito());
		carte[98] = new C_obiettivo(Colore.GRIGIO, 3, new Requisito());
		carte[99] = new C_obiettivo(Colore.GRIGIO, 2, new Requisito());
		carte[100] = new C_obiettivo(Colore.GRIGIO, 2, new Requisito());
		carte[101] = new C_obiettivo(Colore.GRIGIO, 2, new Requisito());
		
		System.out.println(carte[0].getId());
		System.out.println(carte[1].getId());
		

	}

}
