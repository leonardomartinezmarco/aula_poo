package TodasCartas;

import JogoControle.Tipo;

public abstract class ViuvaControle extends TodasCartas {
	public ViuvaControle( String nome, int vida, int ataque, int defesa, Tipo tipo) {
		super(nome, vida, ataque, defesa, tipo);
	}
}
