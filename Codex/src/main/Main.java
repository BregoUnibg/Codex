package main;

import carte.*;
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
		
		Carta mano [] = new Carta [95]; //vettore temp //1(sup sinistra) , 2(sup destra) , 3(inf sinistra) , 4 (inf destra)

		//40 CARTE RISORSA
		mano[0] = new C_risorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(false));
		mano[1] = new C_risorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(Figura.FUNGO), new Angolo(false),  new Angolo());
		mano[2] = new C_risorsa(Colore.ROSSO, new Angolo(), new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(Figura.FUNGO));
		mano[3] = new C_risorsa(Colore.ROSSO, new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(), new Angolo(Figura.FUNGO));
		mano[4] = new C_risorsa(Colore.ROSSO, new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(Figura.FOGLIA), new Angolo(Figura.FUNGO));
		mano[5] = new C_risorsa(Colore.ROSSO, new Angolo(Figura.CIOTOLA), new Angolo(Figura.FUNGO), new Angolo(false), new Angolo(Figura.LUPO));	
		mano[6] = new C_risorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(Figura.FARFALLA), new Angolo(Figura.PERGAMENA), new Angolo());
		mano[7] = new C_risorsa(Colore.ROSSO, 1, new Angolo(), new Angolo(Figura.FUNGO), new Angolo(), new Angolo(false));
		mano[8] = new C_risorsa(Colore.ROSSO, 1, new Angolo(Figura.FUNGO), new Angolo(false), new Angolo(), new Angolo());
		mano[9] = new C_risorsa(Colore.ROSSO, 1, new Angolo(false), new Angolo(), new Angolo(Figura.FUNGO), new Angolo());		

		mano[10] = new C_risorsa(Colore.VERDE, new Angolo(Figura.FOGLIA), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(false));
		mano[11] = new C_risorsa(Colore.VERDE, new Angolo(Figura.FOGLIA), new Angolo(Figura.FOGLIA), new Angolo(false), new Angolo());
		mano[12] = new C_risorsa(Colore.VERDE, new Angolo(), new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(Figura.FOGLIA));
		mano[13] = new C_risorsa(Colore.VERDE, new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(), new Angolo(Figura.FOGLIA));
		mano[14] = new C_risorsa(Colore.VERDE, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.PIUMA), new Angolo(Figura.FOGLIA));
		mano[15] = new C_risorsa(Colore.VERDE, new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(false), new Angolo(Figura.CIOTOLA));
		mano[16] = new C_risorsa(Colore.VERDE, new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO));
		mano[17] = new C_risorsa(Colore.VERDE, 1, new Angolo(), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(false));
		mano[18] = new C_risorsa(Colore.VERDE, 1, new Angolo(), new Angolo(), new Angolo(false), new Angolo(Figura.FOGLIA));
		mano[19] = new C_risorsa(Colore.VERDE, 1, new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(), new Angolo());	

		mano[20] = new C_risorsa(Colore.BLU, new Angolo(Figura.LUPO), new Angolo(Figura.LUPO), new Angolo(), new Angolo(false));
		mano[21] = new C_risorsa(Colore.BLU, new Angolo(false), new Angolo(), new Angolo(Figura.LUPO), new Angolo(Figura.LUPO));
		mano[22] = new C_risorsa(Colore.BLU, new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.LUPO), new Angolo());
		mano[23] = new C_risorsa(Colore.BLU, new Angolo(), new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.LUPO));
		mano[24] = new C_risorsa(Colore.BLU, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.CIOTOLA), new Angolo(Figura.LUPO));
		mano[25] = new C_risorsa(Colore.BLU, new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.PERGAMENA));
		mano[26] = new C_risorsa(Colore.BLU, new Angolo(Figura.PIUMA), new Angolo(false), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO));
		mano[27] = new C_risorsa(Colore.BLU, 1, new Angolo(false), new Angolo(), new Angolo(Figura.LUPO), new Angolo());
		mano[28] = new C_risorsa(Colore.BLU, 1, new Angolo(), new Angolo(false), new Angolo(), new Angolo(Figura.LUPO));
		mano[29] = new C_risorsa(Colore.BLU, 1, new Angolo(), new Angolo(Figura.LUPO), new Angolo(), new Angolo(false));	

		mano[30] = new C_risorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo(false));
		mano[31] = new C_risorsa(Colore.VIOLA, new Angolo(false), new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(Figura.FARFALLA));
		mano[32] = new C_risorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo());
		mano[33] = new C_risorsa(Colore.VIOLA, new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FARFALLA));
		mano[34] = new C_risorsa(Colore.VIOLA, new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(Figura.LUPO), new Angolo(Figura.FARFALLA));
		mano[35] = new C_risorsa(Colore.VIOLA, new Angolo(Figura.PERGAMENA), new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FUNGO));
		mano[36] = new C_risorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(Figura.FOGLIA), new Angolo(Figura.CIOTOLA), new Angolo(false));
		mano[37] = new C_risorsa(Colore.VIOLA, 1, new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(), new Angolo());
		mano[38] = new C_risorsa(Colore.VIOLA, 1, new Angolo(), new Angolo(), new Angolo(false), new Angolo(Figura.FARFALLA));
		mano[39] = new C_risorsa(Colore.VIOLA, 1, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo());	


		//40 CARTE ORO
		mano[40] = new C_oro(Colore.ROSSO, null, null, null, null);
		mano[41] = new C_oro(Colore.ROSSO, null, null, null, null);
		mano[42] = new C_oro(Colore.ROSSO, null, null, null, null);
		mano[43] = new C_oro(Colore.ROSSO, null, null, null, null);
		mano[44] = new C_oro(Colore.ROSSO, null, null, null, null);
		mano[45] = new C_oro(Colore.ROSSO, null, null, null, null);
		mano[46] = new C_oro(Colore.ROSSO, null, null, null, null);
		mano[47] = new C_oro(Colore.ROSSO, null, null, null, null);
		mano[48] = new C_oro(Colore.ROSSO, null, null, null, null);
		mano[49] = new C_oro(Colore.ROSSO, null, null, null, null);		

		mano[50] = new C_oro(Colore.VERDE, null, null, null, null);
		mano[51] = new C_oro(Colore.VERDE, null, null, null, null);
		mano[52] = new C_oro(Colore.VERDE, null, null, null, null);
		mano[53] = new C_oro(Colore.VERDE, null, null, null, null);
		mano[54] = new C_oro(Colore.VERDE, null, null, null, null);
		mano[55] = new C_oro(Colore.VERDE, null, null, null, null);
		mano[56] = new C_oro(Colore.VERDE, null, null, null, null);
		mano[57] = new C_oro(Colore.VERDE, null, null, null, null);
		mano[58] = new C_oro(Colore.VERDE, null, null, null, null);
		mano[59] = new C_oro(Colore.VERDE, null, null, null, null);	

		mano[60] = new C_oro(Colore.BLU, null, null, null, null);
		mano[61] = new C_oro(Colore.BLU, null, null, null, null);
		mano[62] = new C_oro(Colore.BLU, null, null, null, null);
		mano[63] = new C_oro(Colore.BLU, null, null, null, null);
		mano[64] = new C_oro(Colore.BLU, null, null, null, null);
		mano[65] = new C_oro(Colore.BLU, null, null, null, null);
		mano[66] = new C_oro(Colore.BLU, null, null, null, null);
		mano[67] = new C_oro(Colore.BLU, null, null, null, null);
		mano[68] = new C_oro(Colore.BLU, null, null, null, null);
		mano[69] = new C_oro(Colore.BLU, null, null, null, null);	

		mano[70] = new C_oro(Colore.VIOLA, null, null, null, null);
		mano[71] = new C_oro(Colore.VIOLA, null, null, null, null);
		mano[72] = new C_oro(Colore.VIOLA, null, null, null, null);
		mano[73] = new C_oro(Colore.VIOLA, null, null, null, null);
		mano[74] = new C_oro(Colore.VIOLA, null, null, null, null);
		mano[75] = new C_oro(Colore.VIOLA, null, null, null, null);
		mano[76] = new C_oro(Colore.VIOLA, null, null, null, null);
		mano[77] = new C_oro(Colore.VIOLA, null, null, null, null);
		mano[78] = new C_oro(Colore.VIOLA, null, null, null, null);
		mano[79] = new C_oro(Colore.VIOLA, null, null, null, null);	

		//Nella numerazione delle carte prima delle obiettivo ci sono quelle iniziali 
		
		//16 CARTE OBIETTIVO 
		mano[80] = new C_obiettivo(Colore.GRIGIO, 2, null);
		mano[81] = new C_obiettivo(Colore.GRIGIO, 2, null);
		mano[82] = new C_obiettivo(Colore.GRIGIO, 2, null);
		mano[83] = new C_obiettivo(Colore.GRIGIO, 2, null);
		mano[84] = new C_obiettivo(Colore.GRIGIO, 3, null);
		mano[85] = new C_obiettivo(Colore.GRIGIO, 3, null);
		mano[86] = new C_obiettivo(Colore.GRIGIO, 3, null);
		mano[87] = new C_obiettivo(Colore.GRIGIO, 3, null);
		mano[88] = new C_obiettivo(Colore.GRIGIO, 2, null);
		mano[89] = new C_obiettivo(Colore.GRIGIO, 2, null);
		mano[90] = new C_obiettivo(Colore.GRIGIO, 2, null);
		mano[91] = new C_obiettivo(Colore.GRIGIO, 2, null);
		mano[92] = new C_obiettivo(Colore.GRIGIO, 3, null);
		mano[93] = new C_obiettivo(Colore.GRIGIO, 2, null);
		mano[94] = new C_obiettivo(Colore.GRIGIO, 2, null);
		mano[95] = new C_obiettivo(Colore.GRIGIO, 2, null);
		
		System.out.println(mano[0].getId());
		System.out.println(mano[1].getId());
		

	}

}
