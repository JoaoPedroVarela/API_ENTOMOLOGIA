package com.entomologia.entomologiaProject.service;

import com.entomologia.entomologiaProject.model.Insetos;
import com.entomologia.entomologiaProject.repository.InsetosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsetosService {

    @Autowired
    InsetosRepository insetosRepository;

    public void save(Insetos insetos) {
        insetosRepository.save(insetos);
    }

    public void update(Insetos insetos) {
        insetosRepository.update(insetos);
    }

    public void delete(Long id) {
        insetosRepository.delete(id);
    }

    public Optional<Insetos> findById(Long id) {
        return insetosRepository.findById(id);
    }

    public List<Insetos> findAll() {
        return insetosRepository.findAll();
    }
}
