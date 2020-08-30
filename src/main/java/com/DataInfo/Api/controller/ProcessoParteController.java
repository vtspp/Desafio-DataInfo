package com.DataInfo.Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DataInfo.Api.model.Processo_Parte;
import com.DataInfo.Api.service.Impl.ProcessoParteServiceImpl;

@RestController
public class ProcessoParteController {

	@Autowired
	private ProcessoParteServiceImpl processoParteService;


    @PostMapping("/api/processoParte/save")
    public void saveProcessoParte(Processo_Parte processoParte) {
        processoParteService.save(processoParte);
    }

    @GetMapping("/api/processoParte/all")
    public List<Processo_Parte> findAllProcessoParte() {
        return processoParteService.findAll();
    }
    
    public Processo_Parte findProcesso(Processo_Parte processo) {
    	return null;
    }


}
