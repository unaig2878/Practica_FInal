 create database bd_ejemplo;
CREATE TABLE clientes (
  telefono INT PRIMARY KEY,
  nombre VARCHAR(50) ,
  apellido VARCHAR(50) ,
  direccion VARCHAR(100) 
);



CREATE TABLE productos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100),
  precio DOUBLE,
  fecha_caducidad DATE,
  estado VARCHAR(50),
  cantidad INT,
  perecedero BOOLEAN,
  calorias FLOAT,
  vegano BOOLEAN,
  fecha_envase DATE,
  gaseoso BOOLEAN,
  lacteo BOOLEAN
);
ALTER TABLE productos
ADD gaseoso varchar(100),
ADD lacteo varchar(100);


CREATE TABLE tickets (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre_cliente VARCHAR(100),
  telefono_cliente INT,
  cantidad_productos INT,
  precio_total DECIMAL(10, 2)
);



