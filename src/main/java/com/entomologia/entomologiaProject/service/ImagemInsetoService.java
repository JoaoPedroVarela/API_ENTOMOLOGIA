package com.entomologia.entomologiaProject.service;

import com.entomologia.entomologiaProject.model.ImagemInseto;
import com.entomologia.entomologiaProject.repository.ImagemInsetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagemInsetoService {
    @Autowired
    ImagemInsetoRepository imagemInsetoRepository;

    public void salvarImagem(ImagemInseto imagemInseto) {
        imagemInsetoRepository.salvarImagem(imagemInseto);
    }

    public Optional<ImagemInseto> retornarPeloId(Long id) {
        return imagemInsetoRepository.buscarPorId(id);
    }

    public List<ImagemInseto> retornarPeloIdInseto(Long idInseto) {
        return imagemInsetoRepository.buscarPorInseto(idInseto);
    }
}
