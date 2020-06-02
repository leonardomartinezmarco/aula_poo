package TodasCartas;
import Partida.Hack;

public class Carta_Dragao extends Carta implements Hack {
	private int defesa = 2;
	
	public Carta_Dragao (String nome, int vida) {
		super(nome,vida*2);
	}
		
	@Override
	public void receberDano(int dano) {
		if(dano > this.defesa) {
			dano = dano - this.defesa;
		}
		super.receberDano(dano);
	}
	
	@Override
	public boolean desviarAtaque() {
		return false;
	}	
	
	@Override
	public String retornarStatus() {
		return super.retornarStatus() + verDefesa();	
	}
		
	private String verDefesa() {
		return ", Defesa: " + this.defesa;
	}
	
}
