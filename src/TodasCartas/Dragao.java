package TodasCartas;

import JogoControle.Tipo;

public class Dragao extends Juncao implements DefesaExtra {
	private int defesa = 10;

	public Dragao (String nome, int vida, int ataque, int defesa, Tipo tipo) {
		super(nome ,vida*2, ataque, defesa, tipo);
	}
	
	@Override
	public int retornarDefesa() {
		System.out.println(this.retornarNome() + " Tem " + this.defesa + " de defesa adicionais por ser Dragao!");
		return super.retornarDefesa() + aumentarDefesa() ;
	}
	
	public int aumentarDefesa() {
		return this.defesa;
	}
}
