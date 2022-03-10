// função para adicionar menu fixo ao rolar a página
(() => {
    let container = document.querySelector(".header-container");

    window.addEventListener("scroll", () => {
        window.scrollY > 0 ? container.classList.add("fixed-header")
            : container.classList.remove("fixed-header");
    })
})();