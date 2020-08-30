package com.DataInfo.Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DataInfo.Api.model.Processo;
import com.DataInfo.Api.service.Impl.ProcessoServiceImpl;

@RestController
public class ProcessoController {

	@Autowired
	private ProcessoServiceImpl processoService;


    @PostMapping("/api/processo/save")
    public void saveProcesso(Processo processo) {
        processoService.save(processo);
    }

    @GetMapping("/api/processo/all")
    public List<Processo> findAllProcesso() {
        return processoService.findAll();
    }
    
    public Processo findProcesso(Processo processo) {
    	return null;
    }


}
