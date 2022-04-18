CREATE DATABASE health_inspec;
USE health_inspec;

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

CREATE TABLE maquinas (
idMaquina INT AUTO_INCREMENT,
tipoMaquina VARCHAR(45),
nomeMaquina VARCHAR(45),
sistemaOperacional VARCHAR(45),
tempoDeUso TIME,
bits INT,
fkTecnico INT,
PRIMARY KEY (idMaquina, fkTecnico),
FOREIGN KEY (fkTecnico) REFERENCES funcionario (idFuncionario)
);

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

 







    