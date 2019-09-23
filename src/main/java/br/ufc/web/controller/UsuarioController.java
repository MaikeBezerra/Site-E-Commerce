package br.ufc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.web.model.Usuario;
import br.ufc.web.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	

	@RequestMapping("/formulario")
	public ModelAndView formulariousuario() {
		ModelAndView mv = new ModelAndView("cadastro");
		mv.addObject("usuario", new Usuario());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarusuario(Usuario usuario) {
		usuarioService.adicionarUsuario(usuario);
		
		ModelAndView mv = new ModelAndView("redirect:/usuario/logar");
		
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarusuario() {
		Iterable<Usuario> usuarios = usuarioService.allUsers();
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("todasAsusuarios", usuarios);
		
		return mv;
	}
	
	@RequestMapping("/atualizar/{id}")
	public ModelAndView atualizarusuario(@PathVariable Long id) {
		Usuario usuario = usuarioService.buscaPorId(id);
		ModelAndView mv = new ModelAndView("cadastro");
		mv.addObject("usuario", usuario);
		
		return mv;
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirUsuario(@PathVariable Long id) {
		usuarioService.removerUsuario(id);
		ModelAndView mv = new ModelAndView("redirect:/usuario/listar");
		return mv;
	}
	
	
	@RequestMapping("/logar")
	public ModelAndView logar() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
}
