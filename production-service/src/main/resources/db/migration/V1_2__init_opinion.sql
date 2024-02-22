CREATE TABLE IF NOT EXISTS opinion
(
    id                        SERIAL                PRIMARY KEY,
    comment                   TEXT,
    score                     INT                   NOT NULL,
    issued_at                 TIMESTAMP             NOT NULL,
    product_number            VARCHAR(64)           NOT NULL,
    CONSTRAINT fk_opinion_product
        FOREIGN KEY (product_number)
            REFERENCES product (product_number)
);