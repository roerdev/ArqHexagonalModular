CREATE TABLE product 
(
    id        BIGINT       NOT NULL,
    name      VARCHAR(100) NOT NULL,
    salesunit BIGINT       NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE stock
(
    id      BIGINT  NOT NULL,
    product BIGINT  NOT NULL,
    size    CHAR(3) NOT NULL,
    stock   BIGINT  NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO
	product(id, name, salesunit)
VALUES
	(1, 'V-NECK BASIC SHIRT', 100);

INSERT INTO
	product(id, name, salesunit)
VALUES
	(2, 'CONTRASTING FABRIC T-SHIRT', 50);

INSERT INTO
	product(id, name, salesunit)
VALUES
	(3, 'RAISED PRINT T-SHIRT', 80);

INSERT INTO
	product(id, name, salesunit)
VALUES
	(4, 'PLEATED T-SHIRT', 3);

INSERT INTO
	product(id, name, salesunit)
VALUES
	(5, 'CONTRASTING LACE T-SHIRT', 650);

INSERT INTO
	product(id, name, salesunit)
VALUES
	(6, 'SLOGAN T-SHIRT', 20);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (1, 1, 'S', 4);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (2, 1, 'M', 9);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (3, 2, 'S', 35);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (4, 2, 'M', 9);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (5, 2, 'L', 9);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (6, 3, 'S', 20);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (7, 3, 'M', 2);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (8, 3, 'L', 20);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (9, 4, 'S', 25);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (10, 4, 'M', 30);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (11, 4, 'L', 10);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (12, 5, 'M', 1);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (13, 6, 'S', 9);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (14, 6, 'M', 2);

INSERT INTO
    stock(id, product, size, stock)
VALUES
    (15, 6, 'L', 5);
