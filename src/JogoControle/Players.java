package JogoControle;
import java.util.Scanner;

public class Players {
	
	private String nome;
	
	public Players (int numeroJogador){
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome do player " + numeroJogador + ":");
		String nomePlayer = input.nextLine();
		
		if (nomePlayer.isEmpty()) {
			nomePlayer = "Jogador " + numeroJogador;
		}
		this.nome = nomePlayer;
	}	
	
	public String retornarNome(){
		return this.nome;
	}
}
