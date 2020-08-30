package com.DataInfo.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DataInfo.Api.model.Processo;

public interface ProcessoRepository extends Repositories<Processo, Long>, JpaRepository<Processo, Long>{
}
