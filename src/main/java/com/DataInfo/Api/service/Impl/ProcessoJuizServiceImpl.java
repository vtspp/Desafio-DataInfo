package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.model.Processo_Juiz;
import com.DataInfo.Api.repository.Impl.ProcessoJuizRepositoryImpl;
import com.DataInfo.Api.service.ProcessoJuizService;

@Service
public class ProcessoJuizServiceImpl implements ProcessoJuizService<Processo_Juiz, Long>{
	
	@Autowired
	private ProcessoJuizRepositoryImpl processoJuizRepository;

	@Override
	public void save(Processo_Juiz obj) {
		processoJuizRepository.save(obj);
		
	}

	@Override
	public List<Processo_Juiz> findAll() {
		return processoJuizRepository.findAll();
	}

	@Override
	public Optional<Processo_Juiz> find(Long id) {
		return processoJuizRepository.findById(id);
	}

}
