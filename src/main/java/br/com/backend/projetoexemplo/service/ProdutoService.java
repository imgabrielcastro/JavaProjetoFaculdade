package br.com.backend.projetoexemplo.service;

import br.com.backend.projetoexemplo.model.Produto;
import br.com.backend.projetoexemplo.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
