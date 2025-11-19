package projeto.backend.resource;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.backend.dto.ChamadoRequestDto;
import projeto.backend.dto.ChamadoResponseDto;
import projeto.backend.entity.Chamado;
import projeto.backend.mapper.ChamadoMapper;
import projeto.backend.service.ChamadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/chamados")
@Tag(name = "Chamados", description = "Operações relacionadas aos chamados")
public class ChamadoResource {

    private final ChamadoService service;
    private final ChamadoMapper mapper;

    public ChamadoResource(ChamadoService service, ChamadoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @Operation(summary = "Cria um novo chamado")
    public ResponseEntity<ChamadoResponseDto> criar(@Valid @RequestBody ChamadoRequestDto dto) {
        Chamado chamado = service.criarChamado(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDto(chamado));
    }

    @GetMapping
    @Operation(summary = "Lista todos os chamados")
    public ResponseEntity<List<ChamadoResponseDto>> listar() {
        List<ChamadoResponseDto> dtos = mapper.toResponseDtoList(service.listarChamados());
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um chamado")
    public ResponseEntity<ChamadoResponseDto> atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody ChamadoRequestDto dto) {

        Chamado atualizado = service.atualizarChamado(id, dto);
        return ResponseEntity.ok(mapper.toResponseDto(atualizado));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um chamado (somente se ENCERRADO)")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletarChamado(id);
        return ResponseEntity.noContent().build();
    }
}
