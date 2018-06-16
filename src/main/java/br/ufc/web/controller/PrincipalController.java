package br.ufc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.web.model.Produto;
import br.ufc.web.service.ProdutoService;

@Controller
public class PrincipalController {
	
	@Autowired
	ProdutoService service;
	
	@RequestMapping("/index")
	public String paginaInicial() {
		return "index";
	}
	
	
	@RequestMapping("/galeria")
	public ModelAndView galeriaProdutos() {
		List<Produto> produtos = service.retornarTodosOsProdutos();
		ModelAndView mv = new ModelAndView("galeria");
		
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@RequestMapping("/sobre")
	public String sobre() {
		return "sobre";
	}
	
	@RequestMapping("/formulario")
	public String formularioEmpresa() {
		return "formulario1";
	}
	
	@RequestMapping("/cadastro")
	public String cadastroUser() {
		return "cadastro";
	}
	
	@RequestMapping("/carrinho")
	public String cart() {
		return "carrinho";
	}
}
