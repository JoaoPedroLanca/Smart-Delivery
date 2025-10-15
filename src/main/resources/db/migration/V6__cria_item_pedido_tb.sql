CREATE TABLE item_pedido_tb (
    item_id SERIAL PRIMARY KEY,
    quantidade INT NOT NULL,
    preco_unitario NUMERIC(10,2) NOT NULL,
    pedido_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,

    CONSTRAINT fk_item_pedido
        FOREIGN KEY (pedido_id)
        REFERENCES pedido_tb (pedido_id)
        ON DELETE CASCADE,

    CONSTRAINT fk_item_produto
        FOREIGN KEY (produto_id)
        REFERENCES cardapio_tb (produto_id)
        ON DELETE CASCADE
);