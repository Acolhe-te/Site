package com.fatec.Acolhete.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UsuarioDTO(
    @NotNull String nomeCompleto,
    @NotBlank String cpf,
    @NotNull LocalDate dataNasc,
    @NotBlank String celular,
    @NotBlank String email,
    @NotBlank String senha
) {}