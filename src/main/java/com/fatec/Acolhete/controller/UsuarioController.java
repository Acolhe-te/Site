package com.fatec.Acolhete.controller;

import java.util.List;
import java.util.Map;

import com.fatec.Acolhete.model.Usuario;
import com.fatec.Acolhete.dto.LoginDTO;
import com.fatec.Acolhete.dto.UsuarioDTO;
import com.fatec.Acolhete.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("")
    public List<Usuario> getAllUsuario(){
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id){
        Usuario u = usuarioService.buscarPorId(id);
        if (u == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(u);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody UsuarioDTO dto){
        try {
            Usuario created = usuarioService.criar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody UsuarioDTO dto){
        Usuario updated = usuarioService.atualizar(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario (@PathVariable Long id){
        boolean deleted = usuarioService.excluir(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        Usuario usuario = usuarioService.login(dto.email(), dto.senha());

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Email ou senha incorretos");
        }

        return ResponseEntity.ok(Map.of(
            "id", usuario.getId(),
            "tipoConta", "usuario"
        ));
    }
}
