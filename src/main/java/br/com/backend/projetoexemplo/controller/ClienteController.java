package br.com.backend.projetoexemplo.controller;

import br.com.backend.projetoexemplo.model.Cliente;
import br.com.backend.projetoexemplo.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }
}
