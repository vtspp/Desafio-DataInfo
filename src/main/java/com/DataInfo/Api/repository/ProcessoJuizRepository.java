package com.DataInfo.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DataInfo.Api.model.Processo_Juiz;

public interface ProcessoJuizRepository extends Repositories<Processo_Juiz, Long>, JpaRepository<Processo_Juiz, Long>{
}
