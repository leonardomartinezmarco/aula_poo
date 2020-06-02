package TodasCartas;

import JogoControle.Tipo;

public abstract class Juncao extends TodasCartas {
	public Juncao(String nome, int vida, int ataque, int defesa, Tipo tipo) {
		super(nome, vida, ataque, defesa, tipo);
	}
}
