<!--
<p align="center">
  <img align="center" src="https://github.com/jonaslucenafilho/BlueBankPanAcademy/blob/main/assets/BlueBank_IMG.jpg" width="800px" />
</p> -->

![dscatalog-catalog](https://github.com/jonaslucenafilho/BlueBankPanAcademy/blob/main/assets/logo.gif)

<!-- <h1 align="center">Blue Bank</h1> -->

<div align="center">

[![BlueBank](https://img.shields.io/badge/BlueBank-name-blue.svg)](http://BlueBank.url.com)
[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![GitHub Pull Requests](https://img.shields.io/github/issues-pr/kylelobo/The-Documentation-Compendium.svg)](https://github.com/jonaslucenafilho/BlueBankPanAcademy/pulls)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE.md)

</div>

<p align="center">
	• <a href="#descricao">Descrição</a> •
	<a href="#gestao-do-projeto">Gestão do Projeto</a> •
	<a href="#versionamento">Versionamento do Código</a> •
	<a href="#arquitetura">Arquitetura do Projeto</a> •
	<a href="#aws-deploy">AWS e Deploy</a> •
	<a href="#documentacao">Documentação</a> •
	<a href="#tecnologias-dependencias">Tecnologias e Dependências</a> •
	<a href="#desenvolvedores">Desenvolvedores</a> •
</p>  

<h1 id="descricao">
  Descrição
</h1>

<p align="justify"> &emsp;&emsp;&emsp;Projeto desenvolvido durante a fase final do bootcamp PanAcademy, uma parceria entre o Banco Pan e a GamaAcademy. Consiste em uma API que possibilita o gerenciamento de contas e transações em um banco fictício. O sistema permite cadastro de novos clientes, incluindo dados pessoais e dados para contato, onde o mesmo é atrelado a uma conta bancária e consegue ter acesso ao hitórico de transações.
</p>

<h1 id="gestao-do-projeto">
  Gestão do Projeto
</h1>

<p text-align="justify"> &emsp;&emsp;&emsp;A gestão do projeto foi feita através do método Kanban, que consiste em uma forma de gestão visual de projetos, permitindo às equipes visualizar melhor a sua carga e fluxo de trabalho. Foi utilizada a plataforma <a href="https://www.atlassian.com/br/software/trello">Trello</a> para criação do quadro Kanban. Dessa forma, o trabalho ficou exibido em um quadro de projetos organizado por colunas. O design das colunas do quadro Kanban, seguiu a seguinte lógica: 
  <p align="center">
    <b>| Documentação | Backlog | Desenvolvimento | Em Teste | Concluído |</b>
  </p>
</p>

<p align="center">  
  <img align="center" src="https://github.com/jonaslucenafilho/BlueBankPanAcademy/blob/main/assets/quadrofinal.png" width="800px" />
</p>

<p text-align="justify"> &emsp;&emsp;&emsp;Houve um planejamento prévio baseado no diagrama de classes, e a medida que o desenvolvimento ia avançando as taferas/issues eram acrescentadas na coluna de backlog. A abordagem das tarefas foi bem fragmentada, pois a squad priorizou pequena tarefas em que as implementações poderiam acontecer sem que ocorresse algum problema de conflito na hora de realizar os merges na branch principal.
</p>

<p text-align="justify"> &emsp;&emsp;&emsp;Afim de priorizar quais tarefas deveriam ser implementadas de forma mais urgente lançamos mão de etiquetas de urgência, as quais iam prioridade alta até a baixa, passando pela média. Os cards continham informações que foram anteriormente acordadas pela equipe, para que dessa forma a evolução de cada tarefa ficasse visível para todos. E a medida que o desenvolvimento fosse evoluindo os cartões
eram transicionados até chegarem a coluna de conclusão.
</p>

<p align="center">  
  <img align="center" src="https://github.com/jonaslucenafilho/BlueBankPanAcademy/blob/main/assets/card1.png" width="400px" />
	 <img align="center" src="https://github.com/jonaslucenafilho/BlueBankPanAcademy/blob/main/assets/card2.png" width="400px" />
</p>

<h1 id="versionamento">
  Versionamento do Código
</h1>

<p text-align="justify">&emsp;&emsp;&emsp;O versionamento de código foi feito através do Git, que é um sistema de controle de versão de arquivos. Através deles podemos desenvolver projetos na qual diversas pessoas podem contribuir simultaneamente no mesmo, editando e criando novos arquivos e permitindo que os mesmos possam existir sem o risco de suas alterações serem sobrescritas.
</p>

<p text-align="justify">&emsp;&emsp;&emsp;A plataforma utilizada para hospedagem do repositório remoto foi o <a href="https://github.com/">GitHub</a>, onde todos os integrantes foram colocados como contribuidores do projeto. Dessa forma adotamos o fluxo GitHub Flow, o qual foi criado pelo GitHub em 2011 e é o modelo mais simples de Git Workflow. 
</p>

<p align="center">  
  <img align="center" src="https://github.com/jonaslucenafilho/BlueBankPanAcademy/blob/main/assets/gr%C3%A1fico%20git.png" width="500px" />
</p>

<p text-align="justify">&emsp;&emsp;&emsp;Ele é um fluxo de trabalho baseado em Branchs onde as implantações são feitas regularmente. Cada unidade de trabalho, seja um bug ou feature, é feita através de uma branch criada a partir da main. Assim os desenvolvedores após realizarem sua implementações em uma branch baseada na linha principal do projeto, solicitavam os pull requests que eram avaliados pela squad, sendo aprovado o merge era realizado na main. Adotamos esse fluxo por ser simples e seguro, além de garantir uma linha principal estável. 
</p>

<h1 id="arquitetura">
  Arquitetura do Projeto
</h1>

<h1 id="aws-deploy">
  Aws e Deploy
</h1>

<p align="justify"> &emsp;&emsp;&emsp;Na AWS, a squad escolheu utilizar o serviço EC2 com uma instancia EC2 linux ubunto 20.3. Para a hospedagem do banco de dados, foi utilizada a AWS RDS com o banco de dados MySql 8.23.
</p>

<h3>• Passos para o Deploy</h3>

<p align="justify">Após a criação e configuração do ECT e do Banco de Dados RDS, foram realizados os seguintes passos:

- Criação do container Docker, com o AWS cli instalado, para conexão na instância EC2.
- Instalação do Docker na instância EC2.
- Realização do build da API e criação de um Dockerfile para subir a imagem no Dockerhub.
- Dentro da maquina virtual, foi criada uma instância da aplicação a partir da imagem do Dockerhub, passando as variáveis de ambiente necessárias para a conexão com o banco de dados RDS.
</p>

<h1 id="documentacao">
  Documentação
</h1>

<p text-align="justify"> &emsp;&emsp;&emsp;Foi utilizado o swagger para criação da documentação automática da API. A documentação oficial com descrição detalhada dos endpoints, classes e respostas pode ser encontrada abaixo:
</p>

<a href="https://app.swaggerhub.com/apis-docs/fhilips/BlueBankApi/1.0.0#">Documentação Oficial</a>

A collection do postman atualizada pode ser importada no link:

### Api Endpoints


Breve descrição dos endpoints da aplicação.

<details>
  <summary>Movimentação Endpoints</summary>
 <br>
  
  Retorna uma lista paginada de movimentações  
  ``` ruby
  GET /v1/movimentacao
  ```   
  Salva uma nova movimentaçao
  ``` ruby
  POST /v1/movimentacao
  ```
  Retorna uma movimentaçao a partir do id da conta de origem
  ``` ruby
  GET /v1/movimentacao/{origemId}  
  ```
  
</details>

<details>
  <summary>Conta Endpoints</summary>
 <br>  
  
  Retorna uma lista de contas 
  ``` ruby
  GET /v1/contas
  ```   
  Salva uma nova conta
  ``` ruby
  POST /v1/contas
  ```
  Retorna uma lista de contas com status ativo
  ``` ruby
  GET /v1/contas/ativas  
  ```
  Retorna um extrato filtrado de uma conta
  ``` ruby
  GET /v1/contas/extrato  
  ```
  Retorna uma conta a partir do id
  ``` ruby
  GET /v1/contas/{id}
  ```
  Altera o status de uma conta a partir do id
  ``` ruby
  PATCH /v1/contas/{id}
  ```  
  
</details>

<details>
  <summary>Cliente Endpoints</summary>
 <br>  
  
  Retorna uma lista de contas 
  ``` ruby
  GET /v1/contas
  ```   
  Retorna uma lista de clientes
  ``` ruby
  GET /v1/clientes
  ```  
  Salva um novo cliente
  ``` ruby
  POST /v1/clientes
  ``` 
  Retorna um cliente a partir do id informado
  ``` ruby
  GET /v1/clientes/{id}
  ```
  Atualiza um cliente a partir do id informado
  ``` ruby
  PUT /v1/clientes/{id} 
  ```
  
</details>

<details>
  <summary>Gerente Endpoints</summary>
 <br>  
  
  Retorna uma lista de gerentes 
  ``` ruby
  GET /v1/gerentes
  ```   
  Salva um novo gerente
  ``` ruby
  POST /v1/gerentes
  ``` 
  Retorna um gerente a partir do id informado
  ``` ruby
  GET /v1/gerentes/{id}
  ```
  Atualiza um gerente a partir do id informado
  ``` ruby
  PUT /v1/gerentes/{id} 
  ```
  
</details>

<details>
  <summary>Agência Endpoints</summary>
 <br>  
  
  Retorna uma lista de agencias 
  ``` ruby
  GET /v1/agencias
  ```   
  Salva uma nova agencia
  ``` ruby
  POST /v1/agencias
  ``` 
  Retorna uma agencia a partir do id informado
  ``` ruby
  GET /v1/agencias/{id}
  ```
  Atualiza uma agencia a partir do id informado
  ``` ruby
  PUT /v1/agencias/{id} 
  ```
  
</details>

<details>
  <summary>Endereço Endpoints</summary>
 <br>  
  
  Retorna uma lista de endereços 
  ``` ruby
  GET /v1/enderecos
  ```

</details>

<h1 id="tecnologias-dependencias">
	Tecnologias e Dependências
</h1>

<a name = "tech_stack"></a>

- [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) - Versão do Java utilizada
- [Spring boot](https://spring.io/projects/spring-boot) - Server Environment
- [Maven](https://maven.apache.org/) - Server Framework
- [H2 Database](https://www.h2database.com/html/main.html) - Database para o ambiente de testes
- [MySql Database](https://www.mysql.com/) - Database para o ambiente de produção
- [Spring Data Jpa](https://spring.io/projects/spring-data-jpa) - Abstração orm do spring pra integração com o banco de dados
- [Swagger](https://swagger.io/) - Documentação ofcial da API
- [Postman](https://www.postman.com/) - Ferramenta para testes nas requisições
- [Lombok](https://projectlombok.org/) - Framework para abstração e melhora na legibilidade do código
- [Trello](https://trello.com/) - Aplicativo de gerenciamento de projeto
- [AWS](https://aws.amazon.com/) - Serviços para hospedagem e deploy
- [Docker](https://www.docker.com/) - Criação de containers

<h1 id="desenvolvedores">
  Desenvolvedores
</h1>

<table align="center">
  <tr>
    <td align="center"><a href="https://github.com/celsobomfim28"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/celsobomfim28" width="100px;" alt=""/><br /><sub><b>Celso Bomfim</b></sub></a><br /><a href="https://github.com/celsobomfim28" title="Celso Bomfim"></a></td>
    <td align="center"><a href="https://github.com/oneyottabyte"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/oneyottabyte" width="100px;" alt=""/><br /><sub><b>Dorian Vieira</b></sub></a><br /><a href="https://github.com/oneyottabyte" title="Dorian Vieira"></a></td>
    <td align="center"><a href="https://github.com/fhilips"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/fhilips" width="100px;" alt=""/><br /><sub><b>Filipe dos Santos</b></sub></a><br /><a href="https://github.com/fhilips" title="Filipe dos Santos"></a></td>
    <td align="center"><a href="https://github.com/filipelustosaf"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/filipelustosaf" width="100px;" alt=""/><br /><sub><b>Filipe Lustosa</b></sub></a><br /><a href="https://github.com/filipelustosaf" title="Filipe Lustosa"></a></td>
    <td align="center"><a href="https://github.com/jonaslucenafilho"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/jonaslucenafilho" width="100px;" alt=""/><br /><sub><b>Jonas Lucena</b></sub></a><br /><a href="https://github.com/jonaslucenafilho" title="Jonas Lucena"></a></td>
     <td align="center"><a href="https://github.com/mateusMBA"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/mateusMBA" width="100px;" alt=""/><br /><sub><b>Mateus Almeida</b></sub></a><br /><a href="https://github.com/mateusMBA" title="Mateus Almeida"></a></td>
  </tr>
</table>
