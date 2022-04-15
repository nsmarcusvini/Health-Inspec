// sessão
function validarSessao() {
    // aguardar();
    let email = sessionStorage.EMAIL_USUARIO;
    let nome = sessionStorage.NOME_USUARIO;

    let arrayNome = nome.split(" ");

    for (let i = 0; i < arrayNome.length; i++) {
        arrayNome[i] = arrayNome[i].charAt(0).toUpperCase() + arrayNome[i].slice(1);
    }

    let capitalizedName = arrayNome.join(" ");
    
    if (email != null && nome != null) {
        document.getElementById("textoNomeUsuario").innerHTML = capitalizedName;
    } else {
        window.location = "../login.html";
    }
}
   
function limparSessao() {
    // aguardar();
    sessionStorage.clear();
    window.location = "index.html";
}

// carregamento (loading)
function aguardar() {
    var divAguardar = document.getElementById("div_aguardar");
}

// modal
function mostrarModal() {
    var divModal = document.getElementById("div_modal");
}

function fecharModal() {
    var divModal = document.getElementById("div_modal");
}

