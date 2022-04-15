CREATE DATABASE health_inspec;
USE health_inspec;

DROP TABLE empresa;

CREATE TABLE empresa (
	id INT PRIMARY KEY AUTO_INCREMENT,
    razao_social varchar(45),
    cnpj char(14),
    email varchar(100), 
    telefone char(11),
    cep char(8),
    logradouro varchar(45),
    estado varchar(15),
    cidade varchar(30), 
    senha varchar(20)
);	

TRUNCATE TABLE empresa;

INSERT INTO 
	empresa (razao_social, cnpj, email, telefone, cep, logradouro, estado, cidade, senha) 
VALUES
	("Albert Einstein", 12345678912345, "albert_einstein@email.com", 12345678912, 00000000, "teste", "sp", "sp", "Teste123*");

SELECT
	*
FROM empresa;

alter user 'root'@'localhost' identified with mysql_native_password by 'grupo7Sprint*'; 







    