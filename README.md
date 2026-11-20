HomeChore Challenge
REST API para organizar uma competição semanal de tarefas domésticas
entre participantes.

O sistema registra tarefas realizadas, contabiliza pontos por
participante e mantém o histórico das competições semanais.
Status: em desenvolvimento. Este repositório documenta a proposta
e a estrutura planejada. Nem todas as entidades, regras de negócio ou
endpoints descritos estão necessariamente implementados ainda.

Objetivo
Transformar a divisão das tarefas domésticas em uma competição amigável.
Cada tarefa concluída gera pontos para quem a realizou. Ao final da
semana, o sistema apura o placar e registra o resultado.
Tecnologias
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2 Database
- Lombok
- Maven
Entidades principais
  Entidade                            Responsabilidade
  Participant                       Representa uma pessoa participante.

  Chore                             Representa uma tarefa doméstica
cadastrada.

  Competition                       Representa o período semanal da
disputa.

  ChoreCompletion                   Registra cada execução de uma
tarefa por um participante.
CompetitionResult                 Armazena o resultado final de uma
competição.
Regras gerais
- A semana da competição vai de domingo a sábado.
- A apuração acontece no domingo seguinte.
- Cada conclusão válida gera a pontuação definida para a tarefa. A
  pontuação inicial prevista é de 1 ponto.
- Uma tarefa pode ser registrada várias vezes, desde que tenha sido
  realizada em cada ocasião.
- Apenas participantes e tarefas ativos podem ser usados em novos
  registros.
- Uma conclusão deve pertencer ao período da competição
  correspondente.
- Uma competição finalizada não aceita novas conclusões.
- Competições não podem ter períodos sobrepostos.
- Cada competição pode ter no máximo um resultado.
- Em caso de empate, não há vencedor nem perdedor.
- O histórico deve ser preservado mesmo quando uma tarefa for
  desativada.
- O fechamento semanal deve ser transacional.
Executar localmente
Pré-requisitos: JDK 21 e Git.

Na raiz do projeto:
./mvnw spring-boot:run
Para compilar:
./mvnw clean compile
Os comandos pressupõem que o Maven Wrapper (mvnw e a pasta .mvn)
esteja presente no repositório.
Documentação
A especificação funcional, as entidades, os relacionamentos e as regras
de negócio estão em
[`docs/PROJECT_SPECIFICATION.md`](docs/PROJECT_SPECIFICATION.md).
Próximas etapas
- Finalizar entidades e relacionamentos JPA.
- Implementar DTOs, repositórios, serviços e controllers.
- Implementar validações das regras de negócio.
- Implementar o fechamento transacional da competição.
- Criar testes unitários e de integração.
- Documentar os endpoints da API.
Observação
Este é um projeto de estudo e desenvolvimento incremental. A
documentação descreve o comportamento desejado; consulte o código-fonte
para verificar o que já está implementado.
