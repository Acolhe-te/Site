async function carregarVagas() {
    const secaoVagas = document.getElementById("secao-vagas");

    try {
        // Se houver uma empresa logada, filtra pelas vagas dessa empresa
        let url = "http://localhost:8080/vaga";
        try {
            const empresa = JSON.parse(localStorage.getItem("empresaLogada"));
            if (empresa && empresa.id) {
                url += `?empresaId=${empresa.id}`;
            }
        } catch (e) {
            // ignore parsing errors e siga sem filtro
        }

        const response = await fetch(url);

        if (!response.ok) {
            throw new Error("Erro ao buscar vagas");
        }

        const vagas = await response.json();

        if (!vagas || vagas.length === 0) {
            secaoVagas.innerHTML += "<p>Nenhuma vaga cadastrada.</p>";
            return;
        }

        const cardsContainer = secaoVagas.querySelector(".cards-carousel");

        cardsContainer.innerHTML = ""; // limpa cards fixos

        vagas.forEach(vaga => {
            const card = document.createElement("div");
            card.classList.add("card");

            card.innerHTML = `
                <h3 class="card-titulo">${vaga.nome}</h3>
                <p class="card-descricao">${vaga.descricao ?? "Sem descrição"}</p>
                <a href="formsAlterar.html?id=${vaga.id}" class="card-btn">Visualizar</a>
            `;

            cardsContainer.appendChild(card);
        });

    } catch (error) {
        console.error("Erro ao carregar vagas:", error);
    }
}

window.onload = carregarVagas;
