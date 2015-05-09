BEGIN;

CREATE TABLE customer(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    address VARCHAR(100),
    discount NUMERIC(5,2) DEFAULT 0 NOT NULL
);
CREATE TABLE product(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(45) NOT NULL,
    code VARCHAR(6) NOT NULL
);
CREATE TABLE mainOrder(
    id SERIAL PRIMARY KEY NOT NULL,
    date TIMESTAMP DEFAULT now() NOT NULL,
    customerid integer NOT NULL REFERENCES customer(id) ON DELETE RESTRICT
);
CREATE TABLE orderePproduct(
    id SERIAL PRIMARY KEY NOT NULL,
    orderid integer NOT NULL REFERENCES mainOrder(id) ON DELETE RESTRICT,
    productid integer NOT NULL REFERENCES product(id) ON DELETE RESTRICT,
    count NUMERIC(5,2) DEFAULT 1 NOT NULL,
    price NUMERIC(5,2) NOT NULL
);

INSERT INTO customer (name, lastname, address, discount)  VALUES ('Ivan', 'Ivanov', 'adress 1', 12.00);
INSERT INTO customer (name, lastname, address, discount)  VALUES ('Petr', 'Petrov', 'adress 2', 2.00);
INSERT INTO customer (name, lastname, address, discount)  VALUES ('Adam', 'Koval', 'adress 3', 3.5);
INSERT INTO customer (name, lastname, address, discount)  VALUES ('Murat', 'Irih', 'adress 4', 6.22);

INSERT INTO product (name, code)  VALUES ('product1', '111111');
INSERT INTO product (name, code)  VALUES ('product2', '222222');
INSERT INTO product (name, code)  VALUES ('product3', '333333');
INSERT INTO product (name, code)  VALUES ('product4', '444444');
INSERT INTO product (name, code)  VALUES ('product5', '555555');

INSERT INTO mainOrder (customerid)  VALUES (1);
INSERT INTO mainOrder (customerid)  VALUES (1);
INSERT INTO mainOrder (customerid)  VALUES (1);
INSERT INTO mainOrder (customerid)  VALUES (2);
INSERT INTO mainOrder (customerid)  VALUES (2);
INSERT INTO mainOrder (customerid)  VALUES (3);

-- mainOrder 1
INSERT INTO orderedproduct (orderid, productid, count, price)  VALUES (1, 1, 10, 95.90);
INSERT INTO orderedproduct (orderid, productid, count, price)  VALUES (1, 2, 3, 7);
INSERT INTO orderedproduct (orderid, productid, count, price)  VALUES (1, 3, 5, 9.50);

-- mainOrder 2
INSERT INTO orderedproduct (orderid, productid, count, price)  VALUES (2, 3, 10, 6.70);

-- mainOrder 3
INSERT INTO orderedproduct (orderid, productid, count, price)  VALUES (3, 1, 10, 96.70);
INSERT INTO orderedproduct (orderid, productid, count, price)  VALUES (3, 2, 80, 44.70);
INSERT INTO orderedproduct (orderid, productid, count, price)  VALUES (3, 3, 1, 2.20);
INSERT INTO orderedproduct (orderid, productid, count, price)  VALUES (3, 4, 35, 1.1);

-- mainOrder 4
INSERT INTO orderedproduct (orderid, productid, count, price)  VALUES (4, 2, 2, 9.80);
INSERT INTO orderedproduct (orderid, productid, count, price)  VALUES (4, 5, 3, 4.40);

-- mainOrder 5
INSERT INTO orderedproduct (orderid, productid, count, price)  VALUES (5, 5, 100, 19.45);

-- mainOrder 6
INSERT INTO orderedproduct (orderid, productid, count, price)  VALUES (6, 4, 50, 1.30);

COMMIT;

