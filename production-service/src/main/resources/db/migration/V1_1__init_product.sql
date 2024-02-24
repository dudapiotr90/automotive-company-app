CREATE TABLE IF NOT EXISTS product
(
    id                                      SERIAL                          PRIMARY KEY,
    product_name                            VARCHAR(64)                     NOT NULL,
    product_code                          VARCHAR(64)                     NOT NULL        UNIQUE,
    price                                   NUMERIC(7,2)                    NOT NULL,
    available                               BOOLEAN                         NOT NULL,
    in_production                           BOOLEAN                         NOT NULL,
    description                             TEXT,
    creation_date                           TIMESTAMP                       NOT NULL,
    designer_code                           int                             NOT NULL,
    average_opinion                         int
);