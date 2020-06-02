package TodasCartas;

import java.util.ArrayList;
import java.util.List;
import JogoControle.Tipo;
import TodosEfeitos.EfeitosGame;

public abstract class TodasCartas {
	private String nomeCarta;
	private int vidaCarta;
	private int ataqueCarta;
	private int defesaCarta;
	private Tipo tipo;
	private List<EfeitosGame> efeitosList = new ArrayList<EfeitosGame>();
	
	public TodasCartas (String nome, int vida, int ataque ,int defesa, Tipo tipo) {
		this.nomeCarta = nome;
		this.vidaCarta = vida;
		this.ataqueCarta = ataque;
		this.defesaCarta = defesa;
		this.tipo = tipo;
	}
	
	public String retornarNome() {
		return this.nomeCarta;
	}

	public int retornarVida() {
		return this.vidaCarta;
	}
	
	public int retornarAtaque() {
		return this.ataqueCarta;
	}
	
	public int retornarDefesa() {
		return this.defesaCarta;
	}
	
	public Tipo retornarTipo() {
		return this.tipo;
	}
	
	public List<EfeitosGame> retornarListaEfeitos() {
		return this.efeitosList;
	}	
	
	public String retornarStatusCarta() {
		return "Status: \nNome: " + this.nomeCarta + ", Vida: " + this.vidaCarta + ", Ataque: " + this.ataqueCarta + ", Defesa: " + this.defesaCarta + ", Tipo: " + this.tipo + ", Fraqueza: " + this.tipo.fraqueza;
	}
	
	public String retornarDesc() {
		return "Status: \nNome: " + this.nomeCarta + ", Vida: " + this.vidaCarta + ", Ataque: " + this.ataqueCarta + ", Defesa: " + this.defesaCarta + ", Tipo: " + this.tipo + ", Fraqueza: " + this.tipo.fraqueza;
	} 
	
	public void verEfeitos() {
		List<EfeitosGame> efeitos = this.retornarListaEfeitos();
		
		for(EfeitosGame Efeito: efeitos) {
			Efeito.verEfeito();
		}		
	}	
	
	public void receberDano(int dano) {
		this.vidaCarta = this.vidaCarta - dano;
	}
	
	public void guardarEfeito(EfeitosGame efeitoNovo) {
		this.efeitosList.add( efeitoNovo );
	}
}
