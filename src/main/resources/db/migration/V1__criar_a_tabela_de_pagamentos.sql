CREATE SEQUENCE pagamentos_seq start with 1 increment by 1;

CREATE TABLE pagamentos (
    id BIGINT PRIMARY KEY DEFAULT  nextval('pagamentos_seq'),
    valor DECIMAL(19, 2) NOT NULL ,
    nome VARCHAR(100) NOT NULL ,
    numero VARCHAR(19) NOT NULL ,
    expiracao VARCHAR(7) NOT NULL ,
    codigo CHAR(3) NOT NULL ,
    status VARCHAR(255) NOT NULL,
    pedido_id BIGINT NOT NULL ,
    forma_pagamento_id BIGINT NOT NULL
);