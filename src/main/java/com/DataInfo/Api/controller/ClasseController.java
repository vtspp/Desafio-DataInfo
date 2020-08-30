package com.DataInfo.Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DataInfo.Api.model.Classe;
import com.DataInfo.Api.service.Impl.ClasseServiceImpl;

@RestController
public class ClasseController {

	@Autowired
	private ClasseServiceImpl classeService;


    @PostMapping("/api/classe/save")
    public void saveClasse(Classe classe) {
        classeService.save(classe);
    }

    @GetMapping("/api/classe/all")
    public List<Classe> findAllClasse() {
        return classeService.findAll();
    }
    
    public Classe findProcesso(Classe processo) {
    	return null;
    }


}
