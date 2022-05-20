var express = require("express");
var router = express.Router();

var usuarioController = require("../controllers/usuarioController");

router.get("/", function(req, res) {
    usuarioController.testar(req, res);
});

router.get("/listar", function(req, res) {
    usuarioController.listar(req, res);
});

router.get("/listarTecnicos/:fkHospital", function(req, res) {
    usuarioController.listarTecnicos(req, res);
})

router.post("/cadastrar", function(req, res) {
    usuarioController.validarLogin(req, res);
})

router.post("/cadastrarTecnico/:fkHospital", function(req, res) {
    usuarioController.cadastrarTecnico(req, res);
})

router.post("/autenticar", function(req, res) {
    usuarioController.entrar(req, res);
});

router.get("/listarAcessos", function (req, res) {
    usuarioController.listarAcessos(req, res);
});
  
module.exports = router;