CREATE DATABASE health_inspec;
USE health_inspec;
DROP DATABASE health_inspec;

DROP TABLE empresa;

CREATE TABLE empresa (
	id INT PRIMARY KEY AUTO_INCREMENT,
    razao_social VARCHAR(45),
    cnpj CHAR(14),
    email VARCHAR(100), 
    telefone CHAR(11),
    cep CHAR(8),
    logradouro VARCHAR(45),
    estado VARCHAR(15),
    cidade VARCHAR(30), 
    senha VARCHAR(20)
);	

INSERT INTO empresa VALUES (
NULL, "Chagas", "123456789-1234", "chagas@gmail.com", "91234-56789",
"12345-78", "Rua Santo Santinho", "São Paulo", "São Paulo", "1234");

CREATE TABLE funcionario (
idFuncionario INT AUTO_INCREMENT,
nomeFuncionario VARCHAR(45),
emailFuncionario VARCHAR(45),
rg VARCHAR(45),
fkHospital INT,
fkGestor INT,
PRIMARY KEY (idFuncionario, fkHospital, fkGestor),
FOREIGN KEY (fkHospital) REFERENCES empresa (id),
FOREIGN KEY (fkGestor) REFERENCES funcionario (idFuncionario)
); 

INSERT INTO funcionario VALUES (
NULL, "José", "jose@gmail.com", "124535351-23", 1, 1);

INSERT INTO funcionario VALUES (
NULL, "André", "andre@gmail.com", "12442435351-23", 1, 1);

SELECT * FROM funcionario;

CREATE TABLE maquinas (
idMaquina INT AUTO_INCREMENT,
tipoMaquina VARCHAR(45),
nomeMaquina VARCHAR(45),
sistemaOperacional VARCHAR(45),
tempoDeUso VARCHAR(45),
bits VARCHAR(45),
fkTecnico INT,
PRIMARY KEY (idMaquina, fkTecnico),
FOREIGN KEY (fkTecnico) REFERENCES funcionario (idFuncionario)
);

SELECT * FROM maquinas;

CREATE TABLE componentes (
idComponentes INT AUTO_INCREMENT,
nomeComponente VARCHAR(55),
tipoComponente VARCHAR(45),
descricaoComponente VARCHAR(70),
fkMaquina INT,
PRIMARY KEY (idComponentes, fkMaquina),
FOREIGN KEY (fkMaquina) REFERENCES maquinas (idMaquina)
);

CREATE TABLE registros (
idRegistros INT AUTO_INCREMENT,
dataHora DATETIME,
totalLivre DOUBLE,
totalUsado DOUBLE,
fkComponente INT,
PRIMARY KEY (idRegistros, fkComponente),
FOREIGN KEY (fkComponente) REFERENCES componentes (idComponentes)
);

CREATE TABLE processos (
idProcessos INT AUTO_INCREMENT,
nomeProcesso VARCHAR(45),
processoPermitido BINARY,
fkMaquina INT,
PRIMARY KEY (idProcessos, fkMaquina),
FOREIGN KEY (fkMaquina) REFERENCES maquinas (idMaquina)
);




TRUNCATE TABLE empresa;

SELECT
	*
FROM empresa;

alter user 'root'@'localhost' identified with mysql_native_password by 'grupo7Sprint*';

 







    