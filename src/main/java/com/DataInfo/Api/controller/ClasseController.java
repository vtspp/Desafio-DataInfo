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

import com.DataInfo.Api.model.Classe;
import com.DataInfo.Api.service.Impl.ClasseServiceImpl;

@RestController
@RequestMapping("/classes")
public class ClasseController {

	@Autowired
	private ClasseServiceImpl classeService;


	    @PostMapping
	    public ResponseEntity<Classe> save(@RequestBody Classe Classe) {
	        return new ResponseEntity<>(classeService.save(Classe), HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<Classe>> findAll() {
	    	return new ResponseEntity<>(classeService.findAll(), HttpStatus.OK);
	    }
	    
	    @GetMapping(path = "/{id}")
	    public ResponseEntity<Optional<Classe>> findById(@PathVariable Long id) {
	    	return new ResponseEntity<>(classeService.findById(id), HttpStatus.FOUND);
	    }


}
