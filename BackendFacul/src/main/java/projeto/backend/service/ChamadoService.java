package projeto.backend.service;

import org.springframework.stereotype.Service;
import projeto.backend.entity.Chamado;
import projeto.backend.dto.ChamadoRequestDto;
import projeto.backend.mapper.ChamadoMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChamadoService {

    private final List<Chamado> chamados = new ArrayList<>();
    private final ChamadoMapper mapper;

    public ChamadoService(ChamadoMapper mapper) {
        this.mapper = mapper;
    }

    public Chamado criarChamado(ChamadoRequestDto dto) {
        Chamado chamado = mapper.toEntity(dto, dto.getCliente(), dto.getTecnico());
        chamados.add(chamado);
        return chamado;
    }

    public void deletarChamado(Chamado chamado) {
        if (chamado.getStatus().getCodigo() != 2) { // 2 = ENCERRADO
            throw new RuntimeException("Não é possível excluir chamados em aberto");
        }
        chamados.remove(chamado);
    }

    public List<Chamado> listarChamados() {
        return chamados;
    }
}
