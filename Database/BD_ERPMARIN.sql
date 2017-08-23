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

ALTER TABLE lancamento ADD FOREIGN KEY (id_produto) REFERENCES produto(id);

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
