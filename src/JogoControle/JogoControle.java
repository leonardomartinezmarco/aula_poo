package JogoControle;

import java.util.Random;
import java.util.Scanner;
import TodasCartas.TodasCartas;
import TodosEfeitos.EfeitosGame;
import TodosEfeitos.TipoEfeito;

public class JogoControle {
	Random rand = new Random();

	Scanner input = new Scanner(System.in);	
	
	PackCartas pack1;
	PackCartas pack2;
	
	public JogoControle (PackCartas pack1, PackCartas pack2) {
		this.pack1 = pack1;
		this.pack2 = pack2;
		jogoExecucao();
	}
	
	private void jogoExecucao() {
		int selecaoCarta1 = 0;
		int selecaoCarta2 = 0;
		int batalhaResultado = 0;
		int i = 0;
		TodasCartas carta1;
		TodasCartas carta2;
		
		while(this.pack1.retornarHack().size() > 0 && this.pack2.retornarHack().size() > 0) {
			System.out.println(this.pack1.player.retornarNome() +  ", escolha uma carta para batalhar:");
			System.out.println("digite o numero da carta para escolhe-la.");
			
			i = 0;
				for(TodasCartas carta: this.pack1.retornarHack()) {
					System.out.println( "\nCarta " + i + " : " + carta.retornarNome());
					System.out.println( carta.retornarDesc() );
					carta.verEfeitos();
					i++;
			}	
			selecaoCarta1 = this.input.nextInt();
			
			if (selecaoCarta1 > this.pack1.retornarHack().size()-1 || selecaoCarta1 < 0) {
				System.out.println("\nOpcao incorreta! Digite o numero da carta corretamente.\n");
			} else {
				carta1 = this.pack1.retornarHack().get(selecaoCarta1);
				System.out.println("Carta escolhida: " + carta1.retornarNome() + "\n");	
				System.out.println(this.pack2.player.retornarNome() +  ", escolha uma carta para batalha:");
				System.out.println("Digite o numero da carta para escolhe-la.");
				
			i = 0;
				for(TodasCartas carta: this.pack2.retornarHack()) {
					System.out.println( "\nCarta " + i + " : " + carta.retornarNome() );
					System.out.println( carta.retornarDesc() );
					carta.verEfeitos();
					i++;
			}	
				
				selecaoCarta2 = this.input.nextInt();
				
				if (selecaoCarta2 > this.pack2.retornarHack().size()-1 || selecaoCarta2 < 0) {
					System.out.println("\nOpcao incorreta! Digite o numero da carta corretamente.\n");
				} else {
					carta2 = this.pack2.retornarHack().get(selecaoCarta2);
					System.out.println("Carta escolhida: " + carta2.retornarNome() + "\n" );	
					batalhaResultado = this.batalhar( carta1, carta2 );
					
					if (batalhaResultado == 1) {
						this.pack2.retornarHack().remove(selecaoCarta2);
					}
					
					if (batalhaResultado == 2) {
						this.pack1.retornarHack().remove(selecaoCarta1);
					}
				}
			}
		}
		
		System.out.println("Fim de Jogo!! \n" );
		
		// Se vencedor foi jogador do deck 1
		if ( this.pack1.retornarHack().size() > 0 )
		{
			System.out.println("Vencedor do jogo: " + this.pack1.retornarPlayer().retornarNome() );
		}
		
		// Se vencedor foi jogador do deck 2
		if ( this.pack2.retornarHack().size() > 0 )
		{
			System.out.println("Vencedor do jogo: " + this.pack2.retornarPlayer().retornarNome() );
		}		
		
	}
	
	private int batalhar(TodasCartas carta1, TodasCartas carta2)
	{
		int vezBatalha = rand.nextInt( 2 ) + 1;		
		int ataqueJogador = 0;
		int defesaJogador = 0;
		int danoJogador = 0;
		int retorno = 0;
		
		System.out.println( "\nIniciando batalha entre: \n" + carta1.retornarNome() + " X " + carta2.retornarNome() + "\n" );
		
		while (carta1.retornarVida() > 0 && carta2.retornarVida() > 0) {
			System.out.println(carta1.retornarStatusCarta() + "\n");
			System.out.println(carta2.retornarStatusCarta() + "\n");
			
			if (vezBatalha == 1) {
				vezBatalha = 2;
				ataqueJogador = this.calcularAtaque(carta1, carta2);
				defesaJogador = this.calcularDefesa(carta1, carta2);
				danoJogador = ataqueJogador - defesaJogador;

				if (danoJogador < 0) {
					danoJogador = 1;
				}
				carta2.receberDano(danoJogador);
				System.out.println(carta2.retornarNome() + " recebeu " + danoJogador + " de dano!");
				
			} else {
				vezBatalha = 1;
				ataqueJogador = this.calcularAtaque(carta2, carta1);
				ataqueJogador = this.calcularDefesa(carta2, carta1);	
				carta1.receberDano(danoJogador);
				System.out.println(carta1.retornarNome() + " recebeu " + danoJogador + " de dano!" );				
			}	
			System.out.println("\nAperte qualquer tecla para continar a batalha...\n");
			String partida = this.input.nextLine();
		}
		
		if (carta1.retornarVida() > 0) {
			retorno = 1;
			System.out.println(carta1.retornarNome() + " Venceu a batalha\n");
		}
		
		if (carta2.retornarVida() > 0) {
			retorno = 2;
			System.out.println(carta2.retornarNome() + " Você foi o vencedor!!!");
		}
		System.out.println("Final da batalha:\n");
		System.out.println(carta1.retornarStatusCarta() + "\n");
		System.out.println(carta2.retornarStatusCarta() + "\n");				
		return retorno;
	}
	
	private int calcularAtaque(TodasCartas carta1, TodasCartas carta2) {
		int sorteadoAtaque = 0;
		int cartaAtaque = 0;
		int efeitoAtaque = 0;
		int totalAtaque = 0;
		
		sorteadoAtaque = rand.nextInt(21);		

		System.out.println(carta1.retornarNome() + " Ataca!" );
		System.out.println(carta1.retornarDesc() + "\n" );
		System.out.println("Ataque:" );
		System.out.println("Sorteado na vez de ataque: " + sorteadoAtaque);
		totalAtaque = totalAtaque + sorteadoAtaque;

		cartaAtaque = carta1.retornarAtaque();
		
		if (carta1.retornarTipo() == carta2.retornarTipo()) {
			cartaAtaque--;
			System.out.println("\nTipos das cartas sao iguais,\n então foi diminuido por 1" );
		}
		
		if (carta1.retornarTipo().name() == carta2.retornarTipo().fraqueza.name()) {
			cartaAtaque++;
			System.out.println("\nCarta de ataque tem vantagem de tipo, \npor isso o ataque da carta \n foi aumentado por 1!" );
		}
		
		for(EfeitosGame efeito: carta2.retornarListaEfeitos()) {
			if (efeito.retornarTipoEfeito() == TipoEfeito.DEFESA && carta1.retornarTipo() == efeito.retornarTipo()) {
				cartaAtaque--;
				System.out.println("\nTipo da carta atacante � igual ao efeito de defesa: \n" + efeito.retornarNome()  + ", por isso o ataque da carta \n foi diminuido por 1!" );
			}
		}				
		System.out.println("+ Ataque da carta: " + cartaAtaque);
		totalAtaque = totalAtaque + cartaAtaque;

		for(EfeitosGame efeito: carta1.retornarListaEfeitos()) {
			if (efeito.retornarTipoEfeito() == TipoEfeito.ATAQUE) {
				efeitoAtaque = efeito.retornarValor();

				if (efeito.retornarTipo() == carta2.retornarTipo()) {
					efeitoAtaque--;
					System.out.println("\nTipo do efeito " + efeito.retornarNome() + "\n � do mesmo tipo da carta que se defende! \nPor isso o ataque do efeito \n foi diminuido por 1!" );
				}

				if (efeito.retornarTipo().name() == carta2.retornarTipo().fraqueza.name()) {
					efeitoAtaque++;
					System.out.println("\nTipo do efeito " + efeito.retornarNome() + "\n tem vantagem sobre a carta que se defende \nPor isso o ataque do efeito \n foi aumentado por 1!" );
				}							

				for( EfeitosGame efeitoCard2: carta2.retornarListaEfeitos()) {
					if (efeitoCard2.retornarTipoEfeito() == TipoEfeito.DEFESA && efeito.retornarTipo() == efeitoCard2.retornarTipo()) {
						efeitoAtaque--;
						System.out.println("\nTipo do efeito " + efeito.retornarNome() + "\n � do mesmo tipo do efeito de defesa: " + efeitoCard2.retornarNome() +   " da carta que se defende \nPor isso o ataque do efeito \n foi diminuido por 1!" );
				}						
			}	
				
			System.out.println("+ Efeito " + efeito.retornarNome() + ": " + efeitoAtaque);
			totalAtaque = totalAtaque + efeitoAtaque;
			}
		}
		
		if(totalAtaque < 0) {
			totalAtaque = 1;
		}
		System.out.println("\nValor total do ataque: " + totalAtaque + "\n");
		return totalAtaque;
	}
	
	private int calcularDefesa(TodasCartas card1, TodasCartas card2) {
		int defesaSorteada = 0;
		int defesaCarta = 0;
		int defesaEfeito = 0;
		int defesaTotal = 0;

		defesaSorteada = rand.nextInt(11);		
		System.out.println(card2.retornarNome() + " Defende!" );
		System.out.println(card2.retornarDesc() + "\n" );
		
		System.out.println("Composi��o da defesa:" );
		System.out.println("Sorteado na vez de defender: " + defesaSorteada );
		defesaTotal = defesaTotal + defesaSorteada;
		defesaCarta = card2.retornarDefesa();	
		System.out.println("	+ Defesa da carta: " + defesaCarta );
		defesaTotal = defesaTotal + defesaCarta;
		
		for(EfeitosGame efeito: card2.retornarListaEfeitos()) {
			if (efeito.retornarTipoEfeito() == TipoEfeito.DEFESA) {
				defesaEfeito = efeito.retornarValor();
				System.out.println("	+ Efeito " + efeito.retornarNome() + ": " + defesaEfeito );
				defesaTotal = defesaTotal + defesaEfeito;
			}
		}	
		
		if(defesaTotal < 0) {
			defesaTotal = 1;
		}				
		System.out.println("\nValor total da Defesa: " + defesaTotal + "\n" );	
		return defesaTotal;
	}
}
