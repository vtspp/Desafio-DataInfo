package com.DataInfo.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DataInfo.Api.model.Juiz;

public interface JuizRepository extends Repositories<Juiz, Long>, JpaRepository<Juiz, Long>{
}
