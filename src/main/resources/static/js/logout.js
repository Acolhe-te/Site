function sairConta() {
    try {
        // Remove dados de sessão / login
        localStorage.removeItem('empresaLogada');
        localStorage.removeItem('usuarioLogado');
        localStorage.removeItem('idLogado');
        localStorage.removeItem('empresaId');
        // Também limpar sessionStorage caso haja algo armazenado lá
        sessionStorage.removeItem('empresaLogada');

    } catch (e) {
        // se falhar, registra no console mas continua com o logout
        console.error('Erro ao limpar storage no logout:', e);
    }

    // Feedback ao usuário e redirecionamento
    alert('Sua conta foi desconectada com sucesso!');
    window.location.href = '../../../index.html';
}
