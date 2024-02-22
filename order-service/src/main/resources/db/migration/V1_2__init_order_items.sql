CREATE TABLE IF NOT EXISTS order_item
(
    order_item_id                   SERIAL              PRIMARY KEY,
    quantity                        int                 NOT NULL,
    product_code                    VARCHAR(64)         NOT NULL            UNIQUE,
    order_number                    VARCHAR(128)        NOT NULL,
    CONSTRAINT fk_order_item_order
        FOREIGN KEY (order_number)
            REFERENCES orders (order_number)
);