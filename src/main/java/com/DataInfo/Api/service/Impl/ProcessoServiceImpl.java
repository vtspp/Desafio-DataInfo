package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.error.ErrorNotFound;
import com.DataInfo.Api.model.Processo;
import com.DataInfo.Api.repository.ProcessoRepository;
import com.DataInfo.Api.service.ProcessoService;

@Service
public class ProcessoServiceImpl implements ProcessoService<Processo, Long>{
	
	@Autowired
	ProcessoRepository processoRepository;

	@Override
	public Processo save(Processo obj) {
		return processoRepository.save(obj);
	}

	@Override
	public List<Processo> findAll() {
		return processoRepository.findAll();
	}

	@Override
	public Optional<Processo> findById(Long id) {
		verifyExistsById(id);
		return processoRepository.findById(id);
	}
	
	public void verifyExistsById(Long id) {
		if (!processoRepository.existsById(id)) {
			throw new ErrorNotFound("Não foi encontrado o id: " + id);
		}

	}

}
