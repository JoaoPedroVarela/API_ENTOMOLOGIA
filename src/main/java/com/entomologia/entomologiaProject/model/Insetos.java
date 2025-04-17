package com.entomologia.entomologiaProject.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "modelo que representa um inseto")
public class Insetos {

    @Schema(description = "Nome do animal coletado", example = "Besouro-hércules")
    private String nome;

    @Schema(description = "Nome do local da coleta", example = "Vila Velha")
    private String localColeta;

    @Schema(description = "Data da coleta", example = "YYYY-MM-DD")
    private LocalDate dataColeta;

    @Schema(description = "Tag do inseto", example = "USYE1468TDH")
    private String tag;

    @Schema(description = "Familia do Inseto", example = "Scarabaeidae")
    private String familia;

    @Schema(description = "Genêro do Inseto", example = "Dynastes")
    private String genero;

    @Schema(description = "Ordem do Inseto", example = "Coleoptera")
    private String ordem;

    @Schema(description = "Id do inseto")
    private Long id;

    @Schema(description = "Id do coletor")
    private Long idColetor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdColetor() {
        return idColetor;
    }

    public void setIdColetor(Long idColetor) {
        this.idColetor = idColetor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalColeta() {
        return localColeta;
    }

    public void setLocalColeta(String localColeta) {
        this.localColeta = localColeta;
    }

    public LocalDate getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(LocalDate dataColeta) {
        this.dataColeta = dataColeta;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }
}
