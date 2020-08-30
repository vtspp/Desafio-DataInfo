package com.DataInfo.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DataInfo.Api.model.Processo_Parte;

public interface ProcessoParteRepository extends Repositories<Processo_Parte, Long>, JpaRepository<Processo_Parte, Long>{
}
