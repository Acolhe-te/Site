package com.fatec.Acolhete.repository;

import java.util.List;
import com.fatec.Acolhete.model.Vaga;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    List<Vaga> findByEmpresaId(Long empresaId);
}

