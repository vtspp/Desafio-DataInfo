package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.error.ErrorNotFound;
import com.DataInfo.Api.model.EnderecoParte;
import com.DataInfo.Api.repository.EnderecoParteRepository;
import com.DataInfo.Api.service.EnderecoParteService;
import com.DataInfo.Api.util.SimpleApiViaCepConnect;

@Service
public class EnderecoParteServiceImpl implements EnderecoParteService<EnderecoParte, Long>{
	
	@Autowired
	private EnderecoParteRepository enderecoParteRepository;

	@Override
	public EnderecoParte save(EnderecoParte obj) {
		JsonObject result = SimpleApiViaCepConnect.apiViaCepConnect(obj.getCep());
		obj.setLogadouro(result.getString("logradouro"));
		obj.setBairro(result.getString("bairro"));
		obj.setCidade(result.getString("localidade"));
		obj.setEstado(result.getString("uf"));
	
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
		if (enderecoParteRepository.existsById(id)) {
			throw new ErrorNotFound("Não foi encontrado o id: " + id);
		}

	}

}
