create database frutijugos;

USE frutijugos;

DROP TABLE client;
DROP TABLE product;

CREATE TABLE client(
  ID INT AUTO_INCREMENT,
  id_card VARCHAR(150) NOT NULL,
  name VARCHAR(150) NOT NULL,
  address_1 VARCHAR(150) NOT NULL,
  address_2 VARCHAR(150) NOT NULL,
  neighborhood VARCHAR(50) NOT NULL,
  city VARCHAR(50) NOT NULL,
  state VARCHAR(50) NOT NULL,
  postal_code VARCHAR(10) NOT NULL,
  age SMALLINT NOT NULL,
  genre VARCHAR(1) NOT NULL,
  credit_limit FLOAT NOT NULL,
  volume_buy FLOAT NOT NULL,
  first_buy BIT(1) NOT NULL,
  constraint client_pk
      primary key (ID)
);

create table product
(
    ID        INT auto_increment,
    name      VARCHAR(100) not null,
    container VARCHAR(100) not null,
    volume    VARCHAR(50)  not null,
    flavor    VARCHAR(50)  not null,
    price     FLOAT        not null,
    constraint product_pk
        primary key (ID)
);


INSERT INTO `PRODUCT` (`NAME`, `CONTAINER`, `VOLUME`, `FLAVOR`, `PRICE`) VALUES
	('Clean', 'Botella PET', '1 Litro', 'Naranja', '8.01'),
	('Clean', 'Botella PET', '1,5 Litros', 'Naranja', '12.01'),
	('Clean', 'Botella PET', '2 Litros', 'Naranja', '16.01'),
	('Clean', 'Lata', '350 ml', 'Naranja', '2.81'),
	('Clean', 'Botella de Vidrio', '470 ml', 'Naranja', '3.77'),
	('Festival de Sabores', 'Botella PET', '1,5 Litros', 'Asaí', '28.51'),
	('Festival de Sabores', 'Botella PET', '1,5 Litros', 'Maracuyá', '10.51'),
	('Festival de Sabores', 'Botella PET', '2 Litros', 'Asái', '38.01'),
	('Festival de Sabores', 'Botella de Vidrio', '700 ml', 'Asaí', '13.31'),
	('Festival de Sabores', 'Botella de Vidrio', '700 ml', 'Maracuyá', '4.91'),
	('Light', 'Botella PET', '1,5 Litros', 'Sandía', '19.51'),
	('Light', 'Lata', '350 ml', 'Sandía', '4.56'),
	('Línea Citrus', 'Botella PET', '1 Litro', 'Lima/Limón', '7.00'),
	('Línea Citrus', 'Botella de Vidrio', '700 ml', 'Lima/Limón', '4.90'),
	('Línea Citrus', 'Botella PET', '1 Litro', 'Limón', '7.00'),
	('Línea Citrus', 'Botella de Vidrio', '700 ml', 'Limón', '4.90'),
	('Pedazos de Frutas', 'Botella PET', '1 Litro', 'Manzana', '12.01'),
	('Pedazos de Frutas', 'Botella PET', '1,5 Litros', 'Manzana', '18.01'),
	('Pedazos de Frutas', 'Lata', '350 ml', 'Manzana', '4.21'),
	('Refrescante', 'Botella PET', '1 Litro', 'Mango', '11.01'),
	('Refrescante', 'Botella PET', '1 Litro', 'Frutilla/Limón', '9.01'),
	('Refrescante', 'Botella PET', '1,5 Litros', 'Mango', '16.51'),
	('Refrescante', 'Botella de Vidrio', '700 ml', 'Mango', '7.71'),
	('Refrescante', 'Botella de Vidrio', '700 ml', 'Frutilla/Limón', '6.31'),
	('Sabor da Montaña', 'Botella de Vidrio', '700 ml', 'Cereza', '8.41'),
	('Sabor da Montaña', 'Botella de Vidrio', '700 ml', 'Frutilla', '7.71'),
	('Sabor da Montaña', 'Botella de Vidrio', '700 ml', 'Uva', '6.31'),
	('Verano', 'Lata', '350 ml', 'Limón', '2.46'),
	('Verano', 'Lata', '350 ml', 'Mango', '3.86'),
	('Verano', 'Botella de Vidrio', '470 ml', 'Limón', '3.30'),
	('Verano', 'Botella de Vidrio', '470 ml', 'Mango', '5.18'),
	('Vida del Campo', 'Botella PET', '1,5 Litros', 'Sandía', '19.51'),
	('Vida del Campo', 'Botella de Vidrio', '700 ml', 'Cereza/Manzana', '8.41'),
	('Vida del Campo', 'Botella PET', '2 Litros', 'Cereza/Manzana', '24.01'),
	('Vida del Campo', 'Lata', '350 ml', 'Sandía', '4.56');

SELECT * FROM product;

UPDATE product SET container = 'Lata'
where volume = '350 ml';

DELETE FROM product WHERE ID = 23;

ALTER TABLE client ADD COLUMN (birthday_date  DATE);


