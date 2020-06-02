# Jogo de Cartas
# Senac 2020 - TSI - Programacao orientada a objetos

# Criador do Projeto
# - Leonardo Laurindo Martinez 


Jogo de cartas para 2 jogadores.

### Pack de Cartas do game
	- Cada Player tera um deck de 23 cartas.
		- 5 Combatentes
		- 6 Armas
		- 6 Armaduras
		- 6 Joias
	- Cada carta tem um nome, quantidade de vida, ataque e defesa.
	- Algumas cartas tem efeitos especiais como o aumento de ataque/defesa.
	- Armas aumentam o ataque
	- Armadura aumenta a defesa
	- Joia pode aumentar o ataque ou a defesa, isso depende da forma aleatoria em cada ataque/defesa.
	

### Cada jogador deve:
1. Digitar seu nome
2. Escolher os equipamentos de suas cartas.

### Como funciona
	- Cada jogador escolha 1 carta por partida, a carta que ficar sem vida, sera removida do pack de cartas, entao sera feita outra partida sucessivamente.
	- Quando todas as cartas de um jogador ficarem em vida, o outro vence a partida.
	- O valor do ataque sera algo aleatorio entre 0 e 20.
	- O valor da Defesa sera algo aleatorio entre 0 e 10.
	- Sera exibido o status da carta em cada partida concluida.
	- Sera exibido antes de cada partida os efeitos das cartas que vai participar da partida.

#### Cartas
- Super classe carta tem as principais funcionalidades das cartas
- Outras 5 super classes que herdam a classe carta, algumas delas tem efeitos diferentes
- As subClasses de cartas podem ter algumas particularidades 

#### Pacotes de Equipamentos
- Armas, Armaduras e Joia.
 
#### Tipos
	Cartas e equipamentos tem tipos diferentes, algo que pode influenciar na batalha:
	- Um ataque, contra outra do mesmo tipo, tem esse ataque reduzido na partida.
	- As cartas tem fraquezas contras certos tipos.
	- Os efeitos/equipamentos tem um subTipo: Ataque, Defesa.
		- Um efeito vai ser considerado quando a carta estiver atacando
		- Um efeito de defesa entra em acao se a carta estiver se defendendo
		- O random muda para ataque ou defesa a cada vez que sera feito um ataque/defesa.	