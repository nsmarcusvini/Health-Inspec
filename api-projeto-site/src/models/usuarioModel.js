var database = require("../database/config")

function listar() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
        SELECT * FROM empresa;
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

function entrar(email, senha) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function entrar(): ", email, senha)
    var instrucao = `
        SELECT * FROM empresa WHERE email = '${email}' AND senha = '${senha}';
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

function cadastrar(corporateName, cnpj, email, phoneNumber, cep, state, city, publicPlace, password) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", corporateName, email, password);
    
    var instrucao = `
        INSERT INTO 
            empresa (razao_social, cnpj, email, telefone, cep, logradouro, estado, cidade, senha) 
        VALUES 
        ('${corporateName}', '${cnpj}', '${email}', '${phoneNumber}', '${cep}', '${state}', '${city}', '${publicPlace}', '${password}');
    `;

    console.log("Executando a instrução SQL: \n"+instrucao);
    
    return database.executar(instrucao);
}

module.exports = {
    entrar,
    cadastrar,
    listar
};