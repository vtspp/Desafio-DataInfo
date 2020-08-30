package com.DataInfo.Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DataInfo.Api.model.Endereco_Parte;
import com.DataInfo.Api.service.Impl.EnderecoParteServiceImpl;

@RestController
public class EnderecoParteController {

	@Autowired
	private EnderecoParteServiceImpl enderecoParteService;


    @PostMapping("/api/enderecoParte/save")
    public void saveEnderecoParte(Endereco_Parte enderecoParte) {
        enderecoParteService.save(enderecoParte);
    }

    @GetMapping("/api/enderecoParte/all")
    public List<Endereco_Parte> findAllEnderecoParte() {
        return enderecoParteService.findAll();
    }
    
    public Endereco_Parte findProcesso(Endereco_Parte processo) {
    	return null;
    }


}
