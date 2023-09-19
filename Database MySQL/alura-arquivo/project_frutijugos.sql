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

INSERT INTO `CLIENT` (`ID_CARD`, `NAME`, `ADDRESS_1`, `ADDRESS_2`, `NEIGHBORHOOD`, `CITY`, `STATE`, `POSTAL_CODE`, `BIRTHDAY_DATE`, `AGE`, `GENRE`, `CREDIT_LIMIT`, `VOLUME_BUY`, `FIRST_BUY`) VALUES
	('9283760794', 'Edson Calisaya', 'Sta Úrsula Xitla', 'no aplica', 'Barrio del Niño Jesús', 'Ciudad de México', 'CDMX', '22002002', '1995-10-07', '25', 'M', '150000', '250000', 1),
	('7771579779', 'Marcelo Perez', 'F.C. de Cuernavaca 13', 'no aplica', 'Carola', 'Ciudad de México', 'CDMX', '88202912', '1992-03-25', '29', 'M', '120000', '200000', 1),
	('5576228758', 'Pedro Olivera', 'Pachuca 75', 'no aplica', 'Condesa', 'Ciudad de México', 'CDMX', '88192029', '1995-11-14', '25', 'F', '70000', '160000', 1),
	('8502682733', 'Luis Silva', 'Prol. 16 de Septiembre 1156', 'no aplica', 'Contadero', 'Ciudad de México', 'CDMX', '82122020', '1995-10-07', '25', 'M', '110000', '190000', 0),
	('1471156710', 'Erica Carvajo', 'Heriberto Frías 1107', 'no aplica', 'Del Valle', 'Ciudad de México', 'CDMX', '80012212', '1990-09-01', '30', 'F', '170000', '245000', 0),
	('3623344710', 'Marcos Rosas', 'Av. Universidad', 'no aplica', 'Del Valle', 'Ciudad de México', 'CDMX', '22002012', '1995-01-13', '26', 'M', '110000', '220000', 1),
	('50534475787', 'Abel Pintos', 'Carr. México-Toluca 1499', 'no aplica', 'Cuajimalpa', 'Ciudad de México', 'CDMX', '22000212', '1995-09-11', '25', 'M', '170000', '260000', 0),
	('5840119709', 'Gabriel Roca', 'Eje Central Lázaro Cárdenas 911', 'no aplica', 'Del Valle', 'Ciudad de México', 'CDMX', '80010221', '1985-03-16', '36', 'M', '140000', '210000', 1),
	('94387575700', 'Walter Soruco', 'Calz. de Tlalpan 2980', 'no aplica', 'Ex Hacienda Coapa', 'Ciudad de México', 'CDMX', '22000201', '1989-06-20', '31', 'M', '60000', '120000', 1),
	('8719655770', 'Carlos Santivañez', 'Calz. del Hueso 363', 'no aplica', 'Floresta Coyoacán', 'Ciudad de México', 'CDMX', '81192002', '1983-12-20', '37', 'M', '200000', '240000', 0),
	('5648641702', 'Paolo Mendez', 'Martires de Tacubaya 65', 'no aplica', 'Héroes de Padierna', 'Ciudad de México', 'CDMX', '21002020', '1991-08-30', '29', 'M', '120000', '220000', 0),
	('492472718', 'Jorge Castro', 'Federal México-Toluca 5690', 'no aplica', 'Locaxco', 'Ciudad de México', 'CDMX', '22012002', '1994-07-19', '26', 'M', '75000', '95000', 1);

SELECT NAME AS NOMBRE FROM CLIENT LIMIT 6;

