# Revisão SOLID - Missão Marte

## Checklist técnico

### SRP
- Local: JogoService
- Princípio relacionado: SRP
- Observação: a classe concentra o fluxo do jogo, leitura de entrada, posicionamento de elementos, regras de vitória/derrota e persistência de ranking.
- Impacto: qualquer mudança no menu, no mapa, na regra de pontuação ou no formato do ranking exige mexer na mesma classe, tornando o código mais difícil de manter.
- Proposta: manter `JogoService` como orquestrador, mas extrair partes como `EntradaConsole`, `GeradorMissao` e `CalculadoraPontuacao` para reduzir motivos de mudança.
- Prioridade: alta

### OCP
- Local: `Passageiro` e `JogoService.posicionarPassageiros`
- Princípio relacionado: OCP
- Observação: a hierarquia de passageiros permite extensão, mas a criação concreta ainda está acoplada a `if (indice % 3 == 0) ...` dentro do serviço.
- Impacto: ao adicionar um novo tipo de passageiro, a lógica de criação precisa ser alterada no serviço.
- Proposta: criar um `Factory` ou `PassageiroFactory` para decidir o tipo do passageiro sem alterar o fluxo principal.
- Prioridade: média

### LSP
- Local: `Passageiro` e subclasses
- Princípio relacionado: LSP
- Observação: as subclasses `Professor`, `Engenheiro` e `Astronauta` podem ser tratadas como `Passageiro`, e isso funciona bem.
- Impacto: a substituição é segura porque todas seguem o contrato da base.
- Proposta: manter a hierarquia, mas evitar que `getTipo()` seja usado como condicionante em mais de um lugar do código.
- Prioridade: baixa

### ISP
- Local: `RankingRepository`
- Princípio relacionado: ISP
- Observação: a interface é pequena e expressa um contrato claro de persistência.
- Impacto: reduz acoplamento e deixa a implementação substituível.
- Proposta: manter a interface assim; só seria necessário mais refinamento se surgirem operações muito específicas de banco ou de API.
- Prioridade: baixa

### DIP
- Local: `Main`, `JogoService`, `RankingRepository`
- Princípio relacionado: DIP
- Observação: o ponto de entrada depende da abstração `RankingRepository`, e o serviço também depende dela.
- Impacto: isso facilita trocar a persistência por outra estratégia sem mexer no fluxo do jogo.
- Proposta: manter a abstração e considerar injeção de dependência por construtor em outros componentes também.
- Prioridade: baixa

## Melhorias adicionais identificadas

### 1. Separação da entrada do usuário
- Local: `JogoService` e `Scanner`
- Princípio relacionado: SRP / DIP
- Observação: a leitura do console está diretamente no serviço de jogo.
- Impacto: isso dificulta testes automatizados e reaproveitamento da lógica para UI diferente.
- Proposta: extrair uma classe `InputPort` ou `ConsoleInput` para isolar `Scanner`.
- Prioridade: alta

### 2. Persistência com injeção de dependência mais testável
- Local: `RankingService`
- Princípio relacionado: DIP
- Observação: a classe salva em arquivo no caminho fixo do projeto e exige I/O do sistema de arquivos.
- Impacto: testes unitários ficam acoplados ao disco local.
- Proposta: permitir `RankingRepository` em memória para testes e usar arquivo somente em ambiente de produção.
- Prioridade: média

## Decisões com as quais não concordo

### Decisão 1: `JogoService` ainda abriga muita lógica
- Local: `JogoService`
- Princípio relacionado: SRP
- Observação: o tutorial mantém o serviço como o coração do jogo, mas ele também define criação de mapas, posicionamento, leitura, pontuação e ranking.
- Impacto: a classe cresce demais e tem vários motivos para mudar ao mesmo tempo.
- Proposta: dividir em serviços menores e mais explícitos, como `MissaoFactory`, `RankingService`, `MapaRenderer` e `EntradaConsole`.
- Prioridade: alta

### Decisão 2: o tutorial usa `Professor` em duas ocorrências sem especialização clara
- Local: `JogoService.posicionarPassageiros`
- Princípio relacionado: OCP
- Observação: há repetição de `new Professor(...)` e lógica por índice para decidir tipos.
- Impacto: a manutenção exige alterar o código sempre que novas categorias forem adicionadas.
- Proposta: usar uma fábrica de passageiros com lista de tipos ou alguma estratégia de geração.
- Prioridade: média

## Conclusão

A refatoração conseguiu melhorar significativamente a organização do projeto ao separar regras de negócio, apresentação e persistência. O maior avanço foi a introdução de abstrações e a redução do acoplamento entre a lógica do jogo e o armazenamento de dados. Mesmo assim, o código ainda está longe de representar uma arquitetura ideal de produção porque o serviço principal continua concentrando diversos motivos de mudança.

Em um projeto maior, eu manteria a estrutura geral, mas faria uma segunda etapa de refatoração para separar entrada, geração de missão e regras de pontuação. Isso manteria a base SOLID, mas reduziria o custo de manutenção e aumentaria a capacidade de testes automatizados.
