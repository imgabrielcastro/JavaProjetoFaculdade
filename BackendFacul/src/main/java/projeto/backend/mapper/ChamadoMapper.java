package projeto.backend.mapper;

import jakarta.validation.constraints.NotNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import projeto.backend.dto.ChamadoRequestDto;
import projeto.backend.dto.ChamadoResponseDto;
import projeto.backend.entity.Chamado;
import projeto.backend.entity.Cliente;
import projeto.backend.entity.Tecnico;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChamadoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataAbertura", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "dataFechamento", ignore = true)
    Chamado toEntity(ChamadoRequestDto dto, Cliente cliente, Tecnico tecnico);

    ChamadoResponseDto toResponseDto(Chamado chamado);

    List<ChamadoResponseDto> toResponseDtoList(List<Chamado> chamados);

    Chamado toEntity(ChamadoRequestDto dto, @NotNull(message = "O identificador do cliente é obrigatório.") Integer cliente, @NotNull(message = "O identificador do técnico é obrigatório.") Integer tecnico);
}