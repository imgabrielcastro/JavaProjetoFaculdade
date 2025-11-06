package projeto.backend.dto;

import lombok.Getter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Schema(description = "Objeto responsável por receber os dados de cadastro de um novo cliente")
public class ClienteRequestDto {

    @NotBlank(message = "Informe o nome completo do cliente.")
    private final String nome;

    @NotBlank(message = "É necessário informar o CPF.")
    private final Integer cpf;

    @Email(message = "Informe um endereço de e-mail válido.")
    @NotBlank(message = "O e-mail não pode ficar em branco.")
    private final String email;

    @NotBlank(message = "A senha deve ser preenchida.")
    private final String senha;

    public ClienteRequestDto(String nome, Integer cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
}
