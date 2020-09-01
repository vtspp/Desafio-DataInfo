package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.error.ErrorNotFound;
import com.DataInfo.Api.error.ErrorAlreadyRegistered;
import com.DataInfo.Api.model.Juiz;
import com.DataInfo.Api.repository.JuizRepository;
import com.DataInfo.Api.service.JuizService;

@Service
public class JuizServiceImpl implements JuizService<Juiz, Long> {

	@Autowired
	JuizRepository juizRepository;

	@Override
	public Juiz save(Juiz obj) {
		verifyUserAlreadyRegisteredByCpf(obj);
		return juizRepository.save(obj);
	}

	@Override
	public List<Juiz> findAll() {
		return juizRepository.findAll();
	}

	@Override
	public Optional<Juiz> findById(Long id) {
		verifyExistsById(id);
		return juizRepository.findById(id);
	}

	public void verifyExistsById(Long id) {
		if (!juizRepository.existsById(id)) {
			throw new ErrorNotFound("Não foi encontrado o id: " + id);
		}

	}
	
	public void verifyUserAlreadyRegisteredByCpf(Juiz obj) {
		if (!juizRepository.existsByCpf(obj.getCpf())) {
			throw new ErrorAlreadyRegistered("Cpf " + obj.getCpf() + " já cadastrado na base de dados");
		}
	}
}
