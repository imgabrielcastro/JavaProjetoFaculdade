package br.com.backend.projetoexemplo.controller;

import br.com.backend.projetoexemplo.model.Produto;
import br.com.backend.projetoexemplo.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }
}