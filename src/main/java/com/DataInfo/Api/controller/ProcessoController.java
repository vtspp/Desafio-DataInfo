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

import com.DataInfo.Api.model.Processo;
import com.DataInfo.Api.service.Impl.ProcessoServiceImpl;

@RestController
@RequestMapping("/processos")
public class ProcessoController {

	@Autowired
	private ProcessoServiceImpl processoService;


	    @PostMapping
	    public ResponseEntity<Processo> save(@RequestBody Processo processo) {
	        return new ResponseEntity<>(processoService.save(processo), HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<Processo>> findAll() {
	    	return new ResponseEntity<>(processoService.findAll(), HttpStatus.OK);
	    }
	    
	    @GetMapping(path = "/{id}")
	    public ResponseEntity<Optional<Processo>> findById(@PathVariable Long id) {
	    	return new ResponseEntity<>(processoService.findById(id), HttpStatus.FOUND);
	    }


}
