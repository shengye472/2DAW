-- Active: 1740475569427@@127.0.0.1@3306@shop
DROP DATABASE IF EXISTS shop;

CREATE DATABASE shop;

USE shop;

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codebar VARCHAR(20) UNIQUE NOT NULL, 
    name VARCHAR(25) NOT NULL,
    price_sell DECIMAL(10, 2) NOT NULL,
    price_buy DECIMAL(10, 5) NOT NULL,
    stock INT
)

CREATE TABLE venta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATETIME NOT NULL,
    total DECIMAL(10, 2) NOT NULL
)

CREATE TABLE detalle_venta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quantity INT NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    id_venta INT NOT NULL,
    Foreign Key (id_venta) REFERENCES venta(id),
    id_product INT NOT NULL,
    Foreign Key (id_product) REFERENCES product(id)   
)