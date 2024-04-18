package main;

import carte.*;
import campo.*;

public class Main {
	public static void main(String args[]) {
		
		
		Carta ca= new C_risorsa(Colore.ROSSO);
		Carta cb= new C_risorsa(Colore.ROSSO);
		Carta cc= new C_oro(Colore.ROSSO);
		Carta cd= new C_oro(Colore.ROSSO);
		
		Carta mano [] = new Carta [2];
		
		mano[0] = new C_risorsa(Colore.BLU);
		mano[1] = cc;
		
		System.out.println(ca.getId());
		System.out.println(cb.getId());
		System.out.println(cd.getId());
		System.out.println(mano[0].getId());
		System.out.println(mano[1].getId());
		
		
		
		
	}

}
