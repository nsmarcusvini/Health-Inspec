CREATE DATABASE health_inspec-bd;
USE health_inspec-bd;

CREATE TABLE hospital (
idHospital INT PRIMARY KEY AUTO_INCREMENT,
    razao_social VARCHAR(45),
    cep VARCHAR(9),
    cidade VARCHAR(30),
    estado VARCHAR(15),
    telefone VARCHAR(11),
    email VARCHAR(100), 
    senha VARCHAR(20),
    logradouro VARCHAR(45),
    cnpj CHAR(14));

INSERT INTO hospital VALUES (
NULL, "Chagas", "01234-210", "São Paulo", "São Paulo",
"91234-5678", "chagas@gmail.com", "chagas123", "Rua Chagas 548", "12341356215234");

CREATE TABLE funcionario (
idFuncionario INT AUTO_INCREMENT,
nome VARCHAR(45),
email VARCHAR(45),
cpf VARCHAR(14),
telefone VARCHAR(11),
senha VARCHAR(55),
fkHospital INT,
fkGestor INT,
PRIMARY KEY (idFuncionario, fkHospital, fkGestor),
FOREIGN KEY (fkHospital) REFERENCES hospital (idHospital),
FOREIGN KEY (fkGestor) REFERENCES funcionario (idFuncionario)); 

INSERT INTO funcionario VALUES (
NULL, "José", "jose@gmail.com", "124535351-23", "94331-8976", "jose123", 1, 1);

INSERT INTO funcionario VALUES (
NULL, "André", "andre@gmail.com", "154898456-66", "91567-6543", "andre123", 1, 1);

CREATE TABLE maquinas (
idMaquina INT AUTO_INCREMENT,
tipoMaquina VARCHAR(45),
nomeMaquina VARCHAR(45),
sistemaOperacional VARCHAR(45),
tempoDeUso VARCHAR(45),
arquitetura INT,
fkTecnico INT,
PRIMARY KEY (idMaquina, fkTecnico),
FOREIGN KEY (fkTecnico) REFERENCES funcionario (idFuncionario));

CREATE TABLE componentes (
idComponentes INT AUTO_INCREMENT,
nomeComponente VARCHAR(55),
tipoComponente VARCHAR(45),
descricaoComponente VARCHAR(70),
fkMaquina INT,
PRIMARY KEY (idComponentes, fkMaquina),
FOREIGN KEY (fkMaquina) REFERENCES maquinas (idMaquina));

CREATE TABLE registros (
idRegistro INT AUTO_INCREMENT,
dataHora DATETIME,
totalUsado DOUBLE,
fkComponente INT,
PRIMARY KEY (idRegistro, fkComponente),
FOREIGN KEY (fkComponente) REFERENCES componentes (idComponentes));

CREATE TABLE processos (
idProcesso INT AUTO_INCREMENT,
nomeProcesso VARCHAR(45),
processoPermitido BINARY,
fkMaquina INT,
PRIMARY KEY (idProcesso, fkMaquina),
FOREIGN KEY (fkMaquina) REFERENCES maquinas (idMaquina));
