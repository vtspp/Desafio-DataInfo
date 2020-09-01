package com.DataInfo.Api.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.DataInfo.Api.model.Classe;
import com.DataInfo.Api.service.Impl.ClasseServiceImpl;

@Configuration
public class DataBaseSeeding implements CommandLineRunner {
	
	@Autowired
	private ClasseServiceImpl classeService;

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
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
