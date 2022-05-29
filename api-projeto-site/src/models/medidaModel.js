var database = require("../database/config");

function buscarUltimasMedidas(idAquario,limite_linhas) {
    let instrucaoSql = `
        select top 7 
            temperatura, 
            umidade, 
            momento,
            DATE_FORMAT(momento,'%H:%i:%s') as momento_grafico
        from 
            medida
        where 
            fk_aquario = ${idAquario}
        order by 
            id 
        desc`;

    return database.executar(instrucaoSql);
}

function buscarMedidasEmTempoReal(idAquario) {
    let instrucaoSql = `select temperatura, 
                            umidade, 
                            DATE_FORMAT(momento,'%H:%i:%s') as momento_grafico, 
                            fk_aquario 
                            from medida where fk_aquario = ${idAquario} 
                    order by id desc limit 1`;
                    
    console.log("Executando a instrução SQL: \n"+instrucaoSql);
    return database.executar(instrucaoSql);
}


module.exports = {
    buscarUltimasMedidas,
    buscarMedidasEmTempoReal
}