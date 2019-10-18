package br.ufc.web.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.web.model.Produto;
import br.ufc.web.service.ProdutoService;

@Controller
@Transactional
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@GetMapping("/formulario")
	public ModelAndView formularioProduto() {
		return addObjectModel("produto/produto-formulario", "produto", new Produto());
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarProduto(@Valid Produto produto, @RequestParam(value="imagem") MultipartFile imagem) {
		service.adicionarProduto(produto, imagem);
		return new ModelAndView("redirect:/produto/listar");
	}
	
	@GetMapping("/listar")
	public ModelAndView listaDeProdutos() {
		List<Produto> produtos = service.listar();
		return addObjectModel("produto/produto-lista", "produtos", produtos);
	}
	
	@PostMapping("/atualizar/{id}")
	public ModelAndView atualizarProduto(@PathVariable Long id) {
		Produto produto = service.buscar(id);
		return addObjectModel("produto/produto-formulario", "produto", produto);
	}
	
	@DeleteMapping("/excluir/{id}")
	public String excluirProduto(@PathVariable long id) {
		service.remover(id);
		return "redirect:/produto/listar";
	}
	
	public ModelAndView addObjectModel(String pagina, String elemento, Object obj) {
		ModelAndView mv = new ModelAndView(pagina);
		mv.addObject(elemento, obj);
		return mv;
	}
	
}
