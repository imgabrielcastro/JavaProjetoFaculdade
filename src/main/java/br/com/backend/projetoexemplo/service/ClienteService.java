package br.com.backend.projetoexemplo.service;

import br.com.backend.projetoexemplo.model.Cliente;
import br.com.backend.projetoexemplo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}