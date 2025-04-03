CREATE TABLE if NOT EXISTS payment (
    id                  serial              PRIMARY KEY,
    order_value         DOUBLE PRECISION    NOT NULL,
    number              VARCHAR(255)        NOT NULL,
    cvv                 INT                 NOT NULL,
    name_on_card        VARCHAR(255)        NOT NULL,
    expiration_date     VARCHAR(255)        NOT NULL,
    payment_request_id  VARCHAR(255)        NOT NULL
);