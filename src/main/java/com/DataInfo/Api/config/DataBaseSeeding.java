package com.DataInfo.Api.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.DataInfo.Api.model.Classe;
import com.DataInfo.Api.model.Endereco_Parte;
import com.DataInfo.Api.model.Parte;
import com.DataInfo.Api.service.Impl.ClasseServiceImpl;
import com.DataInfo.Api.service.Impl.EnderecoParteServiceImpl;
import com.DataInfo.Api.service.Impl.JuizServiceImpl;
import com.DataInfo.Api.service.Impl.ParteServiceImpl;
import com.DataInfo.Api.service.Impl.ProcessoServiceImpl;

@Configuration
public class DataBaseSeeding implements CommandLineRunner {
	
	@Autowired
	private ClasseServiceImpl classeService;
	
	@Autowired
	private EnderecoParteServiceImpl enderecoService;
	
	@Autowired
	private JuizServiceImpl juizService;
	
	@Autowired
	private ParteServiceImpl parteService;
	
	@Autowired
	private ProcessoServiceImpl processoService;

	@Override
	public void run(String... args) throws Exception {
		
		String path = "TABELA_DE_CLASSES_ATIVAS.csv";
		
try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			
			String lineHeader = bufferedReader.readLine();
			String lineBody = bufferedReader.readLine();
			
			while (lineBody != null) {

				String[] vet = lineBody.split(",");
				
				Classe classe = new Classe(Long.parseLong(vet[0]), 
                                                          vet[1], 
                                                          vet[2], 
                                                          vet[3], 
                                                          vet[4]);

				classeService.save(classe);

				lineBody = bufferedReader.readLine();
			}
			
			System.out.println("Application initialized with:" + path);
			
			//Entidades
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Parte parte = new Parte(null, "Nicholas", 
					                      sdf.parse("04/10/2019"), 
					                      "13413413403", "Filho");
			
			parteService.save(parte);
			
			Endereco_Parte endereco = new Endereco_Parte(null, "Santa Isabel",
					                                           "São Gonçalo", 
					                                           "RJ",
					                                           "24750600", 
					                                           "Apt 201", 
					                                           1, parte);
			enderecoService.save(endereco);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
