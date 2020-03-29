package com.pheonixIT.CursoMC.repositories;

import com.pheonixIT.CursoMC.resources.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {


}
