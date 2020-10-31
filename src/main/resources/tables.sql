USE cupcake;

CREATE TABLE topping (
topping_id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(15),
price INT,
PRIMARY KEY ( topping_id )
);

CREATE TABLE bottom (
bottom_id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(15),
price INT,
PRIMARY KEY ( bottom_id )
);

CREATE TABLE customer (
customer_id INT NOT NULL AUTO_INCREMENT,
email VARCHAR(50),
role VARCHAR(10),
saldo INT,
salt BINARY(16),
secret BINARY(32),
PRIMARY KEY (customer_id));

CREATE TABLE ordre (
ordre_id INT NOT NULL AUTO_INCREMENT,
date DATE,
customer_id INT,
PRIMARY KEY (ordre_id),
FOREIGN KEY(customer_id) REFERENCES customer(customer_id));

CREATE TABLE ordrelinie (
ordrelinie_id INT NOT NULL AUTO_INCREMENT,
quantity INT,
sum INT,
ordre_id INT,
topping_id INT,
bottom_id INT,
PRIMARY KEY (ordrelinie_id),
FOREIGN KEY(ordre_id) REFERENCES ordre(ordre_id),
FOREIGN KEY(topping_id) REFERENCES topping(topping_id),
FOREIGN KEY(bottom_id) REFERENCES bottom(bottom_id));