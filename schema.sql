DROP TABLE aluno;
DROP TABLE cidade;

CREATE TABLE cidade
(
    codigo INTEGER NOT NULL,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY (codigo)
);

CREATE TABLE aluno
(
    codigo INTEGER NOT NULL,
    nome VARCHAR(100) NOT NULL,
    ra VARCHAR(20) NOT NULL,
    cod_cidade INT NOT NULL,
    PRIMARY KEY (codigo),
    FOREIGN KEY (cod_cidade) REFERENCES cidade (codigo)
);


INSERT INTO cidade VALUES (1, "Cascavel");
INSERT INTO cidade VALUES (2, "Cafelândia");


INSERT INTO aluno VALUES (1, "Ana", 123456, 1);
INSERT INTO aluno VALUES (2, "Joao", 234567, 1);
INSERT INTO aluno VALUES (3, "Pedro", 654321, 2);


UPDATE aluno SET cod_cidade = 1 WHERE ra = 123456;