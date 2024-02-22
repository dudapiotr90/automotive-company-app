CREATE TABLE issuer
(
    issuer_id       SERIAL          NOT NULL,
    full_name       VARCHAR(32)     NOT NULL,
    email           VARCHAR(64)     NOT NULL,
    PRIMARY KEY (issuer_id)
);