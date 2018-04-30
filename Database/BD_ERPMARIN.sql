ERP MARIN DATABASE CREATOR



CREATE USER ERPMARIN_USER WITH PASSWORD '1234';
CREATE DATABASE ERPMARIN_DB WITH OWNER ERPMARIN_USER;



CREATE TABLE FINANCEIRO_CONTROLE(
	
id serial primary key,	
titular varchar(100),	
num_ficha integer,	
dataIN timestamp,	
dataOut timestamp,	
num_suite integer,	
diaria decimal(10,2),	
quiosque decimal(10,2),	
frigobar decimal(10,2),	
total decimal(10,2),	
cartao decimal(10,2),	
dinheiro decimal(10,2),	
adiantamento decimal(10,2),	
tipoCartao integer
);

create table produto(
	id serial primary key,
	nome varchar(50),
	preco decimal(10,2)
);

create table lancamento(
	id serial primary key,
	id_produto integer,
	quantidade integer,
	valor_total decimal(10,2),
	nome varchar(50),
	data_venda timestamp
);

create table lancamentoInterno(
	id serial primary key,
	id_produto integer,
	quantidade integer,
	valor_total decimal(10,2),
	nome varchar(50),
	data_venda timestamp
);



create table agenda (
	id serial primary key,
	nome varchar(50),
	telefone_fixo varchar(50),
	telefone_movel varchar(50)
);

create table faturamento_entrada (
	id serial primary key,
	valor decimal(10,2),
	data timestamp
);

create table faturamento_saida(
	id serial primary key,
	valor decimal(10,2),
	data timestamp
);

create table funcionario (
	id serial primary key,
	nome varchar(100),	
	tel1  varchar(100),	
	cargo varchar(100),
	salario decimal(10,2),
	extra decimal(10,2),
	valorFolga decimal(10,2),	
	data_admissao timestamp

);

create table folga_funcionario(
	id serial primary key,
	id_funcionario integer,
	data timestamp

);

create table fornecedor(
	id serial primary key,
	telefone varchar(20),
	nome varchar(70)
);

create table pedido(
	id serial primary key,
	id_fornecedor integer,
	descricao varchar(100),
	concluido boolean
);

create table manutencao(
	id serial primary key,
	descricao varchar(150),
	concluido boolean,
	data timestamp
);

create table porcao(
	id serial primary key,
	camarao integer,
	lula integer,
	isca integer,
	bolinho integer,
	casquinha integer,
	data timestamp
);	

create table bookingCard(
	id serial primary key,
	titular varchar(100),
	codReserva varchar(100),
	numCard varchar(100),
	validade varchar(100),
	codSeg varchar(10)
)

create table extra(
	id serial primary key,
	nome varchar(100),
	cargo varchar(100),
	obs varchar(255),
	valor decimal(10,2),
	data timestamp
);

ALTER TABLE pedido ADD FOREIGN KEY (id_fornecedor) REFERENCES fornecedor(id);
ALTER TABLE lancamento ADD FOREIGN KEY (id_produto) REFERENCES produto(id);
ALTER TABLE lancamentoInterno ADD FOREIGN KEY (id_produto) REFERENCES produto(id);
ALTER TABLE folga_funcionario ADD FOREIGN KEY (id_funcionario) REFERENCES funcionario(id);
TRUNCATE TABLE nome_tabela RESTART IDENTITY;
