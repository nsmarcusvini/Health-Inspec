CREATE DATABASE health_inspec;
USE health_inspec;

CREATE TABLE hospital (
idHospital INT PRIMARY KEY AUTO_INCREMENT,
emailHospital VARCHAR(60), 
nomeHospital VARCHAR(55),
telefone CHAR(11),
cep CHAR(9),
estadoHospital VARCHAR(15),
cidadeHospital VARCHAR(30), 
senha VARCHAR(30)
);

INSERT INTO hospital VALUES (
NULL, "chagas@gmail.com", "Chagas", "91234-56789", "12345-708", "São Paulo", "São Paulo", "1234");

CREATE TABLE funcionario (
idFuncionario INT AUTO_INCREMENT,
nomeFuncionario VARCHAR(45),
emailFuncionario VARCHAR(45),
fkHospital INT,
fkGestor INT,
PRIMARY KEY (idFuncionario, fkHospital, fkGestor),
FOREIGN KEY (fkHospital) REFERENCES hospital (idHospital),
FOREIGN KEY (fkGestor) REFERENCES funcionario (idFuncionario)
);

INSERT INTO funcionario VALUES (
NULL, "José", "jose@gmail.com", 1, 1);

INSERT INTO funcionario VALUES (
NULL, "André", "andre@gmail.com", 1, 1);

SELECT * FROM funcionario;

CREATE TABLE maquinas (
idMaquina INT AUTO_INCREMENT,
tipoMaquina VARCHAR(45),
nomeMaquina VARCHAR(45),
sistemaOperacional VARCHAR(45),
tempoDeUso TIME,
arquitetura INT,
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

SELECT * FROM hospital;