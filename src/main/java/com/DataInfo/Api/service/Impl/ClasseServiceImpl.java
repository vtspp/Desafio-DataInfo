package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.model.Classe;
import com.DataInfo.Api.repository.ClasseRepository;
import com.DataInfo.Api.service.ClasseService;

@Service
public class ClasseServiceImpl implements ClasseService<Classe, Long>{
	
	@Autowired
	ClasseRepository classeRepository;

	@Override
	public void save(Classe obj) {
		classeRepository.save(obj);
	}

	@Override
	public List<Classe> findAll() {
		return classeRepository.findAll();
	}

	@Override
	public Optional<Classe> find(Long id) {
		return classeRepository.findById(id);
	}

}
