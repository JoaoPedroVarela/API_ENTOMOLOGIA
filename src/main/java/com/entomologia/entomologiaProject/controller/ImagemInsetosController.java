package com.entomologia.entomologiaProject.controller;

import com.entomologia.entomologiaProject.model.ImagemInseto;
import com.entomologia.entomologiaProject.repository.ImagemInsetoRepository;
import com.entomologia.entomologiaProject.service.ImagemInsetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/imagens")
public class ImagemInsetosController {

    @Autowired
    private ImagemInsetoService imagemInsetoService;

    @PostMapping(value = "/{idInseto}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImagem(
            @PathVariable Long idInseto,
            @RequestPart("arquivo") MultipartFile arquivo) {
        try {
            ImagemInseto imagem = new ImagemInseto();
            imagem.setIdInseto(idInseto);
            imagem.setNomeArquivo(arquivo.getOriginalFilename());
            imagem.setTipo(arquivo.getContentType());
            imagem.setDados(arquivo.getBytes());

            imagemInsetoService.salvarImagem(imagem);

            return ResponseEntity.ok("Imagem enviada com sucesso!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar imagem.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImagem(@PathVariable Long id) {
        ImagemInseto imagem = imagemInsetoService.retornarPeloId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Imagem não encontrada"));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(imagem.getTipo()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imagem.getNomeArquivo() + "\"")
                .body(imagem.getDados());
    }

    @GetMapping("/inseto/{idInseto}")
    public ResponseEntity<List<ImagemInseto>> getImagensPorInseto(@PathVariable Long idInseto) {
        List<ImagemInseto> imagens = imagemInsetoService.retornarPeloIdInseto(idInseto);
        return ResponseEntity.ok(imagens);
    }
}
