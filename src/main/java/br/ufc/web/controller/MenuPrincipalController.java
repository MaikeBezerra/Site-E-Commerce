package br.ufc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.web.model.Produto;
import br.ufc.web.service.ProdutoService;

@Controller
public class MenuPrincipalController {
	
	@Autowired
	ProdutoService service;
	
	@GetMapping("/")
	public ModelAndView paginaInicial() {
		return pagina("index");
	}
	
	@GetMapping("/galeria")
	public ModelAndView galeriaProdutos() {
		return pagina("galeria");
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
	
	@GetMapping("/login")
	public String loginUser() {
		return "login";
	}
	
	public ModelAndView pagina(String pagina) {
		List<Produto> produtos = service.listar();
		ModelAndView mv = new ModelAndView(pagina);
		
		mv.addObject("produtos", produtos);
		return mv;
	}
}
