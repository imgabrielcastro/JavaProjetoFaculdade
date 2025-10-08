package br.com.backend.projetoexemplo.model;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Pessoa {

    private String telefone;

    public Cliente() {}

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}