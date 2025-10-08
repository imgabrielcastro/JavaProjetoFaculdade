package br.com.backend.projetoexemplo.model;

import jakarta.persistence.Entity;

@Entity
public class Fornecedor extends Pessoa {

    private String empresa;

    public Fornecedor() {}

    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
}