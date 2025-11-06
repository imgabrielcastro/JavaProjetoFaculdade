package projeto.backend.dto;

import lombok.Getter;
import projeto.backend.entity.Cliente;
import java.time.LocalDate;

@Getter
public class ClienteResponseDto {

    private final Integer id;
    private final String nome;
    private final Integer cpf;
    private final String email;
    private final String perfil;
    private final LocalDate dataCriacao;

    public ClienteResponseDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.perfil = cliente.getPerfilEnum().getDescricao();
        this.dataCriacao = cliente.getDataCriacao();
    }
}
