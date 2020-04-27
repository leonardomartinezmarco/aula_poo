package TodasCartas;

public abstract class Carta {
	private String nome;
	private int vida;
	private boolean desviou = false;
	
	public Carta (String nome, int vida) {
		this.nome = nome;
		this.vida = vida;
	}
	
	public String retornarNome() {
		return this.nome;
	}
	
	public int retornarVida() {
		return this.vida;
	}
	
	public void receberDano(int dano) {
		this.vida = this.vida - dano;
	}
	
	public String retornarStatus() {
		return "Nome: " + this.nome + ", Vida: " + this.vida;	
	}
	
	public boolean verDesviou() {
		return this.desviou;
	}		
	
	public void setarDesvio( boolean desviar) {
		this.desviou = desviar;
	}	
}
