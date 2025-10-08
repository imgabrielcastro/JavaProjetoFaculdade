package br.com.backend.projetoexemplo.service;

import br.com.backend.projetoexemplo.model.Fornecedor;
import br.com.backend.projetoexemplo.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    private final FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }

    public List<Fornecedor> listarTodos() {
        return repository.findAll();
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}