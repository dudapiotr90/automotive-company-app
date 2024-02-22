INSERT INTO issuer(
    issuer_id,
    full_name,
    email
) VALUES
(
    1,
    'Jan Nowak',
    'jannowak@mail.com'
),
(
    2,
    'Anna Kowalska',
    'annakowalska@mail.com'
),
(
    3,
    'John Cena',
    'johncena@mail.com'
);

INSERT INTO invoice(
    id,
    customer_email,
    issued_at,
    completed,
    order_number,
    invoice_number,
    all_items,
    total_amount,
    issuer_id
) VALUES
(
    1,
    'dpiterd@gmail.com',
    '2024-01-05 11:12:11',
    '2024-02-01 07:32:46',
    'randomordernumber1',
    'INV_14596821_01/02/2024',
    145,
    133574.55,
    1
),
(
    2,
    'somefakemail@mail.com',
    '2024-01-01 12:42:21',
    '2024-01-06 08:38:56',
    'randomordernumber2',
    'INV_6482164_06/01/2024',
    53,
    13574.55,
    2
),
(
    3,
    'dudapiotr90@gmail.com',
    '2024-02-06 04:52:21',
    '2024-02-20 16:18:56',
    'randomordernumber3',
    'INV_6482164_06/01/2024',
    443,
    1113574.55,
    1
);