INSERT INTO product
(
    id,
    product_name,
    product_code,
    price,
    available,
    in_production,
    description,
    creation_date,
    designer_code,
    average_opinion
) VALUES
(
    1,
    'damper',
    '123343534534',
    4435.31,
    TRUE,
    TRUE,
    'some product 1 description',
    '2024-01-07 11:12:11',
    2133542,
    4
),
(
    2,
    'damper',
    'fgdsgsd234234t',
    4435.31,
    FALSE,
    TRUE,
    'some product 2 description',
    '2024-01-06 11:12:11',
    1231235,
    5
),
(
    3,
    'damper',
    'sdhdju542342',
    4435.31,
    FALSE,
    TRUE,
    'some product 3 description',
    '2024-01-05 11:12:11',
    8768666,
    3
),
(
    4,
    'damper',
    'dfhdfj324234',
    4435.31,
    TRUE,
    FALSE,
    'some product 4 description',
    '2024-01-04 11:12:11',
    8768666,
    2
),
(
    5,
    'damper',
    'hgdjsgsd235234t',
    4435.31,
    TRUE,
    TRUE,
    'some product 5 description',
    '2024-01-03 11:12:11',
    8768666,
    4
),
(
    6,
    'damper',
    'gfdjhjk6546456',
    4435.31,
    TRUE,
    TRUE,
    'some product 6 description',
    '2024-01-02 09:12:11',
    2133542,
    5
),
(
    7,
    'damper',
    'fgkhjkjhk423423423',
    4435.31,
    TRUE,
    TRUE,
    'some product 7 description',
    '2024-01-01 11:15:11',
    1231235,
    4
),
(
    8,
    'damper',
    'jkfsdfg12454u7jgs',
    4435.31,
    FALSE,
    FALSE,
    'some product 8 description',
    '2024-01-02 11:12:11',
    2133542,
    4
);


INSERT INTO opinion
(
    id,
    comment,
    score,
    issued_at,
    product_code
) VALUES
(
    1,
    'some opinion 1',
    5,
    '2024-02-05 11:12:11',
    '123343534534'
),
(
    2,
    'some opinion 2',
    3,
    '2024-02-06 12:12:11',
    '123343534534'
),
(
    3,
    'some opinion 3',
    5,
    '2024-02-05 11:12:11',
    'fgdsgsd234234t'
),
(
    4,
    'some opinion 4',
    3,
    '2024-02-05 11:12:11',
    'sdhdju542342'
),
(
    5,
    'some opinion 5',
    3,
    '2024-02-05 11:12:11',
    'sdhdju542342'
),
(
    6,
    'some opinion 6',
    2,
    '2024-02-05 11:12:11',
    'dfhdfj324234'
),
(
    7,
    'some opinion 7',
    3,
    '2024-02-05 11:12:11',
    'dfhdfj324234'
),
(
    8,
    'some opinion 8',
    1,
    '2024-02-05 11:12:11',
    'dfhdfj324234'
),
(
    9,
    'some opinion 9',
    4,
    '2024-02-05 11:12:11',
    'jkfsdfg12454u7jgs'
),
(
    10,
    'some opinion 10',
    5,
    '2024-02-15 11:12:11',
    'fgdsgsd234234t'
),
(
    11,
    'some opinion 11',
    5,
    '2024-01-05 11:12:11',
    'fgdsgsd234234t'
);