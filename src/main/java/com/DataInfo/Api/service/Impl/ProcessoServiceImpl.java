package com.DataInfo.Api.service.Impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
		if (obj.getId() == null) {
			processoRepository.save(obj);
		}
		
		Date date = new Date();
		obj.setNr_Processo(createBodyProcess(obj));
		obj.setData_Criacao(date);
		
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
	
	public String createBodyProcess(Processo processo) {
		
		//Converte o Id para String e armazena em um vetor
		String[] strId = processo.getId().toString().split("");
		
		/* Verifica qual o tamanho do valor da variável */
		int strTam = strId.length;
		
		/* Tamanho padrão */
		String stdFormat = "0000000";
	
		
		/* Gera uma substring retirando a quantidade 
		necessária para manter o tamanho padrão e um novo formato concatenando
		  a substring com o valor do Id já convertido para string*/
		String newStdFormat = stdFormat.substring(0, 7 - strTam)+processo.getId();
		
		
		
		System.out.println(newStdFormat);
		StringBuilder sb = new StringBuilder();
		
		Calendar calendar = Calendar.getInstance();
		int mes = calendar.get(calendar.MONTH) + 1;
		
		StringBuilder sbFormatMes = new StringBuilder();
		
		sbFormatMes = (mes < 10 ) ? sbFormatMes.append("0").append(mes) 
				                  : sbFormatMes.append("");
		
		sb.append(newStdFormat)
		  .append("-")
		  .append(sbFormatMes)
		  .append(".")
		  .append(calendar.get(calendar.YEAR))
		  .append(".")
		  .append("811");
		
		
		return sb.toString();
		
	}

}
