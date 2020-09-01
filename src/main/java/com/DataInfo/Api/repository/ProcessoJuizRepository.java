package com.DataInfo.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DataInfo.Api.model.ProcessoJuiz;

public interface ProcessoJuizRepository extends Repositories<ProcessoJuiz, Long>, JpaRepository<ProcessoJuiz, Long>{
}
