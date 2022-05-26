// sessão
function validarSessao() {
    // aguardar();

    var email = sessionStorage.EMAIL_USUARIO;
    var nomeEmpresa = sessionStorage.NOME_USUARIO;
    var nomeTecnico = sessionStorage.NOME_TECNICO;
    
    if ((email != null && nomeEmpresa != null) || nomeTecnico != null) {
        let hospitalName = document.getElementById("hospitalName");
        let employeeName = document.getElementById("employeeName");

        if (hospitalName != null) {
            hospitalName.textContent = capitalizeName(nomeEmpresa);
            document.querySelector("title").textContent = `Health Inspec | ${nomeEmpresa}`;
        }
        if (employeeName != null) {
            employeeName.textContent = capitalizeName(nomeTecnico);
        }
        // finalizarAguardar();
    } else {
        window.location = "index.html";
    }
}
function capitalizeName(name) {
    let arrayNome = name.split(" ");

    for (let i = 0; i < arrayNome.length; i++) {
        arrayNome[i] = arrayNome[i].charAt(0).toUpperCase() + arrayNome[i].slice(1);
    }

    return arrayNome.join(" ");
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

function sair() {
    sessionStorage.clear();
    window.location = "index.html";    
}
