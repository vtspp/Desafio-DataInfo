package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.model.Processo_Parte;
import com.DataInfo.Api.repository.Impl.ProcessoParteRepositoryImpl;
import com.DataInfo.Api.service.ProcessoParteService;

@Service
public class ProcessoParteServiceImpl implements ProcessoParteService<Processo_Parte, Long>{
	
	@Autowired
	private ProcessoParteRepositoryImpl processoParteRepository;

	@Override
	public void save(Processo_Parte obj) {
		processoParteRepository.save(obj);
		
	}

	@Override
	public List<Processo_Parte> findAll() {
		return processoParteRepository.findAll();
	}

	@Override
	public Optional<Processo_Parte> find(Long id) {
		return processoParteRepository.findById(id);
	}

}
