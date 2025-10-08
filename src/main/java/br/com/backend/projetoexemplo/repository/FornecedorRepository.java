package br.com.backend.projetoexemplo.repository;

import br.com.backend.projetoexemplo.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
}