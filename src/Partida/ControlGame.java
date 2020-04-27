package Partida;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import TodasCartas.Carta_Arqueiro;
import TodasCartas.Carta_Bruxa;
import TodasCartas.Carta;
import TodasCartas.Carta_Capiroto;
import TodasCartas.Carta_Dinossauro;
import TodasCartas.Carta_Dragão;
import TodasCartas.Carta_Elfo;
import TodasCartas.Carta_Esqueleto;
import TodasCartas.Carta_Fantasma;
import TodasCartas.Carta_Fera;
import TodasCartas.Carta_Herpia;
import TodasCartas.Carta_Mago;
import TodasCartas.Carta_Monstro;

public class ControlGame {
	private List<Carta> Pack1 = new ArrayList<Carta>();
	private List<Carta> Pack2 = new ArrayList<Carta>();
	private Map<Integer, Carta> Cartas = new HashMap<Integer, Carta>();	
	private boolean jogoAuto = false;
	private String quemBatalhou;
	private String vencedor;
	private String desviou;
	private boolean JogoON;
	private int ataque;
	
	Random rand = new Random(); 	
	
	Scanner input = new Scanner(System.in);	
	
	public void batalhar (Carta carta1, Carta carta2, Player jogador1, Player jogador2) {
		this.desviou = "";
	
		sortearAtaque();
		
		int ataque = iniciativa();
		
		if (ataque == 1) {
			carta2.receberDano(ataque);
			this.vencedor = carta1.retornarNome() + "(" + jogador1.retornarNome() + ")";
			desviou(carta2,jogador2);
		} else {
			carta1.receberDano(ataque);
			this.vencedor = jogador1.retornarNome() + "(" + jogador2.retornarNome() + ")";
			desviou(carta1,jogador1);
		}
	}
	
	private void criacaoCartas() {
		int order = 0;
		
		this.Cartas.put(order++, new Carta_Arqueiro	  ("Arco", 10));
		this.Cartas.put(order++, new Carta_Bruxa	  ("Floresta Negra I", 15));
		this.Cartas.put(order++, new Carta_Capiroto	  ("Rei Vermelho",	28));
		this.Cartas.put(order++, new Carta_Dinossauro ("Rex do Mar", 60));
		this.Cartas.put(order++, new Carta_Dragão	  ("Voa-Voa", 30));
		this.Cartas.put(order++, new Carta_Elfo		  ("Elfa Místico I", 5));
		this.Cartas.put(order++, new Carta_Esqueleto  ("Rei das Caveiras", 75));
		this.Cartas.put(order++, new Carta_Fantasma	  ("Fantasma da Corte", 36));
		this.Cartas.put(order++, new Carta_Fera		  ("Alada Fera",	200));
		this.Cartas.put(order++, new Carta_Herpia	  ("Espalhador de Vozes", 20));
		this.Cartas.put(order++, new Carta_Mago		  ("Mago I", 25));
		this.Cartas.put(order++, new Carta_Monstro	  ("Monstro Afro", 48));
	}
	
	public ControlGame() {
		this.vencedor = "";
		this.desviou = "";
		this.JogoON = true;
		this.quemBatalhou = "";
	
		criacaoCartas();
		jogoAuto();
	}

	public String exibirAtaque() {
		return "Valor do Ataque feito: " + this.ataque;
	}	
	
	private void jogoAuto() {
		boolean resp = false;
		String modo = "";
	
		while (!resp){
			System.out.println("\n*Atenção: Você Deseja ativar o modo automático de execução das partidas do jogo?");
			System.out.println("\nDigite 's' para Sim ou 'n' para Não...");
			modo = this.input.nextLine();
			
			if (modo.toUpperCase().contentEquals("S")) {
				this.jogoAuto = true;
				resp = true;
			} else if (modo.toUpperCase().contentEquals("N")) {
				resp = true;
			} else {
				System.out.println("\nOpção incorreta! Digite 's' ou 'n'.");
			}
		}		
	}
		
	private int iniciativa() {
		return rand.nextInt(2) + 1;	
	}	
	
	private void sortearAtaque() {
		this.ataque = rand.nextInt(10);		
	}
	
	public void controlBatalha(Player player1, Player player2) {
		boolean batalha = false;
		for(Carta carta1: this.Pack1) {
			if( carta1.retornarVida() > 0) {
				for(Carta carta2: this.Pack2) {
					if( carta2.retornarVida() > 0) {
						batalhar(carta1, carta2, player1, player2);
						batalha = true;
						this.quemBatalhou = carta1.retornarNome() + "(" + player1.retornarNome() + ")" +  " VS " + carta2.retornarNome() + "(" + player2.retornarNome() + ")"; 
						break;
					}
			    }break;
			}
	    }
		this.JogoON = batalha;
	}
	
	public String exibirVencedor() {
		return "Vencedor da partida é: " + this.vencedor;
	}
	
	public String vencedor(Player jogador1, Player jogador2) {
		int vida1 = 0;
		int vida2 = 0;
		
		for(Carta carta1: this.Pack1) {
			vida1 = vida1 + carta1.retornarVida();
	    }	
	
		for(Carta carta2: this.Pack2) {
			vida2 = vida2 + carta2.retornarVida();
	    }			
		
		String vencedor = "";
		
		if (vida1 <= 0) {
			vencedor = "Vencedor Jogador 2: " + jogador2.retornarNome();
		}
		
		if (vida2 <= 0) {
			vencedor = "Vencedor Jogador 1: " + jogador1.retornarNome();
		}		
		return vencedor;
	}
	
	private void desviou(Carta carta1, Player playerl) {
	
		if (carta1.verDesviou()) {
			this.desviou = carta1.retornarNome() + "(" + playerl.retornarNome() + ")" +  " desviou do Ataque! ";
		} else {
			this.desviou = "";
		}	
		carta1.setarDesvio(false);
	}
	
	public String exibirDesvio() {
		return this.desviou;
	}
		
	private void packAdicionar(List<Carta> pack, int cartaNumero) {
		pack.add( this.Cartas.get(cartaNumero));		
	}
	
	public void iniciarPack(Player player, int jogadorNumero) {
		int deck_qtd = 3;
		
		boolean resposta = false;
		boolean randDeck= false;
		String modo = "";
	
		while (!resposta) {
			System.out.println("\n" + player.retornarNome() + " Você deseja utilizar cartas aleatórias?");
			System.out.println("Digite 's' para Sim ou 'n' para Não");
			modo = this.input.nextLine();
			
			if (modo.toUpperCase().contentEquals("S")){
				randDeck = true;
				resposta = true;
			} else if (modo.toUpperCase().contentEquals("N")) {
				resposta = true;
			}
			else {
				System.out.println("\nOpção incorreta! Digite 's' ou 'n'.");
			}
		}
			
		if (randDeck) {
			packRandom(packJogador(jogadorNumero));
			packLista(packJogador(jogadorNumero));				
		} else {
			int opcaoCarta = 0;
			int count = 1;
			
			System.out.println("\n" + player.retornarNome() + " escolha " + deck_qtd + " cartas:");
		 
			for(int indice: this.Cartas.keySet()) {
		      System.out.println( "Carta " + indice + " : " + this.Cartas.get(indice).retornarNome() );
		    }
			
			System.out.println("");
			
			String deckResp = "";
			
			while(count < deck_qtd +1) {				
				System.out.println("Carta " + count + ":");
				System.out.println("Digite o número da carta para escolher:");
				opcaoCarta = this.input.nextInt();
				
				if (opcaoCarta > this.Cartas.size()-1 || opcaoCarta < 0) {
					System.out.println("\nOpção inválida! Digite um número de uma carta conforme a lista.\n");
				} else {
					packAdicionar( packJogador(jogadorNumero), opcaoCarta);
					count++;
				}
					packLista( packJogador(jogadorNumero));					
			}			
		}
	}

	private void packRandom( List<Carta> pack) {
		int carta_sorteada = 0;
		int quantidade = 1;
		
		for (quantidade = 1; quantidade < 4; quantidade ++) {
			carta_sorteada = rand.nextInt(12);
			
			pack.add( this.Cartas.get(carta_sorteada));
		}		
	}
	
	private void packLista(List<Carta> pack) {
		if (pack.size() > 0) {
			System.out.println("\nCartas no Deck:");
			
			int cartaQuantidade = 1;
			
			for(Carta carta: pack) {
				System.out.println(cartaQuantidade++ + " - " + carta.retornarNome() );
		    }
		}
	}
		
	private List<Carta> packJogador(int jogadorNumero) {
		if (jogadorNumero == 1) {
			return this.Pack1;
		} else {
			return this.Pack2;
		}
	}
		
	public boolean jogoContinua() {
		return this.JogoON;
	}
	
	public void quemBatalhou() {
		System.out.println( this.quemBatalhou );
	}
		
	public void continueGame() {
		if ( !this.jogoAuto ) {
			System.out.println("\nAperte qualquer tecla para continar...");
			String partida = this.input.nextLine();				
		}
	}	
}
