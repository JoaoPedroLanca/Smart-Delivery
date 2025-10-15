CREATE TABLE cardapio_tb (
    produto_id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco NUMERIC(10,2) NOT NULL,
    disponivel BOOLEAN NOT NULL,
    restaurante_id BIGINT NOT NULL,
    CONSTRAINT fk_cardapio_restaurante
        FOREIGN KEY (restaurante_id)
        REFERENCES restaurante_tb (restaurante_id)
        ON DELETE CASCADE
);