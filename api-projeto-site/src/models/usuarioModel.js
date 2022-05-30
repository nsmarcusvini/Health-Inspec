var database = require("../database/config");

function listar() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
        SELECT * FROM funcionario;
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

function listarInfoHospital(idHospital) {
    let instrucao = `
        SELECT
            razao_social,
            cnpj,
            estado,
            cidade,
            cep,
            logradouro,
            telefone,
            email
        FROM
            hospital
        WHERE
            idHospital = ${idHospital};
    `;

    return database.executar(instrucao);
}

function listarTecnicos(fkHospital) {
    let instrucao = `
        SELECT 
            idFuncionario, 
            nome,
            cpf,
            telefone, 
            email
        FROM 
            funcionario
        WHERE 
            fkHospital = ${fkHospital};
    `;

    return database.executar(instrucao);
}

function listarMaquinas(fkHospital) {
    let instrucao = `
        SELECT 
            idMaquina,
            nomeMaquina,
            sistemaOperacional,
            arquitetura,
            apelido,
            tipoMaquina
        FROM
            maquinas
        WHERE 
            fkHospital = ${fkHospital};
    `;

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

function validarCadastro(email) {
    let instrucao = `SELECT * FROM hospital WHERE email = '${email}';`;

    return database.executar(instrucao);
}

function validarCadastroTecnico(email) {
    let instrucao = `SELECT * FROM funcionario WHERE email = '${email}';`;

    return database.executar(instrucao);
}

function deletarHospital(idHospital) {
    let instrucao = `
        DELETE FROM
            hospital
        WHERE
            idHospital = ${idHospital};
    `;

    return database.executar(instrucao);
}

function deletarTodosTecnicos(fkHospital) {
    let instrucao = `
        DELETE FROM
            funcionario
        WHERE
            fkHospital = ${fkHospital};
    `;

    return database.executar(instrucao)
}

function deletarTecnico(id) {
    let instrucao = `DELETE FROM funcionario WHERE idFuncionario = ${id};`;

    return database.executar(instrucao);
}

function deletarMaquina(id) {
    let instrucao = `
        DELETE FROM
            maquinas
        WHERE
            idMaquina = ${id};
    `;

    return database.executar(instrucao);
}

function deletarRegistrosMaquina(fkMaquina) {
    let instrucao = `
        DELETE FROM 
            registros
        WHERE
            fkMaquina = ${fkMaquina};
    `;

    return database.executar(instrucao);
}

function deletarComponentesMaquina(fkMaquina) {
    let instrucao = `
        DELETE FROM 
            componentes_has_maquinas
        WHERE
            fkMaquina = ${fkMaquina};
    `;

    return database.executar(instrucao);
}

function deletarTodasMaquinas(fkHospital) {
    let instrucao = `
        DELETE FROM 
            maquinas
        WHERE
            fkHospital = ${fkHospital};
    `;

    return database.executar(instrucao);
}

function atualizarHospital(id, field, value) {
    let instrucao = `
        UPDATE 
            hospital
        SET 
            ${field} = '${value}'
        WHERE
            idHospital = ${id};
    `;

    return database.executar(instrucao);
}

function atualizarTecnico(id, field, value) {
    let instrucao = `
        UPDATE 
            funcionario 
        SET 
            ${field} = '${value}' 
        WHERE 
            idFuncionario = ${id};
    `;

    return database.executar(instrucao);
}

function atualizarMaquina(id, field, value) {
    let instrucao = `
        UPDATE
            maquinas
        SET
            ${field} = '${value}'
        WHERE
            idMaquina = ${id};
    `;

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

function getTotalComponente(idMaquina, fkComponente) {
    let instrucao = `
        SELECT 
            * 
        FROM
            componentes_has_maquinas 
        INNER JOIN 
            maquinas 
        ON
            fkMaquina = idMaquina
        WHERE 
            idMaquina = ${idMaquina} 
        AND
            fkComponente = ${fkComponente};
    `;

    return database.executar(instrucao);
}

function getUsadoComponente(idMaquina, fkComponente) {
    let instrucao = `
        SELECT 
            * 
        FROM 
            registros 
        INNER JOIN 
            maquinas 
        ON 
            fkMaquina = idMaquina
        WHERE 
            idMaquina = ${idMaquina}
        AND 
            fkComponente = ${fkComponente};
    `;

    return database.executar(instrucao);
}

module.exports = {
    entrar,
    validarCadastro,
    validarCadastroTecnico,
    deletarHospital,
    deletarMaquina,
    deletarTodasMaquinas,
    deletarRegistrosMaquina,
    deletarComponentesMaquina,
    deletarTodosTecnicos,
    deletarTecnico,
    atualizarHospital,
    atualizarMaquina,
    atualizarTecnico,
    cadastrar,
    cadastrarTecnico,
    listar,
    listarTecnicos,
    listarMaquinas,
    listarInfoHospital,
    getTotalComponente,
    getUsadoComponente
};