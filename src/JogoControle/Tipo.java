package JogoControle;

import TodasCartas.Tipos;

public enum Tipo {
	TREVAS(Tipos.LUZ), LUZ(Tipos.DIVINO), TERRA(Tipos.VENTO), FOGO(Tipos.AGUA), AGUA(Tipos.GELO), VENTO(Tipos.TERRA), GELO(Tipos.FOGO), DIVINO(Tipos.TREVAS);
	
public Tipos fraqueza;
	Tipo(Tipos fraqueza) {
	    this.fraqueza = fraqueza;
	}		
}
