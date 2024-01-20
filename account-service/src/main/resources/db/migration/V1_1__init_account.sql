CREATE TABLE account
(
    account_id      SERIAL                      NOT NULL,
    email           VARCHAR(64)                 NOT NULL    UNIQUE,
    login           VARCHAR(64)                 NOT NULL    UNIQUE,
    password        VARCHAR(256)                NOT NULL,
    role            VARCHAR(32)                 NOT NULL,
    creation_date   TIMESTAMP WITH TIME ZONE    NOT NULL,
    unlocked        BOOLEAN                     NOT NULL,
    enabled         BOOLEAN                     NOT NULL,
    PRIMARY KEY (account_id)
);