CREATE TABLE entregador_tb (
    entregador_id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    cpf VARCHAR(15) NOT NULL UNIQUE,
    telefone VARCHAR(15) NOT NULL,
    meio_de_transporte VARCHAR(50) NOT NULL,
    disponivel BOOLEAN NOT NULL,
    localizacao_atual VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);