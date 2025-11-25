package com.fatec.Acolhete.service;

import com.fatec.Acolhete.dto.UsuarioDTO;
import com.fatec.Acolhete.model.Usuario;
import com.fatec.Acolhete.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

public UsuarioService(UsuarioRepository repository) {
    this.repository = repository;
}

public List<Usuario> listarTodos(){
    return repository.findAll();
}

public Usuario buscarPorId(Long id){
    return repository.findById(id).orElse(null);
}

public Usuario criar(UsuarioDTO dto) {
    if (repository.existsByEmail(dto.email())) {
        throw new RuntimeException("Email já cadastrado");
    }
    if (repository.existsByCpf(dto.cpf())) {
        throw new RuntimeException("CPF já cadastrado");
    }

    Usuario usuario = new Usuario();
    usuario.setNomeCompleto(dto.nomeCompleto());
    usuario.setCpf(dto.cpf());
    usuario.setDataNasc(dto.dataNasc());
    usuario.setCelular(dto.celular());
    usuario.setEmail(dto.email());
    usuario.setSenha(dto.senha());

    return repository.save(usuario);
}
    
public Usuario atualizar(Long id, UsuarioDTO dto){
    return repository.findById(id).map(existing -> {
        if (!existing.getEmail().equals(dto.email())) {
            repository.findByEmail(dto.email()).ifPresent(u -> { throw new RuntimeException("Email já cadastrado"); });
        }
        if (!existing.getCpf().equals(dto.cpf())) {
            repository.findByCpf(dto.cpf()).ifPresent(u -> { throw new RuntimeException("CPF já cadastrado"); });
        }

        existing.setNomeCompleto(dto.nomeCompleto());
        existing.setCpf(dto.cpf());
        existing.setDataNasc(dto.dataNasc());
        existing.setCelular(dto.celular());
        existing.setEmail(dto.email());
        existing.setSenha(dto.senha());

        return repository.save(existing);

    }).orElse(null);
}

public boolean excluir(Long id){
    if (repository.existsById(id)){
        repository.deleteById(id);
        return true;
    }
        return false;
    }

    public Usuario login(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha).orElse(null);
    }

}

