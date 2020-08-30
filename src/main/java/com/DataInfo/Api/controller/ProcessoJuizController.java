package com.DataInfo.Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DataInfo.Api.model.Processo_Juiz;
import com.DataInfo.Api.service.Impl.ProcessoJuizServiceImpl;

@RestController
public class ProcessoJuizController {

	@Autowired
	private ProcessoJuizServiceImpl processoJuizService;


    @PostMapping("/api/processoJuiz/save")
    public void saveProcessoJuiz(Processo_Juiz processoJuiz) {
        processoJuizService.save(processoJuiz);
    }

    @GetMapping("/api/processoJuiz/all")
    public List<Processo_Juiz> findAllProcessoJuiz() {
        return processoJuizService.findAll();
    }
    
    public Processo_Juiz findProcesso(Processo_Juiz processo) {
    	return null;
    }


}
