CREATE TABLE parcela (
     id                        INT           NOT NULL,
     numeroParcela             INT           NOT NULL,
     valorParcela              FLOAT
);

CREATE TABLE produto (
     id                        INT           NOT NULL,
     nome                      VARCHAR(40)   NOT NULL,
     descricao                 VARCHAR(300),
     fotoUrl                   VARCHAR(1000),
     precoAntigo               FLOAT,
     preco                     FLOAT,
     parcela_id                INT           NOT NULL
);