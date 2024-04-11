package carte;

public class Requisito {
	
	public boolean soddisfatto() {
		return false;
	} //se il requisito è soddisfatto restituisce true
	
	//Non può essere astratto perchè uso la superclasse generalizzata per istanziare a nome delle sotoclassi.
	
	//Da quel che mi icordo posso creare un oggetto a nome di una superclasse nel quale mettere oggetti delle 
	//sotoclassi che estendono appunto la superclasse
	
	//questa classe estenderà delle sottoclassi con requisiti in particolare, quindi con un metodo
	//personalizzato, in questo modo risco a istanziare comunqe delle carte con delle classe std.
	
}
