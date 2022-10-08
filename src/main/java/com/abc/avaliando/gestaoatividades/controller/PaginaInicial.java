package com.abc.avaliando.gestaoatividades.controller;

import com.abc.avaliando.gestaoatividades.repository.AtividadeAcademicaRepository;
import com.abc.avaliando.gestaoatividades.repository.entity.AtividadeAcademica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PaginaInicial {
    
    @Autowired
    AtividadeAcademicaRepository repo;
    
    @GetMapping("/atividades")
    public ModelAndView list() {
    Iterable<AtividadeAcademica> atividades = this.repo.findAll();
    return new ModelAndView("atividades/list","atividades",atividades);
    }
}
