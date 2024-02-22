INSERT INTO account
(
account_id,
email,
login,
password,
role,
creation_date,
unlocked,
enabled
) VALUES
(
    13,
    'dpiterd@gmail.com',
    'dpiterd',
    '12345',
    'customer',
    '2024-02-22 12:00:00',
    true,
    true
),
(
    14,
    'somefakemail@mail.com',
    'fakecustomer',
    '11111',
    'customer',
    '2024-01-29 13:06:00',
    true,
    true
),
(
    15,
    'piotrjavatestowy@gmail.com',
    'piotrjava',
    '22222',
    'customer',
    '2024-01-05 09:22:11',
    true,
    true
);

INSERT INTO customer
(
customer_id,
full_name,
customer_code,
account_id
) VALUES
(
    6,
    'piotr duda',
    14596821,
    13
),
(
    7,
    'pawel pawloski',
    6482164,
    14
),
(
    8,
    'jan kowalski',
    3478421,
    15
);


