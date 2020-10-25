USE cupcake;
CREATE TABLE tops (
top_id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(15),
price INT,
PRIMARY KEY ( top_id )
);
INSERT INTO tops (name,price)
VALUES ("Chocolate",5);
INSERT INTO tops (name,price)
VALUES ("Blueberry",5);
INSERT INTO tops (name,price)
VALUES ("Raspberry",5);
INSERT INTO tops (name,price)
VALUES ("Crispy",6);
INSERT INTO tops (name,price)
VALUES ("Strawberry",6);
INSERT INTO tops (name,price)
VALUES ("Rum/Raisin",7);
INSERT INTO tops (name,price)
VALUES ("Orange",8);
INSERT INTO tops (name,price)
VALUES ("Lemon",8);
INSERT INTO tops (name,price)
VALUES ("Blue cheese",9);