package com.DataInfo.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DataInfo.Api.model.EnderecoParte;

public interface EnderecoParteRepository extends Repositories<EnderecoParte, Long>, JpaRepository<EnderecoParte, Long>{

}
