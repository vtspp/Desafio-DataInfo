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

import com.DataInfo.Api.model.Juiz;
import com.DataInfo.Api.service.Impl.JuizServiceImpl;

@RestController
@RequestMapping("/juizes")
public class JuizController {

	@Autowired
	private JuizServiceImpl juizService;


	    @PostMapping
	    public ResponseEntity<Juiz> save(@RequestBody Juiz juiz) {
	        return new ResponseEntity<>(juizService.save(juiz), HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<Juiz>> findAll() {
	    	return new ResponseEntity<>(juizService.findAll(), HttpStatus.OK);
	    }
	    
	    @GetMapping(path = "/{id}")
	    public ResponseEntity<Optional<Juiz>> findById(@PathVariable Long id) {
	    	return new ResponseEntity<>(juizService.findById(id), HttpStatus.FOUND);
	    }


}
