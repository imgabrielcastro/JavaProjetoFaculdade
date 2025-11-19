package projeto.backend.entity;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import projeto.backend.enums.PrioridadeEnum;
import projeto.backend.enums.StatusEnum;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String titulo;

    @NotNull
    private String observacoes;

    @NotNull
    private PrioridadeEnum prioridade;

    @NotNull
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @NotNull
    private LocalDate dataAbertura = LocalDate.now();

    private LocalDate dataFechamento;
}
