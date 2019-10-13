package br.ufc.web.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.web.model.Produto;
import br.ufc.web.repository.ProdutoRepository;
import br.ufc.web.util.FileUtil;

@Service
public class ProdutoService implements GenericService<Produto>{

	@Autowired
	ProdutoRepository repository;
	
	public void adicionarProduto(Produto produto, MultipartFile imagem) {
		salvarImagemProduto(produto.getNome(), imagem);
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
	
	public void salvarImagemProduto(String nomeDoProduto, MultipartFile imagem) {
		if (imagemIsValid(imagem)) {
			String caminho = "src/main/resources/static/img/produtos/" + nomeDoProduto + ".jpg";
			FileUtil.salvarImagem(caminho, imagem);
		}
	}
	
	public Boolean imagemIsValid(MultipartFile imagem) {
		return Objects.nonNull(imagem) && !imagem.isEmpty();
	}

}
