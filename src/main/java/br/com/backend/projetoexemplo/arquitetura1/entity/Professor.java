package br.com.backend.projetoexemplo.arquitetura1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "professores")
public class Professor extends Pessoa{

    @Column(name = "salario", columnDefinition = "DECIMAL(10, 2) DEFAULT 0.0")
    private Double salario;

    public Professor() {
    }


    public Professor(Integer id, String nome, Double salario) {
        super(id, nome);
        this.salario = salario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "salario=" + salario +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
