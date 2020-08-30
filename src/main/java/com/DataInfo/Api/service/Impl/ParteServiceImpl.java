package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.model.Parte;
import com.DataInfo.Api.repository.Impl.ParteRepositoryImpl;
import com.DataInfo.Api.service.ParteService;

@Service
public class ParteServiceImpl implements ParteService<Parte, Long>{
	
	@Autowired
	private ParteRepositoryImpl parteRepository;

	@Override
	public void save(Parte obj) {
		parteRepository.save(obj);
		
	}

	@Override
	public List<Parte> findAll() {
		return parteRepository.findAll();
	}

	@Override
	public Optional<Parte> find(Long id) {
		return parteRepository.findById(id);
	}

}
