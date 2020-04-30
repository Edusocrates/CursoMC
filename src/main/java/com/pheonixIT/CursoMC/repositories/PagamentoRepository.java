package com.pheonixIT.CursoMC.repositories;

import com.pheonixIT.CursoMC.resources.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento,Integer> {

}
