package br.ufc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
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

import br.ufc.web.model.Carrinho;
import br.ufc.web.model.Produto;
import br.ufc.web.model.Usuario;
import br.ufc.web.service.ProdutoService;
import br.ufc.web.service.UsuarioService;

@Controller
@Transactional
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public Carrinho cart(){
		Carrinho cart = Carrinho.getInstance();
		return cart;
	}
	
	@RequestMapping("/formulario")
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
	
	@RequestMapping("/atualizar/{id}")
	public ModelAndView atualizarProduto(@PathVariable Long id) {
		Produto produto = service.buscar(id);
		return addObjectModel("produto/produto-formulario", "produto", produto);
	}
	
	@RequestMapping("/excluir/{id}")
	public String excluirProduto(@PathVariable long id) {
		service.remover(id);
		return "redirect:/produto/listar";
	}
	
	
	@RequestMapping("/carrinho")
	public ModelAndView produtosDoCarrinho() {
		 
		List<Produto> produtos = new ArrayList<Produto>(); 
		produtos.addAll(cart().produtos());
		
		ModelAndView mv = new ModelAndView("carrinho");
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@RequestMapping("/carrinho/adicionar/{id}")
	public String adicionarProdutoNoCarrinho(@PathVariable long id) {
		Produto produto = service.buscar(id);
		cart().addProduto(produto);
		return "redirect:/index";
	}
	
	@RequestMapping("/carrinho/excluir/{id}")
	public String excluirProdutoDoCarrinho(@PathVariable long id) {
		Produto produto = service.buscar(id);
		cart().removeProduto(produto);
		return "redirect:/produto/carrinho";
	}
	
	@RequestMapping("/carrinho/finalizar/{id}")
	public String finalizarCompra(@PathVariable long id) {
		Usuario usuario = usuarioService.buscar(id);
		usuario.getProdutos().addAll(cart().produtos());
		cart().clearProdutos();
		return "redirect:/index";
	}
	
	public ModelAndView addObjectModel(String pagina, String elemento, Object obj) {
		ModelAndView mv = new ModelAndView(pagina);
		mv.addObject(elemento, obj);
		return mv;
	}
	
}
