CREATE TABLE IF NOT EXISTS orders
(
    order_id                    SERIAL                          PRIMARY KEY,
    order_number                VARCHAR(128)                    NOT NULL            UNIQUE,
    issued_date_time            TIMESTAMP                       NOT NULL,
    realized_date_time          TIMESTAMP,
    comment                     TEXT,
    customer_code               int                             NOT NULL            UNIQUE,
    status                      VARCHAR(32)                     NOT NULL,
    cancel_till                 TIMESTAMP                       NOT NULL
);