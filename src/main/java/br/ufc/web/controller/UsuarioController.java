package br.ufc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	private static final String USUARIO = "usuario";
	private static final String CADASTRO = "cadastro";
	
	@GetMapping("/formulario")
	public ModelAndView formulariousuario() {
		return addObjectModel(CADASTRO, USUARIO, new Usuario());
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarusuario(Usuario usuario) {
		usuarioService.adicionarUsuario(usuario);
		return new ModelAndView("redirect:/usuario/logar");
	}
	
	@GetMapping("/listar")
	public ModelAndView listaDeUsuarios() {
		Iterable<Usuario> usuarios = usuarioService.listar();
		ModelAndView mv = new ModelAndView();
		mv.addObject("todasAsusuarios", usuarios);
		
		return mv;
	}
	
	@PostMapping("/atualizar/{id}")
	public ModelAndView atualizarusuario(@PathVariable Long id) {
		Usuario usuario = usuarioService.buscar(id);
		return addObjectModel(CADASTRO, USUARIO, usuario);
	}
	
	@DeleteMapping("/excluir/{id}")
	public ModelAndView excluirUsuario(@PathVariable Long id) {
		usuarioService.remover(id);
		return new ModelAndView("redirect:/usuario/listar");
	}
	
	public ModelAndView addObjectModel(String pagina, String elemento, Object obj) {
		ModelAndView mv = new ModelAndView(pagina);
		mv.addObject(elemento, obj);
		return mv;
	}
	
}
