package JogoControle;

import java.util.ArrayList;
import java.util.List;
import TodasCartas.VelhaBruxa;
import TodasCartas.PirataCarnivoro;
import TodasCartas.Soldado;
import TodasCartas.Arqueiro;
import TodasCartas.AbelhaRussa;
import TodasCartas.Aventureiro;
import TodasCartas.CacadorIndiano;
import TodasCartas.BruxaCaverna;
import TodasCartas.LeaoHimalaia;
import TodasCartas.TigreAsiatico;
import TodasCartas.DemonioTrevas;
import TodasCartas.Dinossauro;
import TodasCartas.Dragao;
import TodasCartas.ElfoDama;
import TodasCartas.BaleiaGigante;
import TodasCartas.EsqueletoGelo;
import TodasCartas.FadaCristalina;
import TodasCartas.Fantasma;
import TodasCartas.FenixLuz;
import TodasCartas.AveRoxa;
import TodasCartas.BuracoNegro;
import TodasCartas.InsetoLava;
import TodasCartas.MagoBarbudo;
import TodasCartas.Maquina;
import TodasCartas.MonstroLago;
import TodasCartas.PlantaCarnivora;
import TodasCartas.CobraAsiatica;
import TodasCartas.VelcroLudico;
import TodasCartas.ReptilSelvagem;
import TodasCartas.TodasCartas;
import TodasCartas.PlantaVenenosa;
import TodosEfeitos.PistolaSimples;
import TodosEfeitos.PistolaLonga;
import TodosEfeitos.ArcoSimples;
import TodosEfeitos.ArcoComprido;
import TodosEfeitos.ArcoGelo;
import TodosEfeitos.ArmaduraOuro;
import TodosEfeitos.ArmaduraDiamante;
import TodosEfeitos.ArmaduraRubi;
import TodosEfeitos.ArmaduraSimples;
import TodosEfeitos.ArmaduraBronze;
import TodosEfeitos.ArmaduraPrata;
import TodosEfeitos.RifleSimples;
import TodosEfeitos.RifleLongo;
import TodosEfeitos.EfeitosGame;
import TodosEfeitos.EscudoSimples;
import TodosEfeitos.EscudoAgua;
import TodosEfeitos.EscudoMortifero;
import TodosEfeitos.EscudoAguia;
import TodosEfeitos.EscudoFogo;
import TodosEfeitos.EscudoGelo;
import TodosEfeitos.EscudoBrilhante;
import TodosEfeitos.EscudoAco;
import TodosEfeitos.EscudoDiamante;
import TodosEfeitos.EscudoPedra;
import TodosEfeitos.EscudoOuro;
import TodosEfeitos.EscudoAlien;
import TodosEfeitos.EscudoDemoniaco;
import TodosEfeitos.EscudoGalatico;
import TodosEfeitos.EspadaSimples;
import TodosEfeitos.EspadaComprida;
import TodosEfeitos.EspadaGelo;
import TodosEfeitos.FacaSimples;
import TodosEfeitos.FacaComprida;
import TodosEfeitos.JoiaSimples;
import TodosEfeitos.LancaAgua;
import TodosEfeitos.LancaComprida;
import TodosEfeitos.LancaGelo;
import TodosEfeitos.RifleGelo;
import TodosEfeitos.Metralhadora;
import TodosEfeitos.MachadoSimples;
import TodosEfeitos.MachadoComprido;
import TodosEfeitos.MachadoGelo;
import TodosEfeitos.TipoEfeito;

public class IniciarGame {
	
	public static void main(String[] args) {

		// definição do nome do player			
		Players player1 = new Players(1);
		System.out.println("");
		Players player2 = new Players(2);
		
		// efeitos do game randomico
		List<EfeitosGame> efeitosArmas = new ArrayList<EfeitosGame>();
		List<EfeitosGame> efeitosArmaduras = new ArrayList<EfeitosGame>();
		List<EfeitosGame> efeitosJoias = new ArrayList<EfeitosGame>();

		// definição das cartas do game
		List<TodasCartas> Cartas = new ArrayList<TodasCartas>();
		
		// quantidade de cartas que cada jogador vai ter
		final int quantidadeCartas = 5;
		
		// quantidade de efeitos que cada tipo de efeito vai ter
		final int quantidadeEfeitos = 6;
		
		carregarTodosEfeitos(efeitosArmas, efeitosArmaduras, efeitosJoias);
		carregarCartas(Cartas);
		
		// chama os players, efeitos, cartas
		PackCartas pack1 = new PackCartas(player1, efeitosArmas, efeitosArmaduras, efeitosJoias, Cartas, quantidadeCartas, quantidadeEfeitos);
		carregarTodosEfeitos(efeitosArmas, efeitosArmaduras, efeitosJoias);
		carregarCartas(Cartas);
		PackCartas pack2 = new PackCartas(player2, efeitosArmas, efeitosArmaduras, efeitosJoias, Cartas, quantidadeCartas, quantidadeEfeitos);
		
		// executa jogo com packs dos jogadores
		JogoControle jogo = new JogoControle(pack1, pack2);	
	}
	
	public static void carregarTodosEfeitos(List<EfeitosGame> ArmasTodosEfeitos, List<EfeitosGame> ArmadurasTodosEfeitos, List<EfeitosGame> JoiasTodosEfeitos) {
		// todas as armas do game
		ArmasTodosEfeitos.add (new EspadaSimples("Espada Simples", 15, Tipo.GELO, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new EspadaComprida("Espada Longa", 8, Tipo.FOGO, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new EspadaGelo("Espada de Gelo", 8, Tipo.TERRA, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new LancaAgua("Lanca de Agua", 12, Tipo.AGUA, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new LancaComprida("Lanca Longo", 14, Tipo.TREVAS, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new LancaGelo("Lanca de Gelo", 16, Tipo.LUZ, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new ArcoSimples("Arco Simples", 5, Tipo.AGUA, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new ArcoComprido("Arco Longo", 4, Tipo.VENTO, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new ArcoGelo("Arco de Gelo", 13, Tipo.AGUA, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new MachadoSimples("Machado Simples", 16, Tipo.VENTO, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new MachadoComprido("Machado Longo", 17, Tipo.GELO, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new MachadoGelo("Machado de Gelo", 22, Tipo.DIVINO, TipoEfeito.ATAQUE));	
		ArmasTodosEfeitos.add (new FacaSimples("Faca Simples", 2, Tipo.LUZ, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new FacaComprida("Faca Longa", 4, Tipo.AGUA, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new PistolaSimples("Pistola Simples", 3, Tipo.TREVAS, TipoEfeito.ATAQUE));			
		ArmasTodosEfeitos.add (new PistolaLonga("Pistola Longa", 6, Tipo.AGUA, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new RifleSimples("Rifle Simples", 7, Tipo.TERRA, TipoEfeito.ATAQUE));			
		ArmasTodosEfeitos.add (new RifleLongo("Rifle Longo", 9, Tipo.AGUA, TipoEfeito.ATAQUE));
		ArmasTodosEfeitos.add (new RifleGelo("Rifle de Gelo", 14, Tipo.FOGO, TipoEfeito.ATAQUE));			
		ArmasTodosEfeitos.add (new Metralhadora("Metralhadora Simples", 18, Tipo.FOGO, TipoEfeito.ATAQUE));		
		
		// todas as armaduras do game 
		ArmadurasTodosEfeitos.add (new EscudoSimples("Escudo Simples", 10, Tipo.TERRA, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new EscudoBrilhante("Escudo Brilhante", 20, Tipo.LUZ, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new EscudoPedra("Escudo de Pedra", 25, Tipo.TREVAS, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new EscudoDiamante("Escudo de Diamante", 12, Tipo.FOGO, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new EscudoOuro("Escudo de Ouro", 14, Tipo.TERRA, TipoEfeito.DEFESA ) );
		ArmadurasTodosEfeitos.add (new EscudoFogo("Escudo de Fogo", 8, Tipo.AGUA, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new EscudoGelo("Escudo Gelo", 8, Tipo.VENTO, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new EscudoAlien("Escudo Alienigena", 7, Tipo.GELO, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new EscudoGalatico("Escudo da Glaxia", 7, Tipo.DIVINO, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new EscudoDemoniaco("Escudo das Trevas", 9, Tipo.TREVAS, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new EscudoAco("Escudo de Aco", 9, Tipo.LUZ, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new EscudoAgua("Escudo de Agua", 6, Tipo.TERRA, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new EscudoMortifero("Escudo da Morte", 25, Tipo.FOGO, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new EscudoAguia("Escudo de Aguia", 40, Tipo.AGUA, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new ArmaduraSimples("Armadura Simples", 4, Tipo.VENTO, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new ArmaduraBronze("Armadura de Bronze", 12, Tipo.GELO, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new ArmaduraPrata("Armadura de Prata", 16, Tipo.DIVINO, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new ArmaduraOuro("Armadura de Ouro", 10, Tipo.TREVAS, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new ArmaduraDiamante("Armadura de Diamante", 20, Tipo.LUZ, TipoEfeito.DEFESA));
		ArmadurasTodosEfeitos.add (new ArmaduraRubi("Armadura de Rubi", 30, Tipo.TERRA, TipoEfeito.DEFESA));
		
		// todas as moedas do game
		JoiasTodosEfeitos.add (new JoiaSimples("Joia Simples", 5, Tipo.FOGO, TipoEfeito.RANDOM));
		JoiasTodosEfeitos.add (new JoiaSimples("Joia Sagrada", 15, Tipo.LUZ, TipoEfeito.RANDOM));
		JoiasTodosEfeitos.add (new JoiaSimples("Pedra Talisma", 30, Tipo.TREVAS, TipoEfeito.RANDOM));
		JoiasTodosEfeitos.add (new JoiaSimples("Anel Diamante", 20, Tipo.VENTO, TipoEfeito.RANDOM));
		JoiasTodosEfeitos.add (new JoiaSimples("Diamante", 50, Tipo.AGUA, TipoEfeito.RANDOM));
		JoiasTodosEfeitos.add (new JoiaSimples("Esmeralda", 25, Tipo.DIVINO, TipoEfeito.RANDOM));
	}
	
	public static void carregarCartas(List<TodasCartas> Todascartas) {
		// todas as cartas do game
		Todascartas.add (new BruxaCaverna("Bruxa da Caverna", 20, 10, 5, Tipo.TREVAS, 10));
		Todascartas.add (new DemonioTrevas("Demonio das Trevas",	60,	25, 50, Tipo.TREVAS, 10));
		Todascartas.add (new EsqueletoGelo("Esqueleto de Gelo",	25,	30, 20, Tipo.FOGO, 5));
		Todascartas.add (new MagoBarbudo("Mago Barbudo", 55, 35, 25, Tipo.TREVAS, 6));
		Todascartas.add (new Arqueiro("Arqueiro da Angola", 30, 25, 20, Tipo.VENTO));
		Todascartas.add (new Dragao("Dragao de Comodo", 30, 50, 35, Tipo.FOGO));
		Todascartas.add (new Dinossauro("Rex Verde", 45, 15, 10, Tipo.TERRA));
		Todascartas.add (new AveRoxa("Ave Roxa", 78, 60, 40, Tipo.DIVINO));
		Todascartas.add (new MonstroLago("Monstro do Lago", 35, 20, 15, Tipo.GELO));
		Todascartas.add (new ElfoDama("Elfo Loulores", 35, 25, 20, Tipo.TREVAS));
		Todascartas.add (new BuracoNegro("Buraco Negro", 25, 50, 35, Tipo.LUZ));
		Todascartas.add (new CobraAsiatica("Cobra da Asia", 42, 32, 22, Tipo.FOGO));
		Todascartas.add (new PlantaCarnivora("Planta Carnivora", 14, 20, 23, Tipo.AGUA));		
		Todascartas.add (new InsetoLava("Inseto da Lava", 23, 25, 36, Tipo.VENTO));
		Todascartas.add (new ReptilSelvagem("Reptil Selvagem", 15, 25, 35, Tipo.GELO));
		Todascartas.add (new AbelhaRussa("Abelha da Russia", 5, 15, 25, Tipo.DIVINO));
		Todascartas.add (new Aventureiro("Aventureiro", 15, 25, 35, Tipo.DIVINO));
		Todascartas.add (new CacadorIndiano("Cacador da India", 45, 15, 25, Tipo.TREVAS));
		Todascartas.add (new Soldado("Soldado", 10, 20, 30, Tipo.LUZ));
		Todascartas.add (new VelhaBruxa("Velha Bruxa Feiticeira", 40, 20, 30, Tipo.TERRA));
		Todascartas.add (new LeaoHimalaia("Leao do Himalaia", 40, 25, 10, Tipo.FOGO));
		Todascartas.add (new PirataCarnivoro("Pirata Carnivoro", 36, 60, 45, Tipo.AGUA));
		Todascartas.add (new FadaCristalina("Fada toda Cristalina", 14, 18, 5, Tipo.VENTO));
		Todascartas.add (new TigreAsiatico("Tigre Asiatico Preto", 18, 20, 22, Tipo.GELO));
		Todascartas.add (new PlantaVenenosa("Planta Venenosa", 26, 32, 40, Tipo.DIVINO));
		Todascartas.add (new FenixLuz("Fenix da Luz", 15, 23, 14, Tipo.TREVAS));
		Todascartas.add (new VelcroLudico("Velcro Ludico", 45, 10, 5, Tipo.LUZ));
		Todascartas.add (new BaleiaGigante("Baleia Gigante", 7, 9, 10, Tipo.GELO));
	}	
}
