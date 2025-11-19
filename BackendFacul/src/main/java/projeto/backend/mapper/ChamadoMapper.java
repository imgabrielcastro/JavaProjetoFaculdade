package projeto.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import projeto.backend.dto.ChamadoRequestDto;
import projeto.backend.dto.ChamadoResponseDto;
import projeto.backend.entity.Chamado;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChamadoMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "tecnico", ignore = true)
    @Mapping(target = "dataAbertura", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "dataFechamento", ignore = true)
    Chamado toEntity(ChamadoRequestDto dto);

    ChamadoResponseDto toResponseDto(Chamado chamado);

    List<ChamadoResponseDto> toResponseDtoList(List<Chamado> chamados);
}
