package com.pheonixIT.CursoMC.services;


import com.pheonixIT.CursoMC.Exception.ObjectNotFoundException;
import com.pheonixIT.CursoMC.repositories.CategoriaRepository;
import com.pheonixIT.CursoMC.resources.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto Não encontrado !!" +
                    id + "Tipo: " + Categoria.class.getName());
        }
        return obj.orElse(null);

    }
}
