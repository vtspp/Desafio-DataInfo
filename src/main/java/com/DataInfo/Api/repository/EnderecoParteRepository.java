package com.DataInfo.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DataInfo.Api.model.Endereco_Parte;

public interface EnderecoParteRepository extends Repositories<Endereco_Parte, Long>, JpaRepository<Endereco_Parte, Long>{
}
