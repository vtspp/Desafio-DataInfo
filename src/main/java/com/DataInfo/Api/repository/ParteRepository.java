package com.DataInfo.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DataInfo.Api.model.Parte;

public interface ParteRepository extends Repositories<Parte, Long>, JpaRepository<Parte, Long>{
}
