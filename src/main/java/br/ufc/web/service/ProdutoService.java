package br.ufc.web.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.ufc.web.model.Produto;

public interface ProdutoService {

	List<Produto> listar();

	Produto buscar(Long id);

	void remover(Long id);

	void adicionarProduto(Produto produto, MultipartFile imagem);

}
