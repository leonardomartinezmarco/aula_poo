package Partida;
import java.util.Random; 

public interface Hack {
	
	Random rand = new Random(); 
	
	public static int aumentarVida() {
		
		int tentativa = rand.nextInt(3) + 1;
		int value = 0;
		
		if (tentativa == 2) {
			value = 5;
		}	
		return value;
	}
	
	default boolean desviarAtaque() {
		int tentativa = rand.nextInt(3) + 1;
		boolean esquivar = false;
		
		if (tentativa == 2) {
			esquivar = true;
		}	
		return esquivar;
	}
	
}