// função para adicionar menu fixo ao rolar a página
(() => {
    let container = document.querySelector(".headerContainer");

    window.addEventListener("scroll", () => {
        window.scrollY > 0 ? container.classList.add("fixedHeader")
            : container.classList.remove("fixedHeader");
    })
})();