package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.model.ProcessoParte;
import com.DataInfo.Api.repository.ProcessoParteRepository;
import com.DataInfo.Api.service.ProcessoParteService;

@Service
public class ProcessoParteServiceImpl implements ProcessoParteService<ProcessoParte, Long>{
	
	@Autowired
	ProcessoParteRepository ProcessoParteRepository;

	@Override
	public ProcessoParte save(ProcessoParte obj) {
		return ProcessoParteRepository.save(obj);
	}

	@Override
	public List<ProcessoParte> findAll() {
		return ProcessoParteRepository.findAll();
	}

	@Override
	public Optional<ProcessoParte> findById(Long id) {
		return ProcessoParteRepository.findById(id);
	}

}
