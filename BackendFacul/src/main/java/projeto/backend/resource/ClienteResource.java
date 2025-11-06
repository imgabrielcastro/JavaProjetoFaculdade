package projeto.backend.resource;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.backend.dto.ClienteRequestDto;
import projeto.backend.dto.ClienteResponseDto;
import projeto.backend.entity.Cliente;
import projeto.backend.mapper.ClienteMapper;
import projeto.backend.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Clientes", description = "Operações relacionadas aos clientes")
public class ClienteResource {

    private final ClienteService service;
    private final ClienteMapper mapper;

    public ClienteResource(ClienteService service, ClienteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @Operation(summary = "Cria um novo cliente")
    public ResponseEntity<ClienteResponseDto> criar(@Valid @RequestBody ClienteRequestDto dto) {
        Cliente cliente = service.criarCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDto(cliente));
    }

    @GetMapping
    @Operation(summary = "Lista todos os clientes")
    public ResponseEntity<List<ClienteResponseDto>> listar() {
        List<ClienteResponseDto> dtos = mapper.toResponseDtoList(service.listarClientes());
        return ResponseEntity.ok(dtos);
    }
}
