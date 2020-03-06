import java.util.Scanner;
import java.util.Random;

public class Partida {

       static int AtaqueUsuario() {
            Scanner leitor = new Scanner(System.in);
            System.out.println("Digite o seu nick de usuário: ");
            String nome = leitor.next();
            System.out.println("Tudo pronto " + nome + "? vai começar a partida...");
            System.out.println("Escolha seu ataque: ");
            System.out.println("(1) - Soco");
            System.out.println("(2) - Especial");
            leitor.nextInt();
    }

    static int AtaqueInimigo() {
        Random gerador = new Random();
        return gerador.nextInt(10)+1;
    }

    static int imprimirHP(int hpUsuario, int hpInimigo, int contagemEspecial) {
        System.out.println("____________________");
        System.out.println("HP Usuário: " + hpUsuario);
        System.out.println("HP Inimigo: " + hpInimigo);
        System.out.println("* Contagem Especiais: " + contagemEspecial);
        System.out.println("____________________");
    }

     static void Batalha() {
        int hpUsuario = 100;
        int hpInimigo = 100;
        int contagemEspecial = 5;
        int escolhaAtaque;

        while (hpUsuario > 0 && hpInimigo > 0) {
            imprimirHP(hpUsuario, hpInimigo, contagemEspecial);
            escolhaAtaque = AtaqueUsuario();
            switch (escolhaAtaque) {
                case 1:
                       System.out.println("Você deu um soco");
                        hpInimigo -= 10;
                    break;
                case 2:
                        System.out.println("Você aplicou um especial");
                        hpInimigo -= 25;
                        contagemEspecial --;
                    break;
                default:
                        System.out.println("Opção inválida");
                    break;
            }
            if (hpInimigo > 0 ) {
                escolhaAtaque = AtaqueInimigo();
                switch (escolhaAtaque){
                    case 1:
                        System.out.println("Inimigo te deu um soco");
                        hpUsuario -= 10;
                        break;
                    case 2:
                        System.out.println("Inimigo te deu um ataque especial");
                        hpUsuario -= 20;
                        break;
                    }
                 } else {
                    System.out.println("Inimigo derrotado!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int continua = 1;
        while (continua == 1) {
            Batalha();
            System.out.println("Fim de jogo. Deseja continuar? Sim (1) Não (2)");
            continua = leitor.nextInt();
        }
    }
}