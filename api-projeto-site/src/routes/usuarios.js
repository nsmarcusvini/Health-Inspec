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
});

router.get("/listarMaquinas/:fkHospital", function(req, res) {
    usuarioController.listarMaquinas(req, res);
});

router.get("/listarInfoHospital/:idHospital", function(req, res) {
    usuarioController.listarInfoHospital(req, res);
});

router.post("/cadastrar", function(req, res) {
    usuarioController.validarCadastro(req, res);
});

router.post("/cadastrarTecnico/:fkHospital", function(req, res) {
    usuarioController.validarCadastroTecnico(req, res);
});

router.post("/deletarHospital/:idHospital", function(req, res) {
    usuarioController.deletarHospital(req, res);
});

router.post("/deletarMaquina/:idMaquina", function(req, res) {
    usuarioController.deletarMaquina(req, res);
});

router.post("/deletarTecnico/:idTecnico", function(req, res) {
    usuarioController.deletarTecnico(req, res);
});

router.post("/atualizarHospital/:idHospital", function(req, res) {
    usuarioController.atualizarHospital(req, res);
});

router.post("/atualizarMaquina/:idMaquina", function(req, res) {
    usuarioController.atualizarMaquina(req, res);
});

router.post("/atualizarTecnico/:idTecnico", function(req, res) {
    usuarioController.atualizarTecnico(req, res);
});

router.post("/autenticar", function(req, res) {
    usuarioController.entrar(req, res);
});

router.get("/listarAcessos", function (req, res) {
    usuarioController.listarAcessos(req, res);
});
  
module.exports = router;