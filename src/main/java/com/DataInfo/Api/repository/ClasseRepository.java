package com.DataInfo.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DataInfo.Api.model.Classe;

public interface ClasseRepository extends Repositories<Classe, Long>, JpaRepository<Classe, Long> {

}
