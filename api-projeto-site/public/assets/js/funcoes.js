// sessão
function validarSessao() {
    // aguardar();

    var email = sessionStorage.EMAIL_USUARIO;
    var nome = sessionStorage.NOME_USUARIO;
    
    if (email != null && nome != null) {
        document.getElementById("b_usuario").textContent = nome;       
        // finalizarAguardar();
    } else {
        window.location = "index.html";
    }
}

function limparSessao() {
    // aguardar();
    sessionStorage.clear();
   // finalizarAguardar();
    window.location = "dashboard.html";
}

// carregamento (loading)
function aguardar() {
    var divAguardar = document.getElementById("div_aguardar");
    divAguardar.style.display = "none"; 
}

function finalizarAguardar(texto) {
    var divAguardar = document.getElementById("div_aguardar");
    divAguardar.style.display = "none";
    
    var divErrosLogin = document.getElementById("div_erros_login");
    
    if(texto) {
        divErrosLogin.innerHTML = texto;
    }
}
