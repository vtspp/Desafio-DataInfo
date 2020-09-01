package com.DataInfo.Api.service;

import java.util.List;
import java.util.Optional;

public interface ProcessoParteService<T, K> extends Services<T, K>{

    public T save(T obj);
    public List<T> findAll();
    public Optional<T> findById(Long id);
}
