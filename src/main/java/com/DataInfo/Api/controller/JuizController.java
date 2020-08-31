package com.DataInfo.Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DataInfo.Api.model.Juiz;
import com.DataInfo.Api.service.Impl.JuizServiceImpl;

@RestController
public class JuizController {

	@Autowired
	private JuizServiceImpl juizService;


    @PostMapping("/api/juiz/save")
    public void saveJuiz(Juiz juiz) {
        juizService.save(juiz);
    }

    @GetMapping("/api/juiz/all")
    public List<Juiz> findAllJuiz() {
        return juizService.findAll();
    }
    
    public Juiz findProcesso(Juiz processo) {
    	return null;
    }


}
