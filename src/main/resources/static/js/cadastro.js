const btnUsuario = document.getElementById('btnUsuario');
const btnEmpresa = document.getElementById('btnEmpresa');
const formUsuario = document.getElementById('formUsuario');
const formEmpresa = document.getElementById('formEmpresa');

// Alternando para o formulário de Usuário
btnUsuario.addEventListener('click', () => {

    btnUsuario.classList.add('active');
    btnEmpresa.classList.remove('active');
    
    formUsuario.classList.add('active'); // Mostrando o formulário de Usuário
    formEmpresa.classList.remove('active'); // E escondendo o formulário de Empresa
});
// Alternando para o formulário de Empresa
btnEmpresa.addEventListener('click', () => {

    btnEmpresa.classList.add('active');
    btnUsuario.classList.remove('active');
    
    formEmpresa.classList.add('active'); // Mostrando o formulário de Empresa
    formUsuario.classList.remove('active'); // e escondendo o formulário de Usuário
});

// --------------------------------------------------------------------------------------------------------
// Envio do formulário de Usuário
formUsuario.addEventListener("submit", async function(event) {
    event.preventDefault();

    const usuario = {
        nomeCompleto: document.getElementById("nomeCompleto").value,
        cpf: document.getElementById("cpf").value,
        dataNasc: document.getElementById("dataNasc").value,
        celular: document.getElementById("celular").value,
        email: document.getElementById("email").value,
        senha: document.getElementById("senha").value
    };

    try {
        const resposta = await fetch("http://localhost:8080/usuario", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(usuario)
        });

        if (resposta.ok) {
            alert("Conta criada com sucesso!");
            window.location.href = "../login/login.html";
        } else {
            alert("Erro ao criar conta.");
        }
    } catch (erro) {
        alert("Erro ao conectar com servidor.");
        console.error(erro);
    }
});
// ---------------------------------------------------------------------------------------------
// Empresa
formEmpresa.addEventListener("submit", async function(event) {
    event.preventDefault();

    const empresa = {
        nome: document.getElementById("nomeEmpresa").value,
        cnpj: document.getElementById("cnpj").value,
        dataAbertura: document.getElementById("dataAbertura").value,
        celular: document.getElementById("celularEmpresa").value,
        email: document.getElementById("emailEmpresa").value,
        senha: document.getElementById("senhaEmpresa").value
    };

    try {
        const resposta = await fetch("http://localhost:8080/empresa", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(empresa)
        });

        if (resposta.ok) {
            alert("Empresa cadastrada com sucesso!");
            window.location.href = "../login/login.html";
        } else {
            alert("Erro ao cadastrar empresa.");
        }
    } catch (erro) {
        alert("Erro ao conectar com servidor.");
        console.error(erro);
    }
});
