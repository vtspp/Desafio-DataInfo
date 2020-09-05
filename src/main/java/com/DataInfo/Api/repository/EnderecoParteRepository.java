package com.DataInfo.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DataInfo.Api.model.Endereco;

public interface EnderecoParteRepository extends Repositories<Endereco, Long>, JpaRepository<Endereco, Long>{

}
