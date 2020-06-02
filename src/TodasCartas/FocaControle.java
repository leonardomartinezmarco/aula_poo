package TodasCartas;

import JogoControle.Tipo;

public abstract class FocaControle extends TodasCartas {
	public FocaControle(String nome, int vida, int ataque, int defesa, Tipo tipo) {
		super(nome, vida, ataque, defesa, tipo);
	}
}
