package br.ufc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.web.model.Produto;
import br.ufc.web.service.ProdutoService;

@Controller
@RequestMapping("/")
public class MenuPrincipalController {
	
	@Autowired
	ProdutoService service;
	
	private static final String INDEX = "index";
	private static final String GALERIA = "galeria";
	private static final String SOBRE = "sobre";
	private static final String CADASTRO = "cadastro";
	private static final String FORMULARIO = "formulario";
	private static final String LOGIN = "login";
	
	@GetMapping
	public ModelAndView paginaInicial() {
		return pagina(INDEX);
	}
	
	@GetMapping(GALERIA)
	public ModelAndView galeriaProdutos() {
		return pagina(GALERIA);
	}
	
	@GetMapping(SOBRE)
	public String sobre() {
		return SOBRE;
	}
	
	@GetMapping(FORMULARIO)
	public String formularioEmpresa() {
		return FORMULARIO;
	}
	
	@GetMapping(CADASTRO)
	public String cadastroUser() {
		return CADASTRO;
	}
	
	@GetMapping(LOGIN)
	public String loginUser() {
		return LOGIN;
	}
	
	public ModelAndView pagina(String pagina) {
		List<Produto> produtos = service.listar();
		ModelAndView mv = new ModelAndView(pagina);
		
		mv.addObject("produtos", produtos);
		return mv;
	}
}
