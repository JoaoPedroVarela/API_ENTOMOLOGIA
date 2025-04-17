package com.entomologia.entomologiaProject.model;

public class ImagemInseto {
    private Long id;
    private Long idInseto;
    private String nomeArquivo;
    private String tipo;
    private byte[] dados;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdInseto() {
        return idInseto;
    }

    public void setIdInseto(Long idInseto) {
        this.idInseto = idInseto;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getDados() {
        return dados;
    }

    public void setDados(byte[] dados) {
        this.dados = dados;
    }
}
