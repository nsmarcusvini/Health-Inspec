// função para adicionar menu fixo ao rolar a página
(() => {
    let container = document.querySelector(".header-container");

    let beginButton = document.getElementById("beginButton");
    let workProcessButton = document.getElementById("workProcessButton");
    let aboutUsButton = document.getElementById("aboutUsButton");
    
    window.addEventListener("scroll", () => {
        if (window.scrollY > 0) {
            container.classList.add("fixed-header");
        } else {
            container.classList.remove("fixed-header");
        }

        
        if (window.scrollY < 380) {
            workProcessButton.classList.remove("current");
            aboutUsButton.classList.remove("current");
    
            beginButton.classList.add("current");
        } else if (window.scrollY < 1200) {
            beginButton.classList.remove("current");
            aboutUsButton.classList.remove("current");
    
            workProcessButton.classList.add("current");
        } else if (window.scrollY < 1350) {
            beginButton.classList.remove("current");
            workProcessButton.classList.remove("current");
    
            aboutUsButton.classList.add("current");
        }
    })
})();

// botao do cadastro para mostrar modal 
let registerContainer = document.querySelector(".register-container");
let registerDarkBodyContainer = document.querySelector(".register-dark-body-container");
let registerButton = document.querySelector("#registerButton");

registerButton.addEventListener("click", function() {
    registerContainer.classList.add("active");
    registerDarkBodyContainer.classList.add("active-register-dark-body-container");
    registerButton.classList.add("current")
});

document.querySelector(".close-register-button").addEventListener("click", function() {
    registerContainer.classList.remove("active");
    registerDarkBodyContainer.classList.remove("active-register-dark-body-container");
    registerButton.classList.remove("current")

    let inputs = Array.from(document.querySelectorAll(".register-container input"));
    inputs.forEach(input => {
        input.value = "";
    });
});

// botao do login para mostrar modal 
let loginButton = document.querySelector("#loginButton");
let loginContainer = document.querySelector(".login-dark-body-container");
let loginForm = document.querySelector(".login-container");

loginButton.addEventListener("click", () => {
    loginContainer.classList.add("active-login-dark-body-container");
    loginForm.classList.add("active");
    loginButton.classList.add("current");
})

let closeButton = document.querySelector(".close-login-button");

closeButton.addEventListener("click", function() {
    loginContainer.classList.remove("active-login-dark-body-container");
    loginForm.classList.remove("active");
    loginButton.classList.remove("current");

    let inputs = Array.from(document.querySelectorAll(".login-container input"));
    inputs.forEach(input => {
        input.value = "";
    })
});

// funcao para mostrar/esconder senha com icone do olho
let eyeIcon = document.getElementById("eye_icon");
eyeIcon.addEventListener("click", function() {
    let password = document.getElementById("password");
    let confirmation = document.getElementById("passwdConfirmation");
    if (password.type == "password") {
        eyeIcon.classList.remove("fa-eye");
        eyeIcon.classList.add("fa-eye-slash");
        password.type = "text";
        confirmation.type = "text";
    } else {
        eyeIcon.classList.remove("fa-eye-slash");
        eyeIcon.classList.add("fa-eye");
        password.type = "password"
        confirmation.type = "password"
    }
});

const loginEyeIcon = document.getElementById("login_eye");
loginEyeIcon.addEventListener("click", () => {
    const loginInput = document.getElementById("loginPassword");

    if (loginInput.type == "password") {
        loginEyeIcon.classList.remove("fa-eye");
        loginEyeIcon.classList.add("fa-eye-slash");

        loginInput.type = "text";
    } else {
        loginEyeIcon.classList.remove("fa-eye-slash");
        loginEyeIcon.classList.add("fa-eye");

        loginInput.type = "password";
    }
});

// funcoes para menu lateral 
let openSideBarButton = document.getElementById("sidebar-open-button");

openSideBarButton.addEventListener("click", () => {
    document.querySelector(".sidebar").style.width = "15.625rem";
    document.querySelector(".sidebar").style.marginLeft = "15.625rem";
});

let closeSideBarButton = document.getElementById("sidebar-close-button");

closeSideBarButton.addEventListener("click", () => {
    document.querySelector(".sidebar").style.width = "0rem";
    document.querySelector(".sidebar").style.marginLeft = "0rem";
});

// revelando texto e imagem do "Sobre nós" com efeito 
(() => {
    window.addEventListener("scroll", () => {
        let textoImagemSobre = document.querySelector(".about-us-subtitle")
        if (window.scrollY >= 1090) {
            textoImagemSobre.style.visibility = "visible";
            textoImagemSobre.classList.add('animate__animated', 'animate__fadeIn');
        }
    })
})();

