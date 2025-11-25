const API_URL = "http://localhost:8080/vaga";

const params = new URLSearchParams(window.location.search);
const vagaId = params.get("id");

async function carregarDados() {
    if (!vagaId) {
        console.error("ID da vaga não encontrado na URL");
        return;
    }

    try {
        const response = await fetch(`${API_URL}/${vagaId}`);

        if (!response.ok) {
            throw new Error("Erro ao carregar vaga");
        }

        const vaga = await response.json();

        document.getElementById("nome").value = vaga.nome;
        document.getElementById("email").value = vaga.email;
        document.getElementById("telefone").value = vaga.telefone;
        document.getElementById("tipo").value = vaga.tipo;
        document.getElementById("modalidade").value = vaga.modalidade;
        document.getElementById("endereco").value = vaga.endereco;
        document.getElementById("descricao").value = vaga.descricao ?? "";

    } catch (erro) {
        console.error("Erro ao carregar dados:", erro);
    }
}

carregarDados();

document.getElementById("btnAtualizar").addEventListener("click", async () => {
    if (!vagaId) {
        alert("ID da vaga não encontrado. Não é possível atualizar.");
        return;
    }

    const dadosAtualizados = {
        nome: document.getElementById("nome").value,
        email: document.getElementById("email").value,
        telefone: document.getElementById("telefone").value,
        tipo: document.getElementById("tipo").value,
        modalidade: document.getElementById("modalidade").value,
        endereco: document.getElementById("endereco").value,
        descricao: document.getElementById("descricao").value
    };

    try {
        const response = await fetch(`${API_URL}/${vagaId}`, {
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(dadosAtualizados)
        });

        if (!response.ok) {
            throw new Error("Erro ao atualizar vaga");
        }

        alert("Vaga atualizada com sucesso!");
        window.location.href = "servico.html";

    } catch (erro) {
        console.error("Erro ao atualizar:", erro);
        alert("Erro ao atualizar a vaga.");
    }
});

document.getElementById("btnExcluir").addEventListener("click", async () => {
    if (!vagaId) {
        alert("ID da vaga não encontrado. Não é possível excluir.");
        return;
    }

    if (!confirm("Tem certeza que quer excluir esta vaga?")) {
        return;
    }

    try {
        const response = await fetch(`${API_URL}/${vagaId}`, {
            method: "DELETE"
        });

        if (!response.ok) {
            throw new Error("Erro ao excluir vaga");
        }

        alert("Vaga excluída com sucesso!");
        window.location.href = "servico.html";

    } catch (erro) {
        console.error("Erro ao excluir:", erro);
        alert("Erro ao excluir vaga.");
    }
});
