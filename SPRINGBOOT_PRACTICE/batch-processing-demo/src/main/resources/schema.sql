DROP TABLE IF EXISTS products;

CREATE TABLE products
(
    productId varchar(50) primary key,
    title varchar(200),
    description varchar(200),
    price varchar(10),
    discount varchar(10),
    discounted_price varchar(10)
);