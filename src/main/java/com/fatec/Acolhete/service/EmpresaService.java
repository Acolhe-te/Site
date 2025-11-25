package com.fatec.Acolhete.service;

import com.fatec.Acolhete.dto.EmpresaDTO;
import com.fatec.Acolhete.model.Empresa;
import com.fatec.Acolhete.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public List<Empresa> listarTodas() {
        return repository.findAll();
    }

    public Empresa buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Empresa criar(EmpresaDTO dto) {
        if (repository.existsByEmail(dto.email())) {
            throw new RuntimeException("Email já cadastrado");
        }
        if (repository.existsByCnpj(dto.cnpj())) {
            throw new RuntimeException("CNPJ já cadastrado");
        }

        Empresa empresa = new Empresa();
        empresa.setNome(dto.nome());
        empresa.setCnpj(dto.cnpj());
        empresa.setDataAbertura(dto.dataAbertura());
        empresa.setCelular(dto.celular());
        empresa.setEmail(dto.email());
        empresa.setSenha(dto.senha());

        return repository.save(empresa);
    }

    public Empresa atualizar(Long id, EmpresaDTO dto) {
        return repository.findById(id).map(existing -> {
            if (!existing.getEmail().equals(dto.email())) {
                repository.findByEmail(dto.email()).ifPresent(e -> { throw new RuntimeException("Email já cadastrado"); });
            }
            if (!existing.getCnpj().equals(dto.cnpj())) {
                repository.findByCnpj(dto.cnpj()).ifPresent(e -> { throw new RuntimeException("CNPJ já cadastrado"); });
            }

            existing.setNome(dto.nome());
            existing.setCnpj(dto.cnpj());
            existing.setDataAbertura(dto.dataAbertura());
            existing.setCelular(dto.celular());
            existing.setEmail(dto.email());
            existing.setSenha(dto.senha());

            return repository.save(existing);

        }).orElse(null);
    }

    public boolean excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Empresa login(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha).orElse(null);
    }
}
