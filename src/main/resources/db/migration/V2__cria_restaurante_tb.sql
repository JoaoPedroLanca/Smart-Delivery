CREATE TABLE restaurante_tb (
    restaurante_id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cnpj VARCHAR(20) NOT NULL UNIQUE,
    endereco VARCHAR(255) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    aberto BOOLEAN NOT NULL,
    horario_abertura TIMESTAMP NOT NULL,
    horario_fechamento TIMESTAMP NOT NULL
);