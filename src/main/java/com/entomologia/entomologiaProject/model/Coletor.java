package com.entomologia.entomologiaProject.model;

public class Coletor {

    private Long idColetor;
    private String nomeColetor;
    private String cpfColetor;

    public Coletor() {
    }

    public Coletor(Long idColetor, String cpfColetor, String nomeColetor) {
        this.idColetor = idColetor;
        this.cpfColetor = cpfColetor;
        this.nomeColetor = nomeColetor;
    }

    public String getNomeColetor() {
        return nomeColetor;
    }

    public void setNomeColetor(String nomeColetor) {
        this.nomeColetor = nomeColetor;
    }

    public String getCpfColetor() {
        return cpfColetor;
    }

    public void setCpfColetor(String cpfColetor) {
        this.cpfColetor = cpfColetor;
    }

    public Long getIdColetor() {
        return idColetor;
    }

    public void setIdColetor(Long idColetor) {
        this.idColetor = idColetor;
    }
}
