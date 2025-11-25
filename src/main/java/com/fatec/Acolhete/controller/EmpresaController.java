package com.fatec.Acolhete.controller;

import com.fatec.Acolhete.dto.EmpresaDTO;
import com.fatec.Acolhete.dto.LoginDTO;
import com.fatec.Acolhete.model.Empresa;
import com.fatec.Acolhete.service.EmpresaService;
import lombok.AllArgsConstructor;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    @GetMapping("")
    public List<Empresa> listarTodas() {
        return empresaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable Long id) {
        Empresa e = empresaService.buscarPorId(id);
        if (e == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(e);
    }

    @PostMapping("")
    public ResponseEntity<?> criar(@RequestBody EmpresaDTO dto) {
        try {
            Empresa created = empresaService.criar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @RequestBody EmpresaDTO dto) {
        Empresa updated = empresaService.atualizar(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean deleted = empresaService.excluir(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        Empresa empresa = empresaService.login(dto.email(), dto.senha());

        if (empresa == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Email ou senha incorretos");
        }

        return ResponseEntity.ok(Map.of(
            "id", empresa.getId(),
            "tipoConta", "empresa"
        ));

    }
}
