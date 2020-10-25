  
DROP DATABASE IF EXISTS cupcake;
CREATE DATABASE cupcake;

DROP USER IF EXISTS 'cupcake'@'localhost';
CREATE USER 'cupcake'@'localhost' IDENTIFIED BY 'cupcake';
GRANT ALL ON *.* TO 'cupcake'@'localhost';