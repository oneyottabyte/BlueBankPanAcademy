create table tb_agencias (id_agencia bigint not null auto_increment, nome_agencia varchar(255), numero_agencia varchar(255), id_gerente bigint, primary key (id_agencia)) engine=MyISAM;
create table tb_clientes (id_cliente bigint not null auto_increment, cpf varchar(15), data_nascimento date not null, email varchar(50), nome varchar(255), telefone varchar(20), id_endereco bigint not null, primary key (id_cliente)) engine=MyISAM;
create table tb_contas (id_conta bigint not null auto_increment, data_abertura datetime not null, numero_da_conta varchar(10), saldo decimal(19,2) not null, status_conta varchar(255) not null, tipo_conta varchar(255) not null, id_agencia bigint not null, id_cliente bigint not null, primary key (id_conta)) engine=MyISAM;
create table tb_enderecos (id_endereco bigint not null auto_increment, bairro varchar(45), cep varchar(10), cidade varchar(100), complemento varchar(100), estado varchar(100), logradouro varchar(100), numero varchar(10), primary key (id_endereco)) engine=MyISAM;
create table tb_gerentes (id_gerente bigint not null auto_increment, cpf varchar(15), email varchar(50), nome varchar(255), telefone varchar(20), id_endereco bigint not null, primary key (id_gerente)) engine=MyISAM;
create table tb_movimentacoes (id_movimentacao bigint not null auto_increment, data_movimentacao datetime, tipo varchar(255) not null, valor_transacao decimal(19,2) not null, id_conta_destino bigint not null, id_conta_origem bigint not null, primary key (id_movimentacao)) engine=MyISAM;

alter table tb_clientes add constraint UK_UNIQUE_CPF unique (cpf);
alter table tb_clientes add constraint UK_UNIQUE_EMAIL unique (email);
alter table tb_clientes add constraint UK_UNIQUE_TELEFONE unique (telefone);
alter table tb_contas add constraint UK_UNIQUE_NUMERO_CONTA unique (numero_da_conta);
alter table tb_gerentes add constraint UK_UNIQUE_GERENTE_CPF unique (cpf);
alter table tb_gerentes add constraint UK_UNIQUE_GERENTE_EMAIL unique (email);
alter table tb_gerentes add constraint UK_UNIQUE_GERENTE_TELEFONE unique (telefone);
alter table tb_agencias add constraint FK_AGENCIA_GERENTE_ID foreign key (id_gerente) references tb_gerentes (id_gerente);
alter table tb_clientes add constraint FK_ENDERECO_ID foreign key (id_endereco) references tb_enderecos (id_endereco);
alter table tb_contas add constraint FK_AGENCIA_ID foreign key (id_agencia) references tb_agencias (id_agencia);
alter table tb_contas add constraint FK_cONTA_CLIENTE_ID foreign key (id_cliente) references tb_clientes (id_cliente);
alter table tb_gerentes add constraint FK_GERENTE_ENDERECO_ID foreign key (id_endereco) references tb_enderecos (id_endereco);
alter table tb_movimentacoes add constraint FK_MOV_CONTA_DESTINO_ID foreign key (id_conta_destino) references tb_contas (id_conta);
alter table tb_movimentacoes add constraint FK_MOV_CONTA_ORIGEM_ID foreign key (id_conta_origem) references tb_contas (id_conta);

INSERT INTO tb_enderecos (id_endereco, bairro, cep, numero, cidade, complemento, estado, logradouro) 
VALUES (1, 'Jardim Camila', '08720540', '15', 'Mogi das Cruzes', '', 'SP', 'Rua das flores');
INSERT INTO tb_enderecos (id_endereco, bairro, cep, numero, cidade, complemento, estado, logradouro) 
VALUES (2, 'Bairro dos Bobos', '08710230', '0', 'Cidade dos Bobos', '', 'SP', 'Rua dos bobos');

INSERT INTO tb_clientes (id_cliente, cpf, data_nascimento, email, nome, telefone, id_endereco) 
VALUES (1, '11637346085', DATE('1993-06-15'), 'jenifer@email.com', 'Jenifer Placido', '11943929756', '1');
INSERT INTO tb_clientes (id_cliente, cpf, data_nascimento, email, nome, telefone, id_endereco) 
VALUES (2, '55721837098',  DATE('1995-06-15'), 'ana@email.com', 'Ana Cristina', '11994398497', '2');

INSERT INTO tb_gerentes (id_gerente, cpf, nome, telefone, id_endereco) 
VALUES (1, '72847519084', 'Beatriz Maria', '1198875483', 1);
INSERT INTO tb_gerentes (id_gerente, cpf, nome, telefone, id_endereco) 
VALUES (2, '89300361040', 'Gean Carlos', '119587966', 1);

INSERT INTO tb_agencias (id_agencia, nome_agencia, numero_agencia, id_gerente) 
VALUES (1, 'Agencia Suzano', '1234567890', 1);
INSERT INTO tb_agencias (id_agencia, nome_agencia, numero_agencia, id_gerente) 
VALUES (2, 'Agencia Paranaçu', '9876543210', 1);

INSERT INTO tb_contas (id_conta, data_abertura, numero_da_conta, saldo, tipo_conta, status_conta, id_agencia, id_cliente) 
VALUES (1, DATE('2021-10-22 16:00:22'), '1234567890', '20000.0', 'SALARIO', 'ATIVADO', 1, 1);
INSERT INTO tb_contas (id_conta, data_abertura, numero_da_conta, saldo, tipo_conta, status_conta, id_agencia, id_cliente) 
VALUES (2, DATE('2021-11-25 12:30:00'), '0987654321', '10000.0', 'CORRENTE', 'ATIVADO', 1, 2);
INSERT INTO tb_contas (id_conta, data_abertura, numero_da_conta, saldo, tipo_conta, status_conta, id_agencia, id_cliente) 
VALUES (3, DATE('2021-11-25 12:30:00'), '1569875475', '10000.0', 'SALARIO', 'DESATIVADO', 1, 1);

INSERT INTO tb_movimentacoes (id_movimentacao, data_movimentacao, tipo, valor_transacao, id_conta_destino, id_conta_origem) 
VALUES (1, TIMESTAMP('2021-11-29',  '18:30:00'), 'TRANSFERENCIA', '5000.0', 1, 2);
INSERT INTO tb_movimentacoes (id_movimentacao, data_movimentacao, tipo, valor_transacao, id_conta_destino, id_conta_origem) 
VALUES (2, TIMESTAMP('2021-11-02', '19:30:00'), 'TRANSFERENCIA', '3000.0', 2, 1);
INSERT INTO tb_movimentacoes (id_movimentacao, data_movimentacao, tipo, valor_transacao, id_conta_destino, id_conta_origem) 
VALUES (3, TIMESTAMP('2021-11-30', '18:30:00'), 'SAQUE', '500.0', 1, 1);
INSERT INTO tb_movimentacoes (id_movimentacao, data_movimentacao, tipo, valor_transacao, id_conta_destino, id_conta_origem) 
VALUES (4, TIMESTAMP('2021-11-30', '19:30:00'), 'DEPOSITO', '3000.0', 1, 1);
