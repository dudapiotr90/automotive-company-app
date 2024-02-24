INSERT INTO orders
(
    order_id,
    order_number,
    issued_date_time,
    realized_date_time,
    comment,
    customer_code,
    status,
    cancel_till
) VALUES
(
    1,
    'randomordernumber1',
    '2024-01-05 11:12:11',
    '2024-02-01 07:32:46',
    'some customer request regarding order',
    14596821,
    'REALIZED',
    '2024-01-07 11:12:11'
),
(
    2,
    'randomordernumber2',
    '2024-02-12 11:12:11',
    '2024-02-22 07:32:46',
    'some customer request regarding another order',
    6482164,
    'REALIZED',
    '2024-02-14 00:12:11'
),
(
    3,
    'randomordernumber3',
    '2024-01-05 11:12:11',
    '2024-02-01 07:32:46',
    'some customer request regarding order nr 3',
    3478421,
    'REALIZED',
    '2024-01-07 11:12:11'
),
(
    4,
    'randomordernumber4',
    '2024-01-05 11:12:11',
    '2024-02-01 07:32:46',
    'some customer request regarding order nr 4',
    14596821,
    'IN_PROGRESS',
    '2024-01-07 11:12:11'
),
(
    5,
    'randomordernumber5',
    '2024-02-01 11:12:11',
    '2024-02-21 07:32:46',
    'some customer request regarding order nr 5',
    3478421,
    'ISSUED',
    '2024-02-05 11:12:11'
);


INSERT INTO order_item
(
    order_item_id,
    quantity,
    product_code,
    order_number
) VALUES
(
    1,
    10,
    '123343534534',
    'randomordernumber1'
),
(
    2,
    14,
    'fgdsgsd234234t',
    'randomordernumber1'
),
(
    3,
    6,
    'sdhdju542342',
    'randomordernumber1'
),
(
    4,
    234,
    'dfhdfj324234',
    'randomordernumber2'
),
(
    5,
    2541,
    'fgdsgsd234234t',
    'randomordernumber2'
),
(
    6,
    5423,
    'gfdjhjk6546456',
    'randomordernumber3'
),
(
    7,
    456,
    'fgkhjkjhk423423423',
    'randomordernumber4'
),
(
    8,
    16,
    'jkfsdfg12454u7jgs',
    'randomordernumber5'
);