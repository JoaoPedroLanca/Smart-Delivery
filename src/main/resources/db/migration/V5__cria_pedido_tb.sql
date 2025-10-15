CREATE TABLE pedido_tb (
    pedido_id SERIAL PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    restaurante_id BIGINT NOT NULL,
    entregador_id BIGINT NOT NULL,
    total_do_pedido NUMERIC(10,2) NOT NULL,
    status_pedido VARCHAR(50) NOT NULL,
    ciracao_do_pedido TIMESTAMP NOT NULL,
    endereco_cliente VARCHAR(255) NOT NULL,
    distancia VARCHAR(50) NOT NULL,
    forma_de_pagamento VARCHAR(50) NOT NULL,
    tempo_estimado_de_entrega BIGINT NOT NULL,

    CONSTRAINT fk_pedido_cliente
        FOREIGN KEY (cliente_id)
        REFERENCES cliente_tb (cliente_id)
        ON DELETE CASCADE,

    CONSTRAINT fk_pedido_restaurante
        FOREIGN KEY (restaurante_id)
        REFERENCES restaurante_tb (restaurante_id)
        ON DELETE CASCADE,

    CONSTRAINT fk_pedido_entregador
        FOREIGN KEY (entregador_id)
        REFERENCES entregador_tb (entregador_id)
        ON DELETE SET NULL
);