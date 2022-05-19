var database = require("../database/config");

function listar() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
        SELECT * FROM empresa;
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

function entrar(email, senha, checkboxTecnico) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function entrar(): ", email, senha)

    let instrucao;

    if (checkboxTecnico == "on") {
        instrucao = `SELECT * FROM funcionario WHERE email = '${email}' AND senha = '${senha}';`;
    } else {
        instrucao = `SELECT * FROM hospital WHERE email = '${email}' AND senha = '${senha}';`;
    }

    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

function validarLogin(email) {
    let instrucao = `SELECT * FROM hospital WHERE email = '${email}'`;

    return database.executar(instrucao);
}

function cadastrar(corporateName, cnpj, email, phoneNumber, cep, publicPlace, state, city, password) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", corporateName, email, password);
    
    var instrucao = `
        INSERT INTO 
            hospital (razao_social, cep, cidade, estado, telefone, email, senha, logradouro, cnpj) 
        VALUES 
        ('${corporateName}', '${cep}', '${city}', '${state}', '${phoneNumber}', '${email}', '${password}', '${publicPlace}', '${cnpj}');
    `;

    console.log("Executando a instrução SQL: \n"+instrucao);
    
    return database.executar(instrucao);
}

function cadastrarTecnico(name, email, fkHospital, cpf, phoneNumber, password) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", name, email, password);

    var instrucao = `
        INSERT INTO 
            funcionario (nome, email, fkHospital, cpf, telefone, senha) 
        VALUES 
        ('${name}', '${email}', '${fkHospital}', '${cpf}', '${phoneNumber}', '${password}');
    `;

    console.log("Executando a instrução SQL: \n"+instrucao);
    
    return database.executar(instrucao);
}

module.exports = {
    entrar,
    validarLogin,
    cadastrar,
    cadastrarTecnico,
    listar
};