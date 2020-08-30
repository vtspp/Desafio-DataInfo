package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.model.Juiz;
import com.DataInfo.Api.repository.Impl.JuizRepositoryImpl;
import com.DataInfo.Api.service.JuizService;

@Service
public class juizServiceImpl implements JuizService<Juiz, Long>{
	
	@Autowired
	private JuizRepositoryImpl juizRepository;

	@Override
	public void save(Juiz obj) {
		juizRepository.save(obj);
		
	}

	@Override
	public List<Juiz> findAll() {
		return juizRepository.findAll();
	}

	@Override
	public Optional<Juiz> find(Long id) {
		return juizRepository.findById(id);
	}

}
