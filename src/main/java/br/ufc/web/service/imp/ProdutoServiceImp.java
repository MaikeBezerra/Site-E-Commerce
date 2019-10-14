package br.ufc.web.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.web.model.Produto;
import br.ufc.web.repository.ProdutoRepository;
import br.ufc.web.service.ProdutoService;
import br.ufc.web.util.ImagemProdutoUtil;

@Service
public class ProdutoServiceImp implements ProdutoService{

	@Autowired
	ProdutoRepository repository;
	
	@Override
	public void adicionarProduto(Produto produto, MultipartFile imagem) {
		ImagemProdutoUtil.salvarImagemProduto(produto.getNome(), imagem);
		repository.save(produto);
	}

	@Override
	public List<Produto> listar() {
		return repository.findAll();
	}

	@Override
	public Produto buscar(Long id) {
		return repository.getOne(id);
	}

	@Override
	public void remover(Long id) {
		repository.deleteById(id);
	}
	
}
