package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.error.ErrorNotFound;
import com.DataInfo.Api.model.EnderecoParte;
import com.DataInfo.Api.model.Parte;
import com.DataInfo.Api.repository.EnderecoParteRepository;
import com.DataInfo.Api.service.EnderecoParteService;

@Service
public class EnderecoParteServiceImpl implements EnderecoParteService<EnderecoParte, Long>{
	
	@Autowired
	private EnderecoParteRepository enderecoParteRepository;
	
	@Autowired
	private ParteServiceImpl parteServiceImpl;

	@Override
	public EnderecoParte save(EnderecoParte obj) {
		
		Parte parte = new Parte(null, obj.getParte().getNome(),
				                      obj.getParte().getDataNascimento(),
				                      obj.getParte().getCpf(), 
				                      obj.getParte().getTipoParte());

		obj.setParte(parteServiceImpl.save(parte));
		return enderecoParteRepository.save(obj);
	}

	@Override
	public List<EnderecoParte> findAll() {
		return enderecoParteRepository.findAll();
	}

	@Override
	public Optional<EnderecoParte> findById(Long id) {
		verifyExistsById(id);
		return enderecoParteRepository.findById(id);
	}
	
	public void verifyExistsById(Long id) {
		if (!enderecoParteRepository.existsById(id)) {
			throw new ErrorNotFound("Não foi encontrado o id: " + id);
		}

	}

}
