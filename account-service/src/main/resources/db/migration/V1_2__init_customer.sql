CREATE TABLE customer
(
    customer_id         SERIAL          NOT NULL,
    full_name           varchar(64)     NOT NULL,
    customer_code       int             NOT NULL    UNIQUE,
    account_id          int,
    PRIMARY KEY (customer_id),
    CONSTRAINT fk_customer_account
        FOREIGN KEY (account_id)
            REFERENCES account (account_id)
);