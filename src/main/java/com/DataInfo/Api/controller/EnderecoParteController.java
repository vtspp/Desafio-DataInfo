package com.DataInfo.Api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DataInfo.Api.model.Endereco;
import com.DataInfo.Api.service.Impl.EnderecoParteServiceImpl;

@RestController
@RequestMapping("/enderecos")
public class EnderecoParteController {

	@Autowired
	private EnderecoParteServiceImpl enderecoParteService;


	    @PostMapping
	    public ResponseEntity<Endereco> save(@RequestBody Endereco endereco) {
	        return new ResponseEntity<>(enderecoParteService.save(endereco), HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<Endereco>> findAll() {
	    	return new ResponseEntity<>(enderecoParteService.findAll(), HttpStatus.OK);
	    }
	    
	    @GetMapping(path = "/{id}")
	    public ResponseEntity<Optional<Endereco>> findById(@PathVariable Long id) {
	    	return new ResponseEntity<>(enderecoParteService.findById(id), HttpStatus.FOUND);
	    }


}
