import java.util.Scanner;
import java.util.Random;

public class Partida {

    static Scanner scanf = new Scanner(System.in);
    static Random  rand  = new Random();

    static Personagem jogador = new Personagem();
    static Personagem inimigo = new Personagem();

    public static void main(String[] args) {
        Introducao();
        telaPersonagem();
        chamaTurno();
        jogadorTurno();
        cpuTurno();
        vitoria();
    }

    public static void Introducao (){
        System.out.println("SEJA BEM-VINDO A ARENA, GUERREIRO! DIGA-NOS SEU NOME: ");
    }

    public static void telaPersonagem(){
        System.out.println("NOME: " + jogador.getNome() + "					    NOME:" + inimigo.getNome());
        System.out.println("HP: " + jogador.getHealthPoints() + "				        HP: "  + inimigo.getHealthPoints());
    }

    public static void chamaTurno() {
        int jogadorAgi;
        int cpuAgi;

        do {
            jogadorAgi = rand.nextInt(1) + jogador.getAgilidade();
            cpuAgi = rand.nextInt(1) + inimigo.getAgilidade();

            if(jogadorAgi > cpuAgi){
                jogadorTurno();
            } else {
        }
    } while(jogadorAgi != cpuAgi);

}

    public static void jogadorTurno() {
        int acao;

        do {

            System.out.println("SEU TURNO");
            System.out.println("");
            System.out.println("Escolha uma acao");
            System.out.println("1 - Atacar");
            acao = scanf.nextInt();

            switch(acao) {
                case 1 :
                    jogador.Ataque(inimigo);
                    System.out.println("Ataque realizado com sucesso");
                    telaPersonagem();
                    chamaTurno();
                    break;

                default :
                    System.out.println("Digite um comando valido");
            }
        } while(jogador.healthPoints != 0 || jogador.healthPoints < 0);
    }

    public static void cpuTurno() {
        int acao;
        acao = rand.nextInt(1) + 3;
        System.out.println("TURNO INIMIGO");

        do {
            switch (acao) {
                case 1:
                    inimigo.Ataque(jogador);
                    System.out.println("Você e atacado com sucesso");
                    chamaTurno();
                    break;

                case 2:
                    inimigo.Ataque(jogador);
                    System.out.println("Você e atacado com sucesso");
                    chamaTurno();
                    break;

                case 3:
                    inimigo.Ataque(jogador);
                    System.out.println("Você e atacado com sucesso");
                    break;
            }
        } while(inimigo.healthPoints != 0 || inimigo.healthPoints <= 0);
    }

    public static void vitoria() {
        if(jogador.healthPoints == 0) {
            System.out.println("voce perdeu!");
        }

        if(inimigo.healthPoints == 0) {
            System.out.println("voce venceu!");
        }
    }
}