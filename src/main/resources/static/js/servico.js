document.addEventListener("DOMContentLoaded", carregarVagas);

function carregarVagas() {
    fetch("http://localhost:8080/vaga")
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao buscar vagas");
            }
            return response.json();
        })
        .then(vagas => {
            const container = document.querySelector("#secao-vagas .cards-carousel");
            container.innerHTML = ""; // limpa os cards fixos

            vagas.forEach(vaga => {
                const card = document.createElement("div");
                card.classList.add("card");

                card.innerHTML = `
                    <h3 class="card-titulo">${vaga.nome || "Sem título"}</h3>
                    <p class="card-descricao">${vaga.descricao?.substring(0, 50) || "Sem descrição"}</p>
                    <a href="formsAlterar.html?id=${vaga.id}" class="card-btn">Visualizar</a>
                `;

                container.appendChild(card);
            });
        })
        .catch(error => {
            console.error("Erro:", error);
        });
}
