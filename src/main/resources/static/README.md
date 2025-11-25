# Acolhe-te: Sistema de Empregabilidade e Denúncia Segura para Mulheres Vítimas de Violência
<img width="820" height="200" alt="logoacolhe-te" src="https://github.com/user-attachments/assets/9f9b4bce-9bea-4e94-9bfc-0fec16582637"/>

## Integrantes
- Gabriele Monteiro
- Tainá Kasai
- Talita Sabine

## Descrição
O Acolhe-te é um sistema de empregabilidade e denúncia voltado para mulheres vítimas de violência doméstica. Desenvolvido para ser discreto e seguro, dispõe de um botão de alteração de layout para preservar a confidencialidade da usuária e um botão de pânico, que encaminha sua localização e dados às autoridades. Além disso, a funcionalidade de auxílio à empregabilidade visa a autonomia financeira dessas vítimas. 

## 1. Visão Geral do Projeto
O Acolhe-te é uma plataforma crucial de apoio à mulher vítima de violência doméstica, focada em duas vertentes essenciais: segurança imediata e autonomia financeira.

Desenvolvido com a premissa de discreção e segurança, o sistema visa fornecer um ambiente confiável onde a usuária pode buscar auxílio sem comprometer sua integridade.

O sistema dispõe de funcionalidades críticas de segurança, como um botão de alteração de layout para preservar a confidencialidade da usuária e um botão de pânico, que encaminha sua localização e dados essenciais às autoridades competentes. Além disso, a funcionalidade de auxílio à empregabilidade visa a autonomia e a reconstrução financeira dessas vítimas pós denúncia.

## 2. Funcionalidades Principais
Sistema de Denúncia Discreta: Permite o envio rápido e seguro da localização e dados da usuária às autoridades em situações de emergência, sendo possível também adicionar contatos de emergência.

Modo de Confidencialidade (Botão de Alteração de Layout): Alterna o design da interface para um tema inócuo (ex: "Clima" ou "Receitas"), protegendo a atividade da usuária contra olhares indesejados.

Auxílio à Empregabilidade: Dashboard e listagem de serviços/vagas (Página servico.html) para conectar vítimas a oportunidades de trabalho, promovendo a independência financeira, além de apoio à outras áreas como terapia psicológica, advogado, entre outros.

Gestão de Empresas/Vagas (Dashboard): Área restrita para empresas parceiras cadastrarem vagas e gerenciarem colaboradores e análises.

## 3. Tecnologias Utilizadas
Este projeto foi construído utilizando as seguintes tecnologias front-end e ferramentas de desenvolvimento:

- HTML5: Estrutura e semântica de todas as páginas.

- CSS3: Estilização, layout e responsividade. Utilização de Media Queries para adaptação a diferentes dispositivos.

- JavaScript (ES6+): Implementação de funcionalidades interativas, como o botão de pânico, alternância de layout e o comportamento da Sidebar.

- Boxicons: Biblioteca de ícones utilizada na Sidebar e outras partes do layout.

- Font Awesome: Biblioteca de ícones utilizada nas páginas principais.

## 4. Estruturação de Arquivos
assets/: Contém todos os recursos não-código (imagens, fontes, ícones).

css/: Os estilos estão separados por responsabilidade, facilitando a manutenção e a localização de regras específicas.

js/: Scripts separados por funcionalidade. O script.js concentra as interações de UI.

pages/: Área principal do projeto. Os arquivos HTML estão organizados em subpastas por contexto (área da empresa, autenticação, rodapé, etc.), mantendo a raiz organizada.

## 5. Próximos Passos e Melhorias
- [ ] Implementação do Back-end para processamento seguro de denúncias e autenticação de usuários.

- [ ] Conexão da base de dados de vagas com o Dashboard das empresas.

- [ ] Refinamento do JavaScript para o botão de pânico (ex: envio de coordenadas via API).

- [ ] Testes de usabilidade e segurança com foco na experiência da usuária em situação de risco.
