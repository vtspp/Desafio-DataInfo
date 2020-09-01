package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.error.ErrorNotFound;
import com.DataInfo.Api.error.ErrorAlreadyRegistered;
import com.DataInfo.Api.model.Parte;
import com.DataInfo.Api.repository.ParteRepository;
import com.DataInfo.Api.service.ParteService;

@Service
public class ParteServiceImpl implements ParteService<Parte, Long>{
	
	@Autowired
	ParteRepository parteRepository;
	
	@Override
	public Parte save(Parte obj) {
		verifyUserAlreadyRegisteredByCpf(obj);
		return parteRepository.save(obj);
	}

	@Override
	public List<Parte> findAll() {
		return parteRepository.findAll();
	}

	@Override
	public Optional<Parte> findById(Long id) {
		verifyExistsById(id);
		return parteRepository.findById(id);
	}
	
	public void verifyExistsById(Long id) {
		if (!parteRepository.existsById(id)) {
			throw new ErrorNotFound("Não foi encontrado o id: " + id);
		}

	}
	
	public void verifyUserAlreadyRegisteredByCpf(Parte obj) {
		if (parteRepository.existsByCpf(obj.getCpf())) {
			throw new ErrorAlreadyRegistered("Cpf " + obj.getCpf() + " já cadastrado na base de dados");
		}
	}

}
