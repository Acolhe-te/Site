package com.fatec.Acolhete.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record EmpresaDTO(
        @NotBlank String nome,
        @NotBlank String cnpj,
        @NotNull Date dataAbertura,
        @NotBlank String celular,
        @NotBlank String email,
        @NotBlank String senha
) {}
