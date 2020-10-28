  
DROP DATABASE IF EXISTS cupcake;
CREATE DATABASE cupcake;

SET GLOBAL time_zone = "+2:00";

DROP USER IF EXISTS 'cupcake'@'localhost';
CREATE USER 'cupcake'@'localhost' IDENTIFIED BY 'cupcake';
GRANT ALL ON *.* TO 'cupcake'@'localhost';