package projeto.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import projeto.backend.dto.TecnicoRequestDto;
import projeto.backend.dto.TecnicoResponseDto;
import projeto.backend.entity.Tecnico;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TecnicoMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "perfilEnum", expression = "java(projeto.backend.enums.PerfilEnum.TECNICO)")
    @Mapping(target = "dataCriacao", expression = "java(java.time.LocalDate.now())")
    Tecnico toEntity(TecnicoRequestDto dto);

    TecnicoResponseDto toResponseDto(Tecnico tecnico);
    List<TecnicoResponseDto> toResponseDtoList(List<Tecnico> tecnicos);
}