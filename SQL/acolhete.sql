create database if not exists acolheTeste;
use acolheTeste;

create table if not exists  usuario(
	id bigint unsigned primary key auto_increment,
    nomeCompleto varchar(200) not null,
    cpf varchar(14) not null, -- 123.456.789-09
    dataNasc date not null,
    celular varchar(14) not null, -- (11)99999-9999
    email varchar(100) not null,
    senha varchar(100) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
    
create table if not exists Empresa(
	id bigint unsigned primary key auto_increment,
    nome varchar(200) not null,
    cnpj varchar(20) not null,
    dataAbertura date not null,
    celular varchar(14) not null,
    email varchar(100) not null,
    senha varchar(100) not null
);

create table if not exists vaga(
	id bigint unsigned primary key auto_increment,
    nome varchar(200) not null,
	email varchar(100) not null,
    telefone varchar(14) not null,
    tipo varchar(100) not null,
    modalidade varchar(255) not null,
    endereco varchar(255) not null,
    descricao varchar(1000),
    empresa bigint unsigned,
    foreign key (empresa) references Empresa(id) 
        on delete cascade 
        on update cascade
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
