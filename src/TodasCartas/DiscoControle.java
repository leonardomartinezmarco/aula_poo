package TodasCartas;

import JogoControle.Tipo;

public abstract class DiscoControle extends TodasCartas {
	public DiscoControle(String nome, int vida, int ataque, int defesa, Tipo tipo) {
		super(nome, vida, ataque, defesa, tipo);
	}
}
