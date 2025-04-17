package com.entomologia.entomologiaProject.controller;

import com.entomologia.entomologiaProject.model.Coletor;
import com.entomologia.entomologiaProject.service.ColetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coletor")
public class ColetorController {

    @Autowired
    ColetorService coletorService;

    @PostMapping
    public ResponseEntity<String> cadastrarColetor(@RequestBody Coletor coletor) {
        coletorService.inserir(coletor);
        return ResponseEntity.ok("Coletor cadastrado com sucesso");
    }

    @PutMapping
    public ResponseEntity<String> atualizarColetor(@RequestBody Coletor coletor) {
        coletorService.atualizar(coletor);
        return ResponseEntity.ok("Coletor atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarColetor(@PathVariable Long id) {
        coletorService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Coletor>> pegarPeloId(@PathVariable Long id) {
        return ResponseEntity.ok(coletorService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Coletor>> pegarTodosColetores() {
        return ResponseEntity.ok(coletorService.findAll());
    }
}
