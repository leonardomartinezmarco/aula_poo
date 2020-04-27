package Partida;

public class Match {
	
	public static void main(String[] args) throws InterruptedException {
		Player jogador1 = new Player(1);
		System.out.println("");
		Player jogador2 = new Player(2);
		
		ControlGame game = new ControlGame();
		game.iniciarPack(jogador1, 1);
		game.iniciarPack(jogador2, 2);
		game.continueGame();
		
		int contador = 1;
		
		System.out.println("");
		System.out.println("Status Inicial:");
		Thread.sleep(1000);
		
		while (game.jogoContinua()) {			
			game.continueGame();
			game.controlBatalha(jogador1, jogador2);
			
			System.out.println("");
			System.out.println("________________________________________________");
			System.out.println("Partida " + contador++ + ":");
			System.out.println("");
			
			game.quemBatalhou();
			System.out.println(game.exibirVencedor());
			System.out.println(game.exibirAtaque());
			System.out.println(game.exibirDesvio());
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			Thread.sleep(1000);
		}
		
			System.out.println("________________________________________________");
			System.out.println("Status Final:");
			System.out.println("");
			Thread.sleep(1000);
		
			System.out.println(game.vencedor(jogador1, jogador2) + "!");
			System.out.println("________________________________________________");
	}
}
