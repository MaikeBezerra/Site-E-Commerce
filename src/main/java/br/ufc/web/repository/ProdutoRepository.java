package br.ufc.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.web.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
