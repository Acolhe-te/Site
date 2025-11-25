package com.fatec.Acolhete.controller;

import java.util.List;

import com.fatec.Acolhete.dto.VagaDTO;
import com.fatec.Acolhete.model.Vaga;
import com.fatec.Acolhete.service.VagaService;  
import com.fatec.Acolhete.repository.VagaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/vaga")
@RequiredArgsConstructor
public class VagaController {

    private final VagaRepository vagaRepository;
    private final VagaService vagaService; 

    @GetMapping
    public ResponseEntity<List<Vaga>> getAllVaga(@RequestParam(required = false) Long empresaId) {
        if (empresaId != null) {
            return ResponseEntity.ok(vagaService.listarPorEmpresa(empresaId));
        }
        return ResponseEntity.ok(vagaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> getVagaById(@PathVariable Long id) {
        return vagaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{empresaId}")
    public ResponseEntity<Vaga> save(
            @RequestBody VagaDTO vagaDTO,
            @PathVariable Long empresaId) {

        Vaga saved = vagaService.criar(vagaDTO, empresaId);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaga(@PathVariable Long id) {
        if (!vagaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vagaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
   @PutMapping("/{id}")
    public ResponseEntity<Vaga> atualizarVaga(
            @PathVariable Long id,
            @RequestBody VagaDTO dto) {

        Vaga updated = vagaService.atualizar(id, dto);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<List<Vaga>> getVagasByEmpresa(@PathVariable Long empresaId) {
        return ResponseEntity.ok(vagaRepository.findByEmpresaId(empresaId));
    }

}

