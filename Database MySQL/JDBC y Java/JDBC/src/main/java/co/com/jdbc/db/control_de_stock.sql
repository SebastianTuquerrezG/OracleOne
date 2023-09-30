CREATE DATABASE control_de_stock;

USE control_de_stock;

DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS producto;

CREATE TABLE producto(
    id_producto INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    id_categoria INT NOT NULL,
    PRIMARY KEY(id_producto),
    FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria)
);

INSERT INTO producto(nombre, descripcion, precio, stock, id_categoria) VALUES('Mesa', '4 lugares', 100.00, 10, 1);
INSERT INTO producto(nombre, descripcion, precio, stock, id_categoria) VALUES('Celular', 'Samsung', 20.00, 20, 3);

SELECT * FROM producto;

CREATE TABLE categoria(
    id_categoria INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_categoria)
);

INSERT INTO categoria(nombre) VALUES('Muebles'), ('Electrodomesticos'), ('Tecnologia'), ('Hogar');

ALTER TABLE producto ADD COLUMN id_categoria INT NOT NULL;
ALTER TABLE producto ADD FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria);