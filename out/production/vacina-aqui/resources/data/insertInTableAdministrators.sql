USE  PROJETO_COVID;

INSERT INTO PERSON_PROFILE(
CODIGO,
DESCRICAO
)VALUES('ADM', 'Administrador');

INSERT INTO PERSON_PROFILE(
CODIGO,
DESCRICAO
)VALUES('ATT', 'Atendente');

INSERT INTO PERSON_PROFILE(
CODIGO,
DESCRICAO
)VALUES('P', 'Paciente');


INSERT INTO PEOPLE(
	CPF,
    NOME,
    IDADE,
    EMAIL,
    PASSWORD,
    ENDERECO,
    NUMERO,
    ESTADO,
    CIDADE ,
    BAIRRO,
    CEP,
    DATA_DE_VACINACAO,
    CARGO_AREA_PUBLICA, 
    ID_PERFIL,
    NIVEL_DE_PRIORIDADE
)VALUES(
	'22848289208',
	'Levi Melo dos Santos',
	20,
	'Levi.Melo@outlook.com.br',
	'QXp4czEyMzA=',
	'Avenida Paulista',
	123,
	'SP',
	'osasco',
	'Jardim Novo Horizonte',
	22389021,
	null,
	null,
	1,
	3);

