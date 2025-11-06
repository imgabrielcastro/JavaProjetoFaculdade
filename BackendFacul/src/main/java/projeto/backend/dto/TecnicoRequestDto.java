package projeto.backend.dto;

import lombok.Getter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Schema(description = "Objeto responsável por receber os dados de cadastro de um novo técnico")
public class TecnicoRequestDto {

    @NotBlank(message = "Informe o nome completo do técnico.")
    private final String nome;

    @NotNull(message = "O CPF do técnico deve ser informado.")
    private final Integer cpf;

    @Email(message = "Forneça um e-mail válido.")
    @NotBlank(message = "O e-mail é obrigatório.")
    private final String email;

    @NotBlank(message = "Informe uma senha para o acesso.")
    private final String senha;

    public TecnicoRequestDto(String nome, Integer cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
}
