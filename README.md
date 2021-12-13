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
  <a href="#metodologias-ageis">Metodologias Ágeis</a> •
  <a href="#desenvolvedores">Desenvolvedores</a> •
</p>  

<img align="left" src="https://user-images.githubusercontent.com/65415371/124739746-10d91680-df12-11eb-86cd-9aa9494e01bd.png" width="50px" />

<h2 id="descricao">
  Descricao
</h2>

<p align="left"> Em desenvolvimento...
O projeto foi desenvolvido durante a fase final do bootcamp PanAcademy, uma parceria entre o banco Pan e a GamaAcademy.
O projeto consiste em uma API para facilitar o gerenciamento de contas e transações de um banco ficticio.

</p>

## Arquitetura do projeto

## Aws e Deploy

Na AWS escolhemos utilzar o serviço EC2 com uma instancia Ec2 linux ubunto 20.3. Para hospedagem do banco de dados utilizamos a AWS RDS com o banco de dados MySql 8.23.

### Passos para o deploy

Após de criados e configurados o EC2 e o banco de dados RDS, relizamos os seguintes passos:

- Criamos um container docker com o aws cli instalado para nos conectarmos em nossa instancia EC2.
- Instalamos o docker em nossa instância EC2.
- Realizamos o build de nossa aplicação e e criamos um Dockerfile para subirmos nossa imagem no dockerhub
- Dentro da nossa maquina virtual, criamos uma instancia da nossa aplicação a partir da nossa imagem no Dockerhub passando as variáveis de ambiente necessárias para a conexão com o banco de dados RDS
</p>  

<img align="left" src="https://github.com/jonaslucenafilho/BlueBankPanAcademy/blob/main/assets/icons8-api-48.png" width="50px" />

<h2 id="documentacao">
  Documentação da API
</h2>

Utilizamos o swagger para criação da documentação automática da
A documentação oficial da API com descrição detalhada dos endpoints, classes e respostas pode ser encontrada neste link: [documentação oficial](https://app.swaggerhub.com/apis-docs/fhilips/BlueBankApi/1.0.0#/movimentacao-controller/createUsingPOST_4)

A collection do postman atualizada pode ser importada no link:

### Api Endpoints

Breve descrição dos endpoints da nossa aplicação

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

<p align="justify"> &emsp;&emsp;&emsp;O banco fictício BlueBank está construindo uma nova plataforma e precisa de uma API para gerenciar as transações. Utilize suas novas habilidades com Java, Banco de dados e AWS. O sistema deve permitir cadastro de novos clientes, incluindo dados pessoais e dados para contato. O cliente deve ser atrelado a uma conta bancária e registrar histórico de transações entre as contas.
</p>

<img align="left" src="https://user-images.githubusercontent.com/65415371/124740181-74634400-df12-11eb-929c-9aa1bf060806.png" width="50px" />

<h2 id="metodologias-ageis">
  Metodologias Ágeis
</h2> 

<h3 align="left" id="github">Quadro Kanban</h3>

<p text-align="justify"> &emsp;&emsp;&emsp;A gestão do projeto foi feita através do método Kanban, que consiste em uma forma de gestão visual de projetos, permitindo às equipes visualizar melhor a sua carga e fluxo de trabalho. Foi utilizada a plataforma <a href="https://www.atlassian.com/br/software/trello">Trello</a> para criação do quadro Kanban, dessa forma o trabalho ficou exibido em um quadro de projetos organizado por colunas. O design das colunas do quadro Kanban, seguiu a seguinte lógica: 
  <p align="center">
    | Documentação | Backlog | Desenvolvimento | Em Teste | Concluído |
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

<h3 align="left" id="github">Versionamento de Código</h3>
<p text-align="justify">&emsp;&emsp;&emsp;O versionamento de código foi feito através do Git, que é um sistema de controle de versão de arquivos. Através deles podemos desenvolver projetos na qual diversas pessoas podem contribuir simultaneamente no mesmo, editando e criando novos arquivos e permitindo que os mesmos possam existir sem o risco de suas alterações serem sobrescritas.
</p>

<p text-align="justify">&emsp;&emsp;&emsp;A plataforma utilizada para hospedagem do repositório remoto foi o <a href="https://github.com/">GitHub</a>, onde todos os integrantes foram colocados como contribuidores do projeto. Dessa forma adotamos o fluxo GitHub Flow, o qual foi criado pelo GitHub em 2011 e é o modelo mais simples de Git Workflow. 
</p>

<p align="center">  
  <img align="center" src="https://github.com/jonaslucenafilho/BlueBankPanAcademy/blob/main/assets/gr%C3%A1fico%20git.png" width="500px" />
</p>

<p text-align="justify">&emsp;&emsp;&emsp;Ele é um fluxo de trabalho baseado em Branchs onde as implantações são feitas regularmente. Cada unidade de trabalho, seja um bug ou feature, é feita através de uma branch criada a partir da main. Assim os desenvolvedores após realizarem sua implementações em uma branch baseada na linha principal do projeto, solicitavam os pull requests que eram avaliados pela squad, sendo aprovado o merge era realizado na main. Adotamos esse fluxo por ser simples e seguro, além de garantir uma linha principal estável. 
</p>
<br>


<img align="left" src="https://user-images.githubusercontent.com/65415371/124741011-3581be00-df13-11eb-8d9a-b44e6fe248a8.png" width="50px" />

## Tecnologias e Dependências ⛏️ <a name = "tech_stack"></a>

- [Spring boot](https://nodejs.org/en/) - Server Environment
- [Java 11](https://nodejs.org/en/) - Versão do Java utilizada
- [Maven](https://expressjs.com/) - Server Framework
- [H2 Database](https://www.mongodb.com/) - Database para o ambiente de testes
- [MySql Database](https://www.mongodb.com/) - Database para o ambiente de produção
- [Spring Data Jpa](https://www.mongodb.com/) - Abstração orm do spring pra integração com o banco de dados
- [Swagger](https://vuejs.org/) - Documentação ofcial da API
- [Postman](https://www.mongodb.com/) - Ferramenta para testes nas requisições
- [Lombok](https://nodejs.org/en/) - Framework para abstração e melhora na legibilidade do código
- [Trello](https://nodejs.org/en/) -
- [AWS](https://nodejs.org/en/) - Serviços para hospedagem e deploy
- [Docker](https://nodejs.org/en/) - Criação de containers

<h2 id="desenvolvedores">
  Desenvolvedores 🦸
</h2>  

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
