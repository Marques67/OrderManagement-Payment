CREATE TABLE if NOT EXISTS payment (
    id                  serial              PRIMARY KEY,
    order_value         DOUBLE PRECISION    NOT NULL,
    payment_type        VARCHAR(255)        NOT NULL,
    number              VARCHAR(255),
    cvv                 INT,
    name_on_card        VARCHAR(255),
    expiration_date     VARCHAR(255),
    card_type           VARCHAR(255),
    payment_request_id  VARCHAR(255)
);