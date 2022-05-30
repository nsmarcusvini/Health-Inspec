var express = require("express");
var router = express.Router();

var medidaController = require("../controllers/medidaController");

router.get("/ultimas/:idComponente", function(req, res) {
    medidaController.buscarUltimasMedidas(req, res);
});

router.get("/tempo-real/:idAquario", function(req, res) {
    medidaController.buscarMedidasEmTempoReal(req, res);
})

router.get("/getHoraRegistrosComponente/:fkComponenteMaquina", function(req, res) {
    medidaController.getHoraRegistrosComponente(req, res);
});
  
module.exports = router;