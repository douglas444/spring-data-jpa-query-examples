INSERT INTO `product` (id, title, price, code) VALUES (1, 'Nintendo Switch', 1899.99, 'SWITCH');
INSERT INTO `product` (id, title, price, code) VALUES (2, 'PlayStation 5', 3999.99, 'PS5');
INSERT INTO `product` (id, title, price, code) VALUES (3, 'XBOX One', 2899.99, 'XBOX');

INSERT INTO `customer` (id, email, active) VALUES (1, 'maria@gmail.com', TRUE);
INSERT INTO `customer` (id, email, active) VALUES (2, 'joao@gmail.com', TRUE);

INSERT INTO `order` (id, product_id, customer_id) VALUES (1, 1, 1);
INSERT INTO `order` (id, product_id, customer_id) VALUES (2, 1, 1);
INSERT INTO `order` (id, product_id, customer_id) VALUES (3, 2, 2);
