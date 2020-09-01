package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.model.ProcessoJuiz;
import com.DataInfo.Api.repository.ProcessoJuizRepository;
import com.DataInfo.Api.service.ProcessoJuizService;

@Service
public class ProcessoJuizServiceImpl implements ProcessoJuizService<ProcessoJuiz, Long>{
	
	@Autowired
	ProcessoJuizRepository processoJuizRepository;

	@Override
	public ProcessoJuiz save(ProcessoJuiz obj) {
		return processoJuizRepository.save(obj);
	}

	@Override
	public List<ProcessoJuiz> findAll() {
		return processoJuizRepository.findAll();
	}

	@Override
	public Optional<ProcessoJuiz> findById(Long id) {
		return processoJuizRepository.findById(id);
	}

}
