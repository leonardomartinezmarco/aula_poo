package TodasCartas;
import Partida.Hack;

public class Carta_Arqueiro extends Carta implements Hack {
	
	public Carta_Arqueiro (String nome, int vida) {
		super(nome,vida);
	}
	
	@Override
	public void receberDano(int dano) {
		if (!desviarAtaque()) {
			super.receberDano(dano);
			super.setarDesvio(false);
		} else {
			super.setarDesvio(true);
		}
	}	
}