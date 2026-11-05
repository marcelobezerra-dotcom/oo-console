# Missão Marte Unifor — Jogo OO em Console

**Disciplina:** Projeto arquitetura de sistemas 
**Repositório:** https://github.com/LucasDCoelho/trabalho_arquitetura

## Integrantes

| Nome | Matrícula | GitHub |
|---|---|---|
| Lucas Coelho | 2510461 | LucasDCoelho |
| João Pedro Carvalho | 2510547 | carvalho-jp |

## Sobre o Projeto

Este repositório mantém a versão original do jogo em `src/missao` e também inclui uma refatoração em `src/solidexercicio10`, organizada com foco nos princípios SOLID.

A ideia da refatoração é separar responsabilidades de negócio, apresentação e persistência, mantendo o fluxo principal do jogo funcionando e melhorando a manutenção do código. A versão original foi preservada para permitir comparação entre o antes e o depois.

## Estrutura

```text
src/
├── missao/
│   ├── Main.java
│   ├── Missao.java
│   ├── Nave.java
│   ├── Passageiro.java
│   ├── Professor.java
│   ├── Engenheiro.java
│   ├── Astronauta.java
│   ├── Asteroide.java
│   ├── Inimigo.java
│   └── Dificuldade.java
│
└── solidexercicio10/
    ├── Main.java
    ├── model/
    │   ├── EntidadeMapa.java
    │   ├── Posicionavel.java
    │   ├── Movel.java
    │   ├── Dificuldade.java
    │   ├── Passageiro.java
    │   ├── Professor.java
    │   ├── Engenheiro.java
    │   ├── Astronauta.java
    │   ├── Asteroide.java
    │   ├── Inimigo.java
    │   ├── Nave.java
    │   └── Missao.java
    ├── presentation/
    │   └── MapaRenderer.java
    ├── repository/
    │   ├── RankingRepository.java
    │   ├── RankingService.java
    │   └── RankingEntry.java
    └── service/
        └── JogoService.java
```

## Compilação e Execução

Execute os comandos abaixo a partir da raiz do repositório:

```bash
javac -d out src/missao/*.java
java -cp out missao.Main
```

Para executar a versão refatorada:

```powershell
$files = Get-ChildItem -Recurse -Filter *.java -Path src/solidexercicio10 | ForEach-Object { $_.FullName }
javac -d out $files
java -cp out solidexercicio10.Main
```

> Requer JDK 8 ou superior.

## Como Jogar

| Comando | Ação |
|---|---|
| `w` | Mover para cima |
| `s` | Mover para baixo |
| `a` | Mover para a esquerda |
| `d` | Mover para a direita |
| `c` | Embarcar passageiro na posição atual |
| `q` | Sair / abortar missão |

- Cada movimento custa `1` ponto.
- Embarcar um passageiro vale pontos de acordo com seu tipo.
- Colidir com asteroide ou inimigo reduz a vida da nave.
- Quando todos os passageiros forem resgatados, o jogador deve voltar para `(0,0)` para concluir a missão.
- O ranking pode ser consultado e resetado pelo menu do jogo.

## Geração de Javadoc

```bash
javadoc -d docs -encoding UTF-8 -charset UTF-8 -sourcepath src missao
```

Os arquivos HTML serão gerados em `docs/` (abra `docs/index.html`).

## Revisão crítica

A análise da aplicação em SOLID está registrada em `REVISAO-SOLID.md`. Nesse documento são discutidas as decisões de projeto, as melhorias possíveis e os pontos que ainda poderiam ser refinados.
