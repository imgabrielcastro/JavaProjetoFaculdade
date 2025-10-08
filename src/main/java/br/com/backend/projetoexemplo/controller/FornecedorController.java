package br.com.backend.projetoexemplo.controller;

import br.com.backend.projetoexemplo.model.Fornecedor;
import br.com.backend.projetoexemplo.service.FornecedorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService service;

    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Fornecedor> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Fornecedor criar(@RequestBody Fornecedor fornecedor) {
        return service.salvar(fornecedor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }
}
