package com.fatec.Acolhete.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;

@Entity // Entidade do banco de dados
@Table(name = "vaga") // identifica que dá tabela vagas
public class Vaga {

    @Id // Identifica que é uma chave primária
    @GeneratedValue(strategy=GenerationType.IDENTITY) // identidica que o id é auto_increment 
    private Long id;

    @NotNull
    private String nome;

    @NotBlank // não pode ser nulo e nem ter espaços em branco
    private String email;

    @NotBlank
    private String telefone;

    @NotBlank
    private String tipo;

    @NotBlank
    private String modalidade; 

    @NotNull
    private String endereco; 

    private String descricao;
    @ManyToOne
    @JoinColumn(name = "empresa")   // nome da coluna do banco
    private Empresa empresa;


    // Construtor
    public Vaga(){

    } 

    public Vaga(long id, @NotNull String nome, @NotBlank String email, @NotBlank String telefone, @NotBlank String tipo,
            @NotBlank String modalidade, @NotNull String endereco, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipo = tipo;
        this.modalidade = modalidade;
        this.endereco = endereco;
        this.descricao = descricao;
    }

    // Get e Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }   
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}