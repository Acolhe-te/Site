package com.fatec.Acolhete.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nomeCompleto")
    private String nomeCompleto;

    @NotBlank
    @Column(unique = true)
    private String cpf;

    @NotNull  // NotBlank NÃO funciona com Date
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNasc;

    @NotBlank
    private String celular;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String senha;

    // Construtor
    public Usuario(){
        
    }

    public Usuario(String nomeCompleto, String cpf, LocalDate dataNasc,String celular, String email, String senha) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.celular = celular;
        this.email = email;
        this.senha = senha;
    }

    // Get e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}