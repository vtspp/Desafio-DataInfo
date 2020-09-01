package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.model.Parte;
import com.DataInfo.Api.repository.ParteRepository;
import com.DataInfo.Api.service.ParteService;

@Service
public class ParteServiceImpl implements ParteService<Parte, Long>{
	
	@Autowired
	ParteRepository parteRepository;
	
	@Autowired
	EnderecoParteServiceImpl enderecoParteServiceImpl;
	
	@Override
	public Parte save(Parte obj) {
		return parteRepository.save(obj);
	}

	@Override
	public List<Parte> findAll() {
		return parteRepository.findAll();
	}

	@Override
	public Optional<Parte> findById(Long id) {
		return parteRepository.findById(id);
	}

}
