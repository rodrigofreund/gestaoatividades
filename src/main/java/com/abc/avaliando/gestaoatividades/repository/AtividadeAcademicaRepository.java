package com.abc.avaliando.gestaoatividades.repository;

import com.abc.avaliando.gestaoatividades.repository.entity.AtividadeAcademica;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeAcademicaRepository extends PagingAndSortingRepository<AtividadeAcademica, Long> {
}
