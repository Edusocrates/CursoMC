package com.pheonixIT.CursoMC.repositories;

import com.pheonixIT.CursoMC.resources.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

}
