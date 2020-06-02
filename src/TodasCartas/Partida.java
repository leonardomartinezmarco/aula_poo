package TodasCartas;

import JogoControle.Tipo;

public abstract class Partida extends TodasCartas implements AplicarPartida {
	private int valor;
	
	public Partida(String nome, int vida, int ataque, int defesa, Tipo tipo, int valor) {
		super(nome, vida, ataque, defesa, tipo);
		this.valor = valor;
	}
	
	@Override
	public int retornarAtaque() {
		if (!aplicarCurse()) {
			System.out.println(this.retornarNome() + " Nao foi afetado pelo ritual!");
			return super.retornarAtaque();	
		} else {
			System.out.println(this.retornarNome() + ", seu ataque foi afetado pelo ritual!");
			int novoAtaque = super.retornarAtaque();
			
			if ((novoAtaque - this.valor) < 0) {
				novoAtaque = 0;
			} else {
				novoAtaque = novoAtaque - this.valor;
			}
			return novoAtaque;
		}
	}		
	
	public boolean aplicarCurse() {
		int chance = rand.nextInt(5) + 1;
		return chance == 2;
	}
	
	@Override
	public String retornarStatusCarta() {
		return super.retornarStatusCarta() + "\nValor do ritual que pode afetar o seu ataque: " + this.valor;
	}		
}
