package br.ufc.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.web.model.Carrinho;
import br.ufc.web.model.Produto;
import br.ufc.web.model.Usuario;
import br.ufc.web.service.ProdutoService;
import br.ufc.web.service.UsuarioService;

@Controller
@RequestMapping("/produto")
public class CarrinhoController {
	
	@Autowired
	private ProdutoService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/carrinho")
	public ModelAndView produtosDoCarrinho() {
		 
		List<Produto> produtos = new ArrayList<Produto>(); 
		produtos.addAll(Carrinho.getInstance().produtos());
		
		ModelAndView mv = new ModelAndView("carrinho");
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@RequestMapping("/carrinho/adicionar/{id}")
	public String adicionarProdutoNoCarrinho(@PathVariable long id) {
		Produto produto = service.buscar(id);
		Carrinho.getInstance().addProduto(produto);
		return "redirect:/index";
	}
	
	@GetMapping("/carrinho/excluir/{id}")
	public String excluirProdutoDoCarrinho(@PathVariable long id) {
		Produto produto = service.buscar(id);
		Carrinho.getInstance().removeProduto(produto);
		return "redirect:/produto/carrinho";
	}
	
	@GetMapping("/carrinho/finalizar/{id}")
	public String finalizarCompra(@PathVariable long id) {
		Usuario usuario = usuarioService.buscar(id);
		usuario.getProdutos().addAll(Carrinho.getInstance().produtos());
		Carrinho.getInstance().clearProdutos();
		return "redirect:/index";
	}
}
