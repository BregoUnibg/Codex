package campo;

import carte.CartaObiettivo;

/**
 * Rapprestna un giocatore
 * 
 * @author Gabriele Bregolin
 * @author Matteo Megna
 * @author Joao Pedro Moretti
 *
 */

public class Giocatore {
	
		//Attributi
		private String nome;
		private Mano mano;
		private CampoGioco campoGioco;
		private final Pedina pedina;
		private CartaObiettivo cartaObiettivoNascosta;
		private int punti;

		//Costrutto
		public Giocatore(String nome, Pedina pedina) {
			this.nome=nome;
			this.pedina = pedina;
			this.punti = 0;
			this.campoGioco = new CampoGioco();
			this.mano = new Mano();
		}
		
		//Getter
		public Mano getMano() {
			return mano;
		}
		
		public CampoGioco getCampoGioco() {
			return campoGioco;
		}
		
		public String getNome() {
			return nome;
		}
		
		/**
		 * Aggiunge tot punti alla conta dei punti relativa al giocatore 
		 * @param punti (punti appena ricevuti)
		 */
		
		public void addPunti(int punti) {
			this.punti += punti;
		}
		
		
		public int getPunti() {
			return punti;	
		}


		public CartaObiettivo getCartaObiettivoNascosta() {
			return cartaObiettivoNascosta;
		}

		/**
		 * Da al giocatore la sua carta obiettivo personale
		 * @param cartaObiettivoNascosta
		 */
		
		public void setCartaObiettivoNascosto(CartaObiettivo cartaObiettivoNascosta) {
			this.cartaObiettivoNascosta = cartaObiettivoNascosta;
		}

		public Pedina getPedina() {
			return pedina;
		}
		
		
		
		
}
