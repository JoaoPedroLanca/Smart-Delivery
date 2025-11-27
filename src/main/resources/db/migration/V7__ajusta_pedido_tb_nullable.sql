ALTER TABLE pedido_tb
    ALTER COLUMN entregador_id DROP NOT NULL;

ALTER TABLE pedido_tb
    ALTER COLUMN distancia DROP NOT NULL;

ALTER TABLE pedido_tb
    ALTER COLUMN tempo_estimado_de_entrega DROP NOT NULL;

