CREATE TABLE if NOT EXISTS payment (
    id                  serial          PRIMARY KEY,
    order_value         DOUBLE          NOT NULL,
    payment_type        VARCHAR(255)    NOT NULL,
    number              VARCHAR(255),
    cvv                 INT,
    name_on_card        VARCHAR(255),
    expiration_date     VARCHAR(255),
    card_type           VARCHAR(255),
    paymentRequestId    VARCHAR(255)
);