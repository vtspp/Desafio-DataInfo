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
import com.DataInfo.Api.model.Endereco;
import com.DataInfo.Api.model.Parte;
import com.DataInfo.Api.model.Processo;
import com.DataInfo.Api.service.Impl.ClasseServiceImpl;
import com.DataInfo.Api.service.Impl.EnderecoParteServiceImpl;
import com.DataInfo.Api.service.Impl.ParteServiceImpl;
import com.DataInfo.Api.service.Impl.ProcessoServiceImpl;

@Configuration
public class DataBaseSeeding implements CommandLineRunner {
	
	@Autowired
	private ClasseServiceImpl classeService;
	
	@Autowired
	private ParteServiceImpl parteServiceImpl; 
	
	@Autowired
	private EnderecoParteServiceImpl enderecoParteImpl;
	
	@Autowired
	private ProcessoServiceImpl processoServiceImpl;

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
			/*
			
			// Testes de composição entre objetos
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Parte parte = new Parte(null, "teste", sdf.parse("14/06/1989"), "12312312303", "Desenvolvedor Java");
			
			Parte parte2 = new Parte(null, "teste", sdf.parse("14/06/1989"), "12312312304", "Desenvolvedor Java");
			parteServiceImpl.save(parte);
			parteServiceImpl.save(parte2);
			
			EnderecoParte endereco = new EnderecoParte(null, "São Gonçalo", "Rio de Janeiro", 
					                                         "RJ", "24800185", "Rua Conde de Bonfim", 120, parte);
			
			EnderecoParte endereco2 = new EnderecoParte(null, "São Gonçalo", "Rio de Janeiro", 
                    "RJ", "24800185", "Rua Conde de Bonfim", 120, parte2);
			
		    enderecoParteImpl.save(endereco);
		    enderecoParteImpl.save(endereco2);
		    */
		    /*// Obrigatorio a inclusão de uma classe ao instanciar um processo
		    Classe classe = new Classe(100L, "", "", "", ""); 
		    classeService.save(classe);
		    Processo processo = new Processo(null, null, null, null, classe);
		    processoServiceImpl.save(processo);
		    System.out.println(processo.toString());*/
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
