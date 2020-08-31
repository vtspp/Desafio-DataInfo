package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.model.Processo;
import com.DataInfo.Api.repository.ProcessoRepository;
import com.DataInfo.Api.service.ProcessoService;

@Service
public class ProcessoServiceImpl implements ProcessoService<Processo, Long>{
	
	@Autowired
	ProcessoRepository processoRepository;

	@Override
	public void save(Processo obj) {
		processoRepository.save(obj);
	}

	@Override
	public List<Processo> findAll() {
		return processoRepository.findAll();
	}

	@Override
	public Optional<Processo> find(Long id) {
		return processoRepository.findById(id);
	}

}
