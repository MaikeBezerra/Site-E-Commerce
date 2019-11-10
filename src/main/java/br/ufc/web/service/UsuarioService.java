package br.ufc.web.service;

import java.util.List;

import br.ufc.web.model.Usuario;

public interface UsuarioService {

	List<Usuario> listar();

	Usuario buscar(Long id);

	void remover(Long id);

	Usuario buscarPorLogin(String login);

	void adicionarUsuario(Usuario user);

}
