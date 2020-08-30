package com.DataInfo.Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DataInfo.Api.model.Parte;
import com.DataInfo.Api.service.Impl.ParteServiceImpl;

@RestController
public class ParteController {

	@Autowired
	private ParteServiceImpl parteService;


    @PostMapping("/api/parte/save")
    public void saveParte(Parte parte) {
        parteService.save(parte);
    }

    @GetMapping("/api/parte/all")
    public List<Parte> findAllParte() {
        return parteService.findAll();
    }
    
    public Parte findProcesso(Parte processo) {
    	return null;
    }


}
