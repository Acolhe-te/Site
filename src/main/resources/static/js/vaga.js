async function cadastrarForms(event) {
    event.preventDefault(); 

    const nome = document.getElementById("cargo").value;
    const email = document.getElementById("email").value;
    const telefone = document.getElementById("telefone").value;
    const tipo = document.getElementById("contrato").value;
    const modalidade = document.getElementById("formato").value;
    const endereco = document.querySelector("input[name='endereco']").value;
    const descricao = document.getElementById("descricao").value;

    const empresaLogada = JSON.parse(localStorage.getItem("empresaLogada"));

    if (!empresaLogada) {
        alert("Erro: nenhuma empresa logada.");
        return;
    }
    
const empresaId = localStorage.getItem("idLogado");

const payload = {
    nome,
    email,
    telefone,
    tipo,
    modalidade,
    endereco,
    descricao,
    empresaId
};

    try {
        const response = await fetch(`http://localhost:8080/vaga/${empresaId}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(payload)
        });

        if (!response.ok) {
            throw new Error("Erro ao cadastrar vaga");
        }

        alert("Vaga cadastrada com sucesso!");
        window.location.href = "servico.html";

    } catch (error) {
        console.error(error);  
        alert("Erro ao cadastrar a vaga.");
    }
}
