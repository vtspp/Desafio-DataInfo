package com.DataInfo.Api.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataInfo.Api.error.ErrorNotFound;
import com.DataInfo.Api.model.Endereco;
import com.DataInfo.Api.model.Parte;
import com.DataInfo.Api.repository.EnderecoParteRepository;
import com.DataInfo.Api.repository.ParteRepository;
import com.DataInfo.Api.service.EnderecoParteService;
import com.DataInfo.Api.util.SimpleApiViaCepConnect;

@Service
public class EnderecoParteServiceImpl implements EnderecoParteService<Endereco, Long>{
	
	@Autowired
	private EnderecoParteRepository enderecoParteRepository;
	
	@Autowired
	ParteRepository parteServiceImpl;

	@Override
	public Endereco save(Endereco obj) {
		//Instancia o obj Parte
		Parte parte = new Parte(obj.getParte().getId(),
				                obj.getParte().getNome(),
				                obj.getParte().getDataNascimento(),
				                obj.getParte().getCpf(),
				                obj.getParte().getTipoParte());
		parteServiceImpl.save(parte);
		
		JsonObject result = SimpleApiViaCepConnect.apiViaCepConnect(obj.getCep());
		
	    String logradouro = result.getString("logradouro").toString();
		String bairro = result.getString("bairro").toString();
		String localidade = result.getString("localidade").toString();
		String uf = result.getString("uf").toString();
		
		// Instancia o obj Endereço e seta com os dados obtidos da API, 
		// desta forma os dados setados ficam presos a resposta da API.
		Endereco endereco = new Endereco(obj.getId(),
				                         obj.setBairro(bairro),
				                         obj.setCidade(localidade),
				                         obj.setEstado(uf),
				                         obj.getCep(),
				                         obj.setLogadouro(logradouro),
				                         obj.getNumero(), parte);
		
		return enderecoParteRepository.save(endereco);
		
	}

	@Override
	public List<Endereco> findAll() {
		return enderecoParteRepository.findAll();
	}

	@Override
	public Optional<Endereco> findById(Long id) {
		verifyExistsById(id);
		return enderecoParteRepository.findById(id);
	}
	
	public void verifyExistsById(Long id) {
		if (!enderecoParteRepository.existsById(id)) {
			throw new ErrorNotFound("Não foi encontrado o id: " + id);
		}

	}

}
