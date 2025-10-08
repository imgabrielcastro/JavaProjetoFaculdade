package br.com.backend.projetoexemplo.arquitetura1.entity;

import br.com.backend.projetoexemplo.arquitetura1.enums.StatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno extends Pessoa{

    @Column(name = "mensalidade", columnDefinition = "DECIMAL(20, 2) DEFAULT 0.0")
    private Double mensalidade;

    private StatusEnum statusEnum;

    public Aluno() {

    }

    public Aluno(Integer id, String nome, Double mensalidade, StatusEnum statusEnum) {
        super(id, nome);
        this.mensalidade = mensalidade;
        this.statusEnum = statusEnum;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    public Double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Double mensalidade) {
        this.mensalidade = mensalidade;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "mensalidade=" + mensalidade +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
