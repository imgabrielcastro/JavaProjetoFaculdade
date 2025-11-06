package projeto.backend.service;

import org.springframework.stereotype.Service;
import projeto.backend.entity.Cliente;
import projeto.backend.dto.ClienteRequestDto;
import projeto.backend.mapper.ClienteMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private final List<Cliente> clientes = new ArrayList<>();
    private final ClienteMapper mapper;

    public ClienteService(ClienteMapper mapper) {
        this.mapper = mapper;
    }

    public Cliente criarCliente(ClienteRequestDto dto) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(dto.getCpf())) {
                throw new RuntimeException("CPF já cadastrado");
            }
            if (c.getEmail().equals(dto.getEmail())) {
                throw new RuntimeException("Email já cadastrado");
            }
        }
        Cliente cliente = mapper.toEntity(dto);
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }
}
