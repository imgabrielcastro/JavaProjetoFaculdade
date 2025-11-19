package projeto.backend.resource;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.backend.dto.TecnicoRequestDto;
import projeto.backend.dto.TecnicoResponseDto;
import projeto.backend.entity.Tecnico;
import projeto.backend.mapper.TecnicoMapper;
import projeto.backend.service.TecnicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
@Tag(name = "Técnicos", description = "Operações relacionadas aos técnicos")
public class TecnicoResource {

    private final TecnicoService service;
    private final TecnicoMapper mapper;

    public TecnicoResource(TecnicoService service, TecnicoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @Operation(summary = "Cria um novo técnico")
    public ResponseEntity<TecnicoResponseDto> criar(@Valid @RequestBody TecnicoRequestDto dto) {
        Tecnico tecnico = service.criarTecnico(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDto(tecnico));
    }

    @GetMapping
    @Operation(summary = "Lista todos os técnicos")
    public ResponseEntity<List<TecnicoResponseDto>> listar() {
        List<TecnicoResponseDto> dtos = mapper.toResponseDtoList(service.listarTecnicos());
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um técnico")
    public ResponseEntity<TecnicoResponseDto> atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody TecnicoRequestDto dto) {

        Tecnico atualizado = service.atualizarTecnico(id, dto);
        return ResponseEntity.ok(mapper.toResponseDto(atualizado));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um técnico")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletarTecnico(id);
        return ResponseEntity.noContent().build();
    }

}
