package projeto.backend.service;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import projeto.backend.dto.ChamadoRequestDto;
import projeto.backend.entity.Chamado;
import projeto.backend.entity.Cliente;
import projeto.backend.entity.Tecnico;
import projeto.backend.enums.StatusEnum;
import projeto.backend.mapper.ChamadoMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChamadoService {

    private final List<Chamado> chamados = new ArrayList<>();
    private final ChamadoMapper mapper;
    private final ClienteService clienteService;
    private final TecnicoService tecnicoService;

    public ChamadoService(
            ChamadoMapper mapper,
            ClienteService clienteService,
            TecnicoService tecnicoService
    ) {
        this.mapper = mapper;
        this.clienteService = clienteService;
        this.tecnicoService = tecnicoService;
    }

    public Chamado criarChamado(ChamadoRequestDto dto) {

        Cliente cliente = clienteService.listarClientes()
                .stream()
                .filter(c -> c.getId().equals(dto.getCliente()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Tecnico tecnico = tecnicoService.listarTecnicos()
                .stream()
                .filter(t -> t.getId().equals(dto.getTecnico()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Técnico não encontrado"));

        Chamado chamado = mapper.toEntity(dto);
        chamado.setCliente(cliente);
        chamado.setTecnico(tecnico);

        chamado.setId(chamados.size() + 1);
        chamados.add(chamado);

        return chamado;
    }

    public List<Chamado> listarChamados() {
        return chamados;
    }

    public Chamado atualizarChamado(Integer id, @Valid ChamadoRequestDto dto) {

        Chamado chamado = chamados.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

        Cliente cliente = clienteService.listarClientes()
                .stream()
                .filter(c -> c.getId().equals(dto.getCliente()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Tecnico tecnico = tecnicoService.listarTecnicos()
                .stream()
                .filter(t -> t.getId().equals(dto.getTecnico()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Técnico não encontrado"));

        chamado.setTitulo(dto.getTitulo());
        chamado.setObservacoes(dto.getObservacoes());
        chamado.setPrioridade(dto.getPrioridade());
        chamado.setStatus(dto.getStatus());
        chamado.setCliente(cliente);
        chamado.setTecnico(tecnico);

        if (dto.getStatus() == StatusEnum.ENCERRADO) {
            chamado.setDataFechamento(LocalDate.now());
        } else {
            chamado.setDataFechamento(null);
        }

        return chamado;
    }

    public void deletarChamado(Integer id) {

        Chamado chamado = chamados.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

        if (chamado.getStatus() != StatusEnum.ENCERRADO) {
            throw new RuntimeException("Só é permitido excluir chamados ENCERRADOS.");
        }

        chamados.remove(chamado);
    }
}
