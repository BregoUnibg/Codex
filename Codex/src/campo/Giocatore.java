package campo;

public class Giocatore {
	
		//Attributi
		private String nome;
		int punti;				//da togliere

		//Costrutto
		public Giocatore(String nome) {
			this.nome=nome;
		}
		
		public String getNome() {
			return nome;
		}
	
		public String setNome() {
			return nome;
		}
		
		public int calolaPunti() {
			return punti;		//La scriveremeo in modo tale che li clacoli sul momento	
		}
}
