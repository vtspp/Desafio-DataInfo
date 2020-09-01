package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.error.ErrorAlreadyRegistered;
import com.DataInfo.Api.error.ErrorNotFound;
import com.DataInfo.Api.model.Classe;
import com.DataInfo.Api.repository.ClasseRepository;
import com.DataInfo.Api.service.ClasseService;

@Service
public class ClasseServiceImpl implements ClasseService<Classe, Long>{
	
	@Autowired
	ClasseRepository classeRepository;

	@Override
	public Classe save(Classe obj) {
		verifyUserAlreadyRegisteredByClasse(obj);
		return classeRepository.save(obj);
	}

	@Override
	public List<Classe> findAll() {
		return classeRepository.findAll();
	}

	@Override
	public Optional<Classe> findById(Long id) {
		verifyExistsById(id);
		return classeRepository.findById(id);
	}
	
	public void verifyExistsById(Long id) {
		if (!classeRepository.existsById(id)) {
			throw new ErrorNotFound("Não foi encontrado o id: " + id);
		}
	}
	
	public void verifyUserAlreadyRegisteredByClasse(Classe obj) {
		if (!classeRepository.existsByClasse(obj)) {
			throw new ErrorAlreadyRegistered("Classe " + obj.getClass().getName() 
					                                   + " já cadastrado na base de dados");
		}
	}

}
