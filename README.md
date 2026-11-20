# HomeChore Challenge

**Language:** English \| [Português](#homechore-challenge---português)

## English

### Overview

HomeChore Challenge is a REST API for managing household chores and
running a friendly weekly competition between participants. Participants
earn points by completing registered chores during a weekly competition
period. At the end of the period, the participant with the highest score
wins.

The project is being developed as a learning project with Java and
Spring Boot, following a layered REST API structure.

### Main features

-   Manage household chores.
-   Manage competition participants.
-   Organize weekly competitions from Sunday through Saturday.
-   Register chore completions and award points.
-   Calculate participant scores.
-   Record the competition result, including a tie when scores are
    equal.
-   Preserve completion history when a chore is deactivated.

### Technology stack

-   Java 21
-   Spring Boot
-   Spring Data JPA
-   Hibernate
-   H2 Database
-   Maven
-   Lombok

### Domain model

  -----------------------------------------------------------------------
  Entity                              Purpose
  ----------------------------------- -----------------------------------
  `Chore`                             Stores household chores and their
                                      active status.

  `Participant`                       Stores people taking part in the
                                      competition.

  `Competition`                       Represents a weekly competition
                                      period.

  `ChoreCompletion`                   Records a chore completed by a
                                      participant during a competition.

  `CompetitionResult`                 Stores the final outcome of a
                                      competition.
  -----------------------------------------------------------------------

### Main business rules

1.  A competition runs from Sunday to Saturday.
2.  The competition is finalized on the following Sunday.
3.  Only active participants and active chores can be used for new
    completion records.
4.  A completion must belong to the correct competition and fall within
    its date range.
5.  Each valid completion earns the points configured for that chore.
6.  The points earned are stored with the completion so later changes to
    a chore's score do not change historical results.
7.  The same chore may be recorded more than once during a week when it
    is genuinely performed each time.
8.  The participant with the higher total score wins. Equal scores
    produce a tie, with no winner or loser.
9.  A finalized competition does not accept new completion records.
10. A chore should be deactivated rather than deleted when its history
    must be preserved.
11. Finalization must be transactional so that score calculation, result
    creation, and competition status update succeed or fail together.
12. A competition can have no more than one final result.

### Project status

This project is under development. The documentation describes the
intended domain model and business rules; it does not imply that every
feature has already been implemented.

### Running the project

Make sure Java 21 is installed. From the project root, run:

``` bash
./mvnw spring-boot:run
```

To compile the project:

``` bash
./mvnw clean compile
```

### Project documentation

The detailed domain model, relationships, workflows, and business rules
are documented in:

-   [`docs/PROJECT_SPECIFICATION.md`](docs/PROJECT_SPECIFICATION.md)

### Repository

GitHub: https://github.com/lnevesl/home-chore-challenge

------------------------------------------------------------------------

## HomeChore Challenge - Português

### Visão geral

HomeChore Challenge é uma API REST para gerenciar tarefas domésticas e
organizar uma competição semanal amigável entre participantes. Os
participantes acumulam pontos ao concluir tarefas registradas durante o
período da competição. Ao final do período, vence quem obtiver a maior
pontuação.

O projeto está sendo desenvolvido como um projeto de aprendizado com
Java e Spring Boot, seguindo uma estrutura em camadas para API REST.

### Funcionalidades principais

-   Gerenciar tarefas domésticas.
-   Gerenciar os participantes da competição.
-   Organizar competições semanais de domingo a sábado.
-   Registrar a conclusão de tarefas e atribuir pontos.
-   Calcular a pontuação dos participantes.
-   Registrar o resultado da competição, incluindo empate quando as
    pontuações forem iguais.
-   Preservar o histórico de conclusões quando uma tarefa for
    desativada.

### Tecnologias

-   Java 21
-   Spring Boot
-   Spring Data JPA
-   Hibernate
-   Banco de dados H2
-   Maven
-   Lombok

### Modelo de domínio

  -----------------------------------------------------------------------
  Entidade                            Finalidade
  ----------------------------------- -----------------------------------
  `Chore`                             Armazena as tarefas domésticas e
                                      seu status de atividade.

  `Participant`                       Armazena as pessoas que participam
                                      da competição.

  `Competition`                       Representa o período de uma
                                      competição semanal.

  `ChoreCompletion`                   Registra uma tarefa concluída por
                                      um participante durante uma
                                      competição.

  `CompetitionResult`                 Armazena o resultado final de uma
                                      competição.
  -----------------------------------------------------------------------

### Principais regras de negócio

1.  A competição acontece de domingo a sábado.
2.  A competição é finalizada no domingo seguinte.
3.  Somente participantes ativos e tarefas ativas podem ser utilizados
    em novos registros de conclusão.
4.  Uma conclusão deve pertencer à competição correta e estar dentro do
    período de datas dela.
5.  Cada conclusão válida recebe a pontuação configurada para aquela
    tarefa.
6.  Os pontos obtidos são armazenados junto ao registro da conclusão.
    Assim, alterações futuras na pontuação de uma tarefa não modificam
    resultados históricos.
7.  A mesma tarefa pode ser registrada mais de uma vez durante a semana,
    desde que tenha sido realmente executada em cada ocasião.
8.  O participante com a maior pontuação vence. Pontuações iguais
    resultam em empate, sem vencedor ou perdedor.
9.  Uma competição finalizada não aceita novos registros de conclusão.
10. Uma tarefa deve ser desativada, em vez de excluída, quando seu
    histórico precisar ser preservado.
11. A finalização deve ser transacional para que o cálculo da pontuação,
    a criação do resultado e a atualização do status da competição sejam
    concluídos juntos ou cancelados juntos.
12. Uma competição pode ter, no máximo, um resultado final.

### Status do projeto

Este projeto está em desenvolvimento. A documentação descreve o modelo
de domínio e as regras de negócio planejadas; isso não significa que
todas as funcionalidades já estejam implementadas.

### Como executar o projeto

Certifique-se de que o Java 21 esteja instalado. Na pasta raiz do
projeto, execute:

``` bash
./mvnw spring-boot:run
```

Para compilar o projeto:

``` bash
./mvnw clean compile
```

### Documentação do projeto

O modelo de domínio detalhado, os relacionamentos, os fluxos e as regras
de negócio estão documentados em:

-   [`docs/PROJECT_SPECIFICATION.md`](docs/PROJECT_SPECIFICATION.md)

### Repositório

GitHub: https://github.com/lnevesl/home-chore-challenge
