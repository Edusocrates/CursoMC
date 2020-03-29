package com.pheonixIT.CursoMC.resources;

import com.pheonixIT.CursoMC.resources.domain.Categoria;
import com.pheonixIT.CursoMC.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/Categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;


    @RequestMapping(value ="/(id)",method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){
        Categoria obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

}
