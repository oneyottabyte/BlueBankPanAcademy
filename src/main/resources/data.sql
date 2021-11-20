
INSERT INTO tb_enderecos (id_endereco, bairro, cep, numero, cidade, complemento, estado, logradouro) 
VALUES (1, 'Jardim Camila', '08720540', '15', 'Mogi das Cruzes', '', 'SP', 'Rua das flores');
INSERT INTO tb_enderecos (id_endereco, bairro, cep, numero, cidade, complemento, estado, logradouro) 
VALUES (2, 'Bairro dos Bobos', '08710230', '0', 'Cidade dos Bobos', '', 'SP', 'Rua dos bobos');

INSERT INTO tb_clientes (id_cliente, cpf, data_nascimento, email, nome, telefone, id_endereco) 
VALUES (1, '11637346085', TO_DATE('17/12/1999', 'DD/MM/YYYY'), 'charles@email.com', 'Charles Coabra', '11943929756', '1');
INSERT INTO tb_clientes (id_cliente, cpf, data_nascimento, email, nome, telefone, id_endereco) 
VALUES (2, '55721837098', TO_DATE('11/02/1995', 'DD/MM/YYYY'), 'ana@email.com', 'Ana Cristina', '11994398497', '2');

INSERT INTO tb_gerentes (id_gerente, cpf, nome, telefone, id_endereco) 
VALUES (1, '72847519084', 'Carlos Betiol', '1198875483', 1);

INSERT INTO tb_agencias (id_agencia, nome_agencia, numero_agencia, id_gerente) 
VALUES (1, 'Agencia Suzano', '1234567890', 1);

INSERT INTO tb_contas (id_conta, data_abertura, numero_da_conta, saldo, tipo_conta, status_conta, id_agencia, id_cliente) 
VALUES (1, TO_DATE('11/03/2021', 'DD/MM/YYYY'), '1234567890', '20000.0', 'SALARIO', 'ATIVADO', 1, 1);
INSERT INTO tb_contas (id_conta, data_abertura, numero_da_conta, saldo, tipo_conta, status_conta, id_agencia, id_cliente) 
VALUES (2, TO_DATE('14/04/2021', 'DD/MM/YYYY'), '0987654321', '10000.0', 'SALARIO', 'DESATIVADO', 1, 2);

INSERT INTO tb_movimentacoes (id_movimentacao, data_movimentacao, tipo, valor_transacao, id_conta_destino, id_conta_origem) 
VALUES (1, TO_DATE('11/09/2021', 'DD/MM/YYYY'), 'TRANSFERENCIA', '5000.0', 1, 2);



