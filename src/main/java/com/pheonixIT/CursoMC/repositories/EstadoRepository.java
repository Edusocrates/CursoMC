package com.pheonixIT.CursoMC.repositories;

import com.pheonixIT.CursoMC.resources.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer> {


}
