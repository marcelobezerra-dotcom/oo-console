# Mensagem para a Equipe

Carlos e Lucas, eu fiz o seguinte: eu organizei algumas pastas aqui, coloquei esse arquivo .md que é bom vocês lerem também, e eu quero que a gente separe as commits de cada um em si.

---

## Resumo do Projeto (Missão Marte Unifor)

- **Linguagem & Arquitetura**: Java (Console) com estrutura em POO no pacote `missao` (`src/missao/`).
- **Classes Principais**:
  - `Passageiro` (base), `Professor` e `Engenheiro` (subclasses/herança);
  - `Asteroide` (obstáculo e detecção de colisão);
  - `Nave` (movimentação e controle de capacidade);
  - `Missao` (orquestração do jogo e regras de embarque);
  - `Main` (loop principal do jogo, renderização do mapa e persistência em `ranking.json`).
- **Documentação de Apoio**: `TUTORIAL-MISSAO-MARTE.md` contém o roteiro de aulas e 10 exercícios práticos graduados.

---

## Histórico de Commits por Autor

### Prof. Bezerra / Marcelo Bezerra de Alcântara
- `524699e` (2026-08-12): Projeto OO - console nave
- `ecda2de` (2026-08-12): Initial commit

*OBS: Vocês ainda não tem suas branches, eu vou fazer a minha agora e depois vocês criem as suas para servirem como os primeiros committs*
*Branches Pendentes: Carlos, Lucas*

## Codigo Modificado Por Miguel:

Passageiro.java(
  Adição do metodo
  public int getPontuacao() {
        return 10;
    }
)

Professor.java(
  Sobrescrita do metodo getPontuacao() retornando 20 pontos
)

Engenheiro.java(
  Sobrescrita do metodo getPontuacao() retornando 40 pontos
)

Astronauta.java(
  Criação da classe Astronauta herdando de Passageiro
  Adição do metodo getPontuacao() retornando 15 pontos
)

Nave.java(
  Adição do atributo vida (iniciando com 3 vidas no construtor)
  Adição dos metodos getVida() e perderVida()
)

Dificuldade.java(
  Criação do Enum (FACIL, MEDIO, DIFICIL)
  Adição dos parâmetros de combustível inicial, asteroides e inimigos
  Adição dos métodos de conversão deString(), fromString() e toString()
)

Main.java(
  Substituição de score += 10 por score += p.getPontuacao();
  Adição das vidas da nave na tela
  Chamada do nave.perderVida() na colisão e checagem de fim de jogo se a vida zerar
  Adição do Astronauta no sorteio de passageiros e símbolo 'S' no mapa
  Integração da seleção de Dificuldade no menu ao iniciar o jogo
  Geração parametrizada da quantidade de asteroides e inimigos conforme a Dificuldade
)

## Codigo Modificado Por Carlos:

Inimigo.java(
  Criação da classe Inimigo com coordenadas (x, y)
  Adição dos métodos getters e setters (getX, getY, setX, setY)
  Adição do método colideCom(Nave n)
)

Missao.java(
  Adição da lista de Inimigos (List<Inimigo> inimigos)
  Adição dos métodos getInimigos() e addInimigo(Inimigo i)
  Adição do método moverInimigos(Random random, int minX, int maxX, int minY, int maxY)
  Atualização de verificaColisao() para checar colisão com Inimigos
)

Main.java(
  Adição da geração de Inimigos no método criarNovaMissao()
  Adição da validação de Inimigos em posicaoOcupada()
  Chamada do método missao.moverInimigos() a cada turno do loop
  Renderização do caractere 'X' para os Inimigos no mapa e atualização da legenda
)

## Codigo Modificado Por Lucas:

Main.java(
  Criação do Menu Principal Interativo com opções em loop (Jogar, Top 5, Resetar Ranking, Sair)
  Adição da Base (0,0) com exibição do caractere 'L' no mapa
  Atualização das regras de vitória (necessário resgatar todos e voltar para a Base (0,0))
  Cálculo e exibição de Estatísticas (duração da partida em segundos e total de passos/movimentos)
  Implementação da exclusão segura do ranking na memória e no arquivo ranking.json ao resetar
)