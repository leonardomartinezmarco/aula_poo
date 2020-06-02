package JogoControle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import TodasCartas.TodasCartas;
import TodosEfeitos.EfeitosGame;

public class PackCartas {
	Players player;
	List<EfeitosGame> efeitosAtaque;
	List<EfeitosGame> efeitosDefesa;
	List<EfeitosGame> efeitosMoedas;
	List<TodasCartas> efeitosCartas;
	int quantidadeCartas;
	int quantidadeEfeitos;
	
	Random rand = new Random();

	Scanner input = new Scanner(System.in);

	private List<TodasCartas> Hack = new ArrayList<TodasCartas>();
	private List<EfeitosGame> EscolherEfeitos = new ArrayList<EfeitosGame>();
	
	public PackCartas(Players player, List<EfeitosGame> efeitosAtaque, List<EfeitosGame> efeitosDefesa, List<EfeitosGame> efeitosMoedas, List<TodasCartas> efeitosCartas, int quantidadeCartas, int quantidadeEfeitos) {
		this.player	= player;
		this.efeitosAtaque = efeitosAtaque;
		this.efeitosDefesa = efeitosDefesa;
		this.efeitosMoedas = efeitosMoedas;
		this.efeitosCartas = efeitosCartas;
		this.quantidadeCartas = quantidadeCartas;
		this.quantidadeEfeitos = quantidadeEfeitos;
		this.iniciarHack();
	}
	
	public List<TodasCartas> retornarHack() {
		return this.Hack;
	}
	
	public Players retornarPlayer() {
		return this.player;
	}
	
	private void iniciarHack() {
		this.sorteioCartas();
		this.sorteioEfeitos();
		System.out.println( "\n" + this.player.retornarNome() +  ", escolha uma das cartas abaixo para equipa-la");
		
		int CartaEscolhida = 0;
		int CartaEfeito = 0;
		int indiceCarta = 0;
			
		while (this.EscolherEfeitos.size() > 0) {
			System.out.println("Digite o numero da carta...");
			
			indiceCarta = 0;
				for(TodasCartas carta: this.Hack) {
					System.out.println( "\nCarta " + indiceCarta + " : " + carta.retornarNome() );
					System.out.println( carta.retornarDesc() );
					carta.verEfeitos();
					indiceCarta++;
				}	
			CartaEscolhida = this.input.nextInt();
			
			if (CartaEscolhida > this.Hack.size()-1 || CartaEscolhida < 0) {
				System.out.println("\nOpcao incorreta! Digite o numero da carta corretamente.\n");
			} else {
				System.out.println("Carta escolhida: " + this.Hack.get(CartaEscolhida).retornarNome());
				System.out.println(this.Hack.get(CartaEscolhida).retornarDesc() + "\n");	
				System.out.println("digite o numero do efeito para escolhe-lo:");
				System.out.println("Obs: Os numeros dos efeitos mudam conforme forem escolhidos!\n");
				
				indiceCarta = 0;
					for(EfeitosGame efeito: this.EscolherEfeitos) {
						System.out.println( "Efeito " + indiceCarta + " : " + efeito.retornarNome() );
						indiceCarta++;
				}	
				CartaEfeito = this.input.nextInt();
				
				if (CartaEfeito > this.EscolherEfeitos.size()-1 || CartaEscolhida < 0) {
					System.out.println("\nOpcao incorreta! Digite o numero da carta corretamente.\n");
				} else {
					this.Hack.get(CartaEscolhida).guardarEfeito( this.EscolherEfeitos.get(CartaEscolhida));
					this.EscolherEfeitos.remove(CartaEscolhida);
				}
			}			
		}	
	}
	
	private void sorteioCartas() {
		int sorteioCartas = 0;
		int i = 0;
		
		for (i = 0; i < this.quantidadeCartas; i ++) {
			sorteioCartas = rand.nextInt( this.efeitosCartas.size());
			this.Hack.add( this.efeitosCartas.get(sorteioCartas));
			this.efeitosCartas.remove(sorteioCartas);
		}		
	}
	
	private void sorteioEfeitos() {
		int sorteioEfeitos = 0;
		int i = 0;
		
		for (i = 0; i < this.quantidadeEfeitos; i ++) {
			sorteioEfeitos = rand.nextInt( this.efeitosAtaque.size());
			this.EscolherEfeitos.add( this.efeitosAtaque.get(sorteioEfeitos));
			this.efeitosAtaque.remove(sorteioEfeitos);
		}	
		sorteioEfeitos = 0;
		i = 0;
		
		for (i = 0; i < this.quantidadeEfeitos; i ++) {
			sorteioEfeitos = rand.nextInt( this.efeitosDefesa.size());
			this.EscolherEfeitos.add( this.efeitosDefesa.get(sorteioEfeitos));
			this.efeitosDefesa.remove(sorteioEfeitos);
		}		
		sorteioEfeitos = 0;
		i = 0;
		
		for (i = 0; i < this.quantidadeEfeitos; i ++) {
			sorteioEfeitos = rand.nextInt( this.efeitosMoedas.size());
			this.EscolherEfeitos.add( this.efeitosMoedas.get(sorteioEfeitos));
			this.efeitosMoedas.remove(sorteioEfeitos);
		}
	}	
}
