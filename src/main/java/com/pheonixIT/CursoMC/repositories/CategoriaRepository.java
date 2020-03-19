package com.pheonixIT.CursoMC.repositories;

import com.pheonixIT.CursoMC.resources.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {




}
