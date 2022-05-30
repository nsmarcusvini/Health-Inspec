var database = require("../database/config");

function getHoraRegistrosComponente(fkComponenteMaquina) {
    let instrucao = `
        SELECT 
            TOP 5 totalUsado,
            DATEPART(hour, dataHora) as 'hora',
            DATEPART(minute, dataHora) as 'minuto',
            DATEPART(second, dataHora) as 'segundo' 
        FROM 
            registros 
        WHERE 
            fkComponenteMaquina = '${fkComponenteMaquina}' 
        ORDER BY 
            idRegistros
        DESC;
    `;

    return database.executar(instrucao);
}

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
    getHoraRegistrosComponente,
    buscarUltimasMedidas,
    buscarMedidasEmTempoReal
}