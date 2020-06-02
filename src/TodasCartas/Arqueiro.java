package TodasCartas;

import JogoControle.Tipo;

public class Arqueiro extends Juncao implements Desvio {
	public Arqueiro (String nome, int vida, int ataque, int defesa, Tipo tipo) {
		super(nome ,vida, ataque, defesa, tipo);
	}
	
	@Override
	public void receberDano(int dano) {
		if (!desviar()) {
			super.receberDano(dano);
			System.out.println(this.retornarNome() + " Falhou em desviar!");
		} else {
			System.out.println(this.retornarNome() + " Desviou do ataque! nao recebeu o dano");
		}
	}	

	public boolean desviar() {
		int chance = rand.nextInt(3) + 1;
		return chance == 2;
	}
}