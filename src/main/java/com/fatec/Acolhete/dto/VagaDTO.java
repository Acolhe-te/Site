package com.fatec.Acolhete.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VagaDTO(
    @NotNull String nome,
    @NotBlank String email,
    @NotBlank String telefone,
    @NotBlank String tipo,
    @NotBlank String modalidade,
    @NotNull String endereco,
    String descricao,
    Long empresaId      
) {}