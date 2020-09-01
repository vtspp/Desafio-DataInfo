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

import com.DataInfo.Api.model.ProcessoJuiz;
import com.DataInfo.Api.service.Impl.ProcessoJuizServiceImpl;

@RestController
@RequestMapping("/processos_juizes")
public class ProcessoJuizController {

	@Autowired
	private ProcessoJuizServiceImpl processoJuizService;


	    @PostMapping
	    public ResponseEntity<ProcessoJuiz> save(@RequestBody ProcessoJuiz processo) {
	        return new ResponseEntity<>(processoJuizService.save(processo), HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<ProcessoJuiz>> findAll() {
	    	return new ResponseEntity<>(processoJuizService.findAll(), HttpStatus.OK);
	    }
	    
	    @GetMapping(path = "/{id}")
	    public ResponseEntity<Optional<ProcessoJuiz>> findById(@PathVariable Long id) {
	    	return new ResponseEntity<>(processoJuizService.findById(id), HttpStatus.FOUND);
	    }


}
