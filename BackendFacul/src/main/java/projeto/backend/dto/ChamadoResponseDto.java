package projeto.backend.dto;

import lombok.Getter;
import projeto.backend.entity.Chamado;
import java.time.LocalDate;

@Getter
public class ChamadoResponseDto {

    private final Integer id;
    private final String titulo;
    private final String observacoes;
    private final LocalDate dataAbertura;
    private final LocalDate dataFechamento;
    private final Integer prioridadeCod;
    private final String prioridadeDesc;
    private final Integer statusCod;
    private final String statusDesc;

    public ChamadoResponseDto(Chamado chamado) {
        this.id = chamado.getId();
        this.titulo = chamado.getTitulo();
        this.observacoes = chamado.getObservacoes();
        this.dataAbertura = chamado.getDataAbertura();
        this.dataFechamento = chamado.getDataFechamento();
        this.prioridadeCod = chamado.getPrioridade().getCodigo();
        this.prioridadeDesc = chamado.getPrioridade().getDescricao();
        this.statusCod = chamado.getStatus().getCodigo();
        this.statusDesc = chamado.getStatus().getDescricao();
    }
}
