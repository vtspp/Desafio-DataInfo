package com.DataInfo.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DataInfo.Api.model.ProcessoParte;

public interface ProcessoParteRepository extends Repositories<ProcessoParte, Long>, JpaRepository<ProcessoParte, Long> {
}
