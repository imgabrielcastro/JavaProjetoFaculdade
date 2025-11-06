package projeto.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import projeto.backend.dto.ClienteRequestDto;
import projeto.backend.dto.ClienteResponseDto;
import projeto.backend.entity.Cliente;
import projeto.backend.enums.PerfilEnum;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "perfilEnum", expression = "java(PerfilEnum.CLIENTE)")
    @Mapping(target = "dataCriacao", expression = "java(LocalDate.now())")
    Cliente convertToEntity(ClienteRequestDto requisicao);

    ClienteResponseDto convertToResponse(Cliente cliente);

    List<ClienteResponseDto> convertToResponseList(List<Cliente> listaClientes);

    Cliente toEntity(ClienteRequestDto dto);
}
