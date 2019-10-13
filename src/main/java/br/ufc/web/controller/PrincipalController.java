package br.ufc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.web.model.Produto;
import br.ufc.web.service.ProdutoService;

@Controller
public class PrincipalController {
	
	@Autowired
	ProdutoService service;
	
	@GetMapping("/index")
	public ModelAndView paginaInicial() {
		List<Produto> produtos = service.produtos();
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	
	@GetMapping("/galeria")
	public ModelAndView galeriaProdutos() {
		List<Produto> produtos = service.produtos();
		ModelAndView mv = new ModelAndView("galeria");
		
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@GetMapping("/sobre")
	public String sobre() {
		return "sobre";
	}
	
	@GetMapping("/formulario")
	public String formularioEmpresa() {
		return "formulario1";
	}
	
	@GetMapping("/cadastro")
	public String cadastroUser() {
		return "cadastro";
	}
}
