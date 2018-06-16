package br.ufc.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@RequestMapping("/formulario")
	public ModelAndView formularioProduto() {
		ModelAndView mv = new ModelAndView("produto/formularioProduto");
		mv.addObject("produto", new Produto());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarProduto(@Valid Produto produto, @RequestParam(value="imagem") MultipartFile imagem) {
		service.adicionarProduto(produto, imagem);
		ModelAndView mv = new ModelAndView("redirect:/produto/listar");
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarProdutos() {
		List<Produto> produtos = service.retornarTodosOsProdutos();
		ModelAndView mv = new ModelAndView("produto/buscaProduto");
		
		mv.addObject("produtos", produtos);
		
		return mv;
	}
	
	@RequestMapping("/atualizar/{id}")
	public ModelAndView atualizarProduto(@PathVariable Long id) {
		Produto produto = service.buscarPorId(id);
		ModelAndView mv = new ModelAndView("produto/formularioProduto");
		
		mv.addObject("produto", produto);
		
		return mv;
	}
	
	@RequestMapping("/excluir/{id}")
	public String excluirProduto(@PathVariable long id) {
		service.removerProduto(id);
		return "redirect:/produto/listar";
	}
	
}
