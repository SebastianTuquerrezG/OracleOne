CREATE DATABASE control_de_stock;

USE control_de_stock;

CREATE TABLE producto(
    id_producto INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    PRIMARY KEY(id_producto)
);

INSERT INTO producto(nombre, descripcion, precio, stock) VALUES('Mesa', '4 lugares', 100.00, 10);
INSERT INTO producto(nombre, descripcion, precio, stock) VALUES('Celular', 'Samsung', 20.00, 20);

SELECT * FROM producto;

show processlist ;