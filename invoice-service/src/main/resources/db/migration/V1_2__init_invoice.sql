CREATE TABLE invoice
(
    id                      SERIAL                      NOT NULL,
    customer_email          VARCHAR(64)                 NOT NULL,
    issued_at               TIMESTAMP WITH TIME ZONE    NOT NULL,
    completed               TIMESTAMP WITH TIME ZONE    NOT NULL,
    order_number            VARCHAR(64)                 NOT NULL,
    invoice_number          VARCHAR(64)                 NOT NULL,
    all_items               NUMERIC(6,2)                NOT NULL,
    total_amount            NUMERIC(11,2)               NOT NULL,
    issuer_id               int                         NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_invoice_issuer
        FOREIGN KEY (issuer_id)
            REFERENCES issuer (issuer_id)
);