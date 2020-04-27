package Partida;
import java.util.Scanner;

public class Player {
	private String nome;
	
	public Player (int numero_jogador) {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o nome do jogador " + numero_jogador + ":");
		
		String name_jogador = leitor.nextLine();
		this.nome = name_jogador;
	}	
	
	public String retornarNome() {
		return this.nome;
	}
}
