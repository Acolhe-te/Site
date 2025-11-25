package com.fatec.Acolhete.service;

import com.fatec.Acolhete.dto.VagaDTO;
import com.fatec.Acolhete.model.Empresa;
import com.fatec.Acolhete.model.Vaga;
import com.fatec.Acolhete.repository.EmpresaRepository;
import com.fatec.Acolhete.repository.VagaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VagaService {

    private final VagaRepository vagaRepository;
    private final EmpresaRepository empresaRepository;

    public List<Vaga> listarTodos() {
        return vagaRepository.findAll();
    }

    public List<Vaga> listarPorEmpresa(Long empresaId) {
        return vagaRepository.findByEmpresaId(empresaId);
    }

    public Vaga buscarPorId(Long id) {
        return vagaRepository.findById(id).orElse(null);
    }

    public Vaga criar(VagaDTO dto, Long empresaId) {

        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        Vaga vaga = new Vaga();
        vaga.setNome(dto.nome());
        vaga.setEmail(dto.email());
        vaga.setTelefone(dto.telefone());
        vaga.setTipo(dto.tipo());
        vaga.setModalidade(dto.modalidade());
        vaga.setEndereco(dto.endereco());
        vaga.setDescricao(dto.descricao());
        vaga.setEmpresa(empresa);

        
        return vagaRepository.save(vaga);
    }

    public Vaga atualizar(Long id, VagaDTO dto) {
        return vagaRepository.findById(id).map(existing -> {
            existing.setNome(dto.nome());
            existing.setDescricao(dto.descricao());
            existing.setEndereco(dto.endereco());
            existing.setEmail(dto.email());
            existing.setModalidade(dto.modalidade());
            existing.setTipo(dto.tipo());
            existing.setTelefone(dto.telefone());
            return vagaRepository.save(existing);

        }).orElse(null);
    }

    public boolean excluir(Long id) {
        if (vagaRepository.existsById(id)) {
            vagaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
