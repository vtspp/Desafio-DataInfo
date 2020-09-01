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

import com.DataInfo.Api.model.ProcessoParte;
import com.DataInfo.Api.service.Impl.ProcessoParteServiceImpl;

@RestController
@RequestMapping("/processo_partes")
public class ProcessoParteController {

	@Autowired
	private ProcessoParteServiceImpl processoParteService;


	    @PostMapping
	    public ResponseEntity<ProcessoParte> save(@RequestBody ProcessoParte ProcessoParte) {
	        return new ResponseEntity<>(processoParteService.save(ProcessoParte), HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<ProcessoParte>> findAll() {
	    	return new ResponseEntity<>(processoParteService.findAll(), HttpStatus.OK);
	    }
	    
	    @GetMapping(path = "/{id}")
	    public ResponseEntity<Optional<ProcessoParte>> findById(@PathVariable Long id) {
	    	return new ResponseEntity<>(processoParteService.findById(id), HttpStatus.FOUND);
	    }


}
