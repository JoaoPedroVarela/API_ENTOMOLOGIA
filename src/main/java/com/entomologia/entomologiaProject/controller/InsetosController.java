package com.entomologia.entomologiaProject.controller;

import com.entomologia.entomologiaProject.model.Insetos;
import com.entomologia.entomologiaProject.service.InsetosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/insetos")
public class InsetosController {

    @Autowired
    InsetosService insetosService;

    @Operation(summary = "Cria um novo inseto", description = "Adiciona um novo inseto ao banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Inseto criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição")
    })
    @PostMapping // Endpoint para criar um novo inseto
    public ResponseEntity<Insetos> create(@RequestBody Insetos insetos) {
        insetosService.save(insetos);
        return new ResponseEntity<>(insetos, HttpStatus.CREATED);
    }

    @Operation(summary = "Edita um inseto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inseto editado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição")
    })
    @PutMapping() // Endpoint para atualizar um inseto existente
    public ResponseEntity<Insetos> updateInseto(@RequestBody Insetos insetos) {
        insetosService.update(insetos); // Atualiza o inseto
        return ResponseEntity.ok(insetos);
    }


    @Operation(summary = "Deleta inseto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deletado"),
            @ApiResponse(responseCode = "400", description = "Erro no delete")
    })
    @DeleteMapping("/{id}") // Endpoint para deletar um inseto
    public ResponseEntity<Void> delete(@Parameter(description = "ID do inseto a ser deletado", required = true)@PathVariable Long id) {
        insetosService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @Operation(summary = "Busca um inseto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inseto encontrado"),
            @ApiResponse(responseCode = "404", description = "Inseto não encontrado")
    })
    @GetMapping("/{id}") // Endpoint para buscar um inseto por ID
    public ResponseEntity<Insetos> findById(@Parameter(description = "ID do inseto a ser buscado", required = true)@PathVariable Long id) {
        return insetosService.findById(id)
                .map(insetos -> new ResponseEntity<>(insetos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @Operation(summary = "Buscar todos os insetos, colocar o id no request pra quem quiser editar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Insetos encontrados"),
            @ApiResponse(responseCode = "404", description = "Insetos não encontrados")
    })
    @GetMapping // Endpoint para buscar todos os insetos
    public ResponseEntity<List<Insetos>> findAll() {
        List<Insetos> insetosList = insetosService.findAll();
        return new ResponseEntity<>(insetosList, HttpStatus.OK);
    }

}
