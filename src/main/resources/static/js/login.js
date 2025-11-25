document.getElementById("formLogin").addEventListener("submit", async function(event) {
    event.preventDefault();

    const login = {
        email: document.getElementById("email").value,
        senha: document.getElementById("senha").value
    };

    try {
        let resposta = await fetch("http://localhost:8080/usuario/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(login)
        });

        if (resposta.ok) {
            const usuario = await resposta.json();
            localStorage.setItem("usuarioLogado", JSON.stringify(usuario));
            localStorage.setItem("idLogado", usuario.id); 

            window.location.href = "../User/home.html";
            return;
        }

        resposta = await fetch("http://localhost:8080/empresa/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(login)
        });

        if (resposta.ok) {
            const empresa = await resposta.json();

            localStorage.setItem("empresaLogada", JSON.stringify(empresa));
            localStorage.setItem("idLogado", empresa.id);

            window.location.href = "../Enterprise/dashboard.html";
            return;
        }

        alert("Email ou senha incorretos!");

    } catch (erro) {
        console.error(erro);
        alert("Erro ao conectar com o servidor.");
    }
});
