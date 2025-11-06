package projeto.backend.dto;

import lombok.Getter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import projeto.backend.enums.PrioridadeEnum;
import projeto.backend.enums.StatusEnum;

@Getter
@Schema(description = "Objeto usado para cadastrar um novo chamado no sistema")
public class ChamadoRequestDto {

    @NotBlank(message = "Informe o título do chamado.")
    private final String titulo;

    @NotBlank(message = "As observações não podem ficar em branco.")
    private final String observacoes;

    @NotNull(message = "Selecione uma prioridade válida.")
    private final PrioridadeEnum prioridade;

    @NotNull(message = "Defina o status do chamado.")
    private final StatusEnum status;

    @NotNull(message = "O identificador do cliente é obrigatório.")
    private final Integer cliente;

    @NotNull(message = "O identificador do técnico é obrigatório.")
    private final Integer tecnico;

    public ChamadoRequestDto(
            String titulo,
            String observacoes,
            PrioridadeEnum prioridade,
            StatusEnum status,
            Integer cliente,
            Integer tecnico
    ) {
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.prioridade = prioridade;
        this.status = status;
        this.cliente = cliente;
        this.tecnico = tecnico;
    }
}
