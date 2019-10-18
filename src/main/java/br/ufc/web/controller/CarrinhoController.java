package br.ufc.web.controller;

import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.web.model.Carrinho;
import br.ufc.web.model.Produto;
import br.ufc.web.model.Usuario;
import br.ufc.web.service.UsuarioService;

@Controller
@Transactional
@RequestMapping("/produto/carrinho")
public class CarrinhoController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ModelAndView produtosDoCarrinho() {
		 
		ModelAndView mv = new ModelAndView("carrinho");
		mv.addObject("produtos", Carrinho.getInstance().produtos());
		return mv;
	}
	
	@RequestMapping("/adicionar/{id}")
	public String adicionarProdutoNoCarrinho(@PathVariable("id") Produto produto) {
		Carrinho.getInstance().addProduto(produto);
		return "redirect:/";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirProdutoDoCarrinho(@PathVariable("id") Produto produto) {
		Carrinho.getInstance().removeProduto(produto);
		return "redirect:/produto/carrinho";
	}
	
	@GetMapping("/finalizar")
	public String finalizarCompra() {
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) auth;
		
		if(Objects.nonNull(user)) {
			Usuario usuario = usuarioService.buscarPorLogin(user.getUsername());
			usuario.getProdutos().addAll(Carrinho.getInstance().produtos());
			Carrinho.getInstance().clearProdutos();	
		}
		return "redirect:/produto/carrinho";
	}
	
}
