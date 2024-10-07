package com.entomologia.entomologiaProject.repository;

import java.util.List;
import java.util.Optional;

public interface RepositoryPattern<T> {
    void save(T tClass);
    void update(T entity); // Atualizar entidade
    void delete(Long id); // Deletar entidade por ID
    Optional<T> findById(Long id); // Encontrar entidade por ID
    List<T> findAll(); // Encontrar todas as entidades
}
