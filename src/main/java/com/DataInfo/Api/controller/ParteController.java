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

import com.DataInfo.Api.model.Parte;
import com.DataInfo.Api.service.Impl.ParteServiceImpl;

@RestController
@RequestMapping("/partes")
public class ParteController {

	@Autowired
	private ParteServiceImpl parteService;


    @PostMapping
    public ResponseEntity<Parte> save(@RequestBody Parte parte) {
        return new ResponseEntity<>(parteService.save(parte), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Parte>> findAll() {
    	return new ResponseEntity<>(parteService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Parte>> findById(@PathVariable Long id) {
    	return new ResponseEntity<>(parteService.findById(id), HttpStatus.FOUND);
    }


}
