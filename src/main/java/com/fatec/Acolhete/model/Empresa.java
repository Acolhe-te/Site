package com.fatec.Acolhete.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cnpj;

    @Temporal(TemporalType.DATE)
    private Date dataAbertura;

    private String celular;

    @Column(unique = true)
    private String email;

    private String senha;
}
