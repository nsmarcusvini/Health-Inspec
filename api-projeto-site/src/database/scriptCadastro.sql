CREATE DATABASE usuarios;
USE usuarios;

CREATE TABLE empresa (
	id INT PRIMARY KEY AUTO_INCREMENT, 
    razao_social varchar(45),
    email varchar(45), 
    telefone char(11),
    estado varchar(15),
    cidade varchar(30), 
    logradouro varchar(45),
    senha varchar(12)
);








    