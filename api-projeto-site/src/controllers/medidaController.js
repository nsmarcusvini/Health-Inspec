var medidaModel = require("../models/medidaModel");

function getHoraRegistrosComponente(req, res) {
    const fkComponenteMaquina = req.params.fkComponenteMaquina;

    medidaModel.getHoraRegistrosComponente(fkComponenteMaquina)
    .then(function(resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        }
    }).catch(
        function(error) {
            console.log(error);
            res.status(500).json(error.sqlMessage);
        }
    )
}

function buscarUltimasMedidas(req, res) {

    const limiteLinhas = 7;

	var idComponente = req.params.idComponente;

	console.log(`Recuperando as ultimas ${limiteLinhas} medidas`);

    medidaModel.buscarUltimasMedidas(idComponente, limiteLinhas).then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar as ultimas medidas.", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
}


function buscarMedidasEmTempoReal(req, res) {

	var idAquario = req.params.idAquario;

	console.log(`Recuperando medidas em tempo real`);

    medidaModel.buscarMedidasEmTempoReal(idAquario).then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar as ultimas medidas.", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
}

module.exports = {
    getHoraRegistrosComponente,
    buscarUltimasMedidas,
    buscarMedidasEmTempoReal
}