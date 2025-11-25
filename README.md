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
O back-end do Acolhe-te foi desenvolvido utilizando as seguintes tecnologias e ferramentas principais:

Java 17: Linguagem base do projeto, oferecendo recursos modernos e melhor desempenho.

Spring Boot: Framework responsável por facilitar a criação da API REST, configuração do servidor, injeção de dependência e organização do projeto.

Spring Web: Módulo que permite a criação dos endpoints HTTP que se comunicam com o front-end.

Spring Data JPA: Camada de persistência que facilita o acesso ao banco de dados através do Hibernate.

Hibernate: ORM utilizado para mapear as entidades Java para tabelas no banco de dados.

MySQL: Banco de dados utilizado para armazenar informações de usuárias, denúncias, vagas e empresas parceiras.

Jakarta Validation: Validação de campos em DTOs, assegurando segurança e consistência dos dados recebidos.

Maven: Gerenciador de dependências e automatização da build do projeto.

## 4. Estruturação de Arquivos
A estrutura do back-end foi organizada para manter o código limpo, modular e de fácil manutenção:

controller/
Contém todos os endpoints da API. Cada controller representa um conjunto específico de funcionalidades, como Usuária, Empresa, Vaga e Denúncia.

service/
Onde ficam as regras de negócio. Os serviços tratam dados recebidos dos controllers e coordenam a lógica antes de acessar o repositório.

repository/
Armazena as interfaces que se comunicam diretamente com o banco de dados utilizando Spring Data JPA.

model/
Inclui as entidades do sistema, representando as tabelas do banco (Usuária, Empresa, Vaga, Denúncia, etc.).

dto/
Armazena os objetos usados para transferência de dados entre API e front-end de forma segura e simplificada.

resources/application.properties
Arquivo de configuração do projeto, incluindo credenciais do banco de dados, porta do servidor e propriedades do Spring.

## 5. Próximos Passos e Melhorias

- [ ] Refinamento do JavaScript para o botão de pânico (ex: envio de coordenadas via API).

- [ ] Testes de usabilidade e segurança com foco na experiência da usuária em situação de risco.
