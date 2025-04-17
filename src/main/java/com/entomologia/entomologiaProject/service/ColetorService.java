package com.entomologia.entomologiaProject.service;

import com.entomologia.entomologiaProject.model.Coletor;
import com.entomologia.entomologiaProject.repository.ColetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColetorService {

    @Autowired
    ColetorRepository coletorRepository;

    public void inserir(Coletor coletor) {
        coletorRepository.save(coletor);
    }

    public void atualizar(Coletor coletor) {
        coletorRepository.update(coletor);
    }

    public void deletar(Long idColetor) {
        coletorRepository.delete(idColetor);
    }

    public Optional<Coletor> findById(Long idColetor) {
        return coletorRepository.findById(idColetor);
    }

    public List<Coletor> findAll() {
        return coletorRepository.findAll();
    }
}
