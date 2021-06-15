CREATE DATABASE PROJETO_COVID
USE PROJETO_COVID;

CREATE TABLE PERSON_PROFILE(
	ID INT NOT NULL AUTO_INCREMENT,	
	CODIGO VARCHAR(6),
    DESCRICAO VARCHAR(24),
	PRIMARY KEY (ID)
);

CREATE TABLE PEOPLE (
	ID INT NOT NULL AUTO_INCREMENT,
	CPF VARCHAR(11) ,
    NOME VARCHAR(30) ,
    IDADE INT,
    EMAIL VARCHAR(30),
    PASSWORD VARCHAR(10000),
    ENDERECO VARCHAR(100),
    NUMERO INT,
    ESTADO VARCHAR(50),
    CIDADE  VARCHAR(50),
    BAIRRO VARCHAR (100),
    CEP INT,
    DATA_DE_VACINACAO DATE,
    CARGO_AREA_PUBLICA BIT(1), 
    ID_PERFIL INT,
    NIVEL_DE_PRIORIDADE INT,
    PRIMARY KEY (ID),
    FOREIGN KEY (ID_PERFIL) REFERENCES PERSON_PROFILE(ID)
);
    

    