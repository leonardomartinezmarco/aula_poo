package TodosEfeitos;

import java.util.Random;

import JogoControle.Tipo;

public abstract class EfeitosGame {
	private String nomeEfeito;
	private int valorEfeito;
	private TipoEfeito tipoEfeito;
	private Tipo tipo;
	
	public EfeitosGame (String nome, int valor , Tipo tipo, TipoEfeito tipoEfeito) {
		this.nomeEfeito = nome;
		this.valorEfeito = valor;
		this.tipo = tipo;
		this.tipoEfeito = tipoEfeito;
	}
	
	public void verEfeito() {
		String efeito = "";
		
		// Aumentar ataque
		if (this.tipoEfeito ==  TipoEfeito.ATAQUE) {
			efeito = " - Aumentar ataque em " + this.valorEfeito + "\nSendo uma arma do tipo: " + this.tipo;
		}
		
		// Aumentar defesa
		if ( this.tipoEfeito ==  TipoEfeito.DEFESA){
			efeito = " - Aumentar defesa em " + this.valorEfeito + "\nSendo uma arma do tipo: " + this.tipo;
		}		
		
		// Número randomico de um dos 2 ataque e defesa
		if ( this.tipoEfeito ==  TipoEfeito.RANDOM){
			efeito = " - Aumentar ataque ou defesa em " + this.valorEfeito + "\nSendo uma arma do tipo: " + this.tipo;
		}			
		
		System.out.println("Efeito: " + nomeEfeito + efeito);
	}

	
	public TipoEfeito retornarTipoEfeito() {
		TipoEfeito TipoEfeitoRetorno = this.tipoEfeito; 
		
		// Número randomico de um dos 2 ataque e defesa
		if (this.tipoEfeito == TipoEfeito.RANDOM) {
			Random rand = new Random(); 
			
			if ((rand.nextInt(2) + 1) == 1) {
				TipoEfeitoRetorno = TipoEfeito.ATAQUE;
			} else {
				TipoEfeitoRetorno = TipoEfeito.DEFESA; 
			}
		}			
		return TipoEfeitoRetorno;
	}

	public Tipo retornarTipo() {
		return this.tipo;
	}	
	
	public String retornarNome(){
		return this.nomeEfeito;
	}
	
	public int retornarValor() {
		return this.valorEfeito;
	}
}
