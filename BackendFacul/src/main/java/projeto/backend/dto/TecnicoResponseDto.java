package projeto.backend.dto;

import lombok.Getter;
import projeto.backend.entity.Tecnico;
import java.time.LocalDate;

@Getter
public class TecnicoResponseDto {

    private final Integer id;
    private final String nome;
    private final Integer cpf;
    private final String email;
    private final String perfil;
    private final LocalDate dataCriacao;

    public TecnicoResponseDto(Tecnico tecnico) {
        this.id = tecnico.getId();
        this.nome = tecnico.getNome();
        this.cpf = tecnico.getCpf();
        this.email = tecnico.getEmail();
        this.perfil = tecnico.getPerfilEnum().getDescricao();
        this.dataCriacao = tecnico.getDataCriacao();
    }
}
