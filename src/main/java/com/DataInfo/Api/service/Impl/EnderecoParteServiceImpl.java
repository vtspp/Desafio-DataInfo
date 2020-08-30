package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.model.Endereco_Parte;
import com.DataInfo.Api.repository.Impl.EnderecoParteRepositoryImpl;
import com.DataInfo.Api.service.EnderecoParteService;

@Service
public class EnderecoParteServiceImpl implements EnderecoParteService<Endereco_Parte, Long>{
	
	@Autowired
	private EnderecoParteRepositoryImpl enderecoParteRepository;

	@Override
	public void save(Endereco_Parte obj) {
		enderecoParteRepository.save(obj);
		
	}

	@Override
	public List<Endereco_Parte> findAll() {
		return enderecoParteRepository.findAll();
	}

	@Override
	public Optional<Endereco_Parte> find(Long id) {
		return enderecoParteRepository.findById(id);
	}

}
