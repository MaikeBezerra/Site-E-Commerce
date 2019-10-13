package br.ufc.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.ufc.web.model.Usuario;
import br.ufc.web.repository.UsuarioRepository;

@Service
public class UsuarioService implements GenericService<Usuario>{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void adicionarUsuario(Usuario user) {
		user.setSenha(criptografar(user.getSenha()));
		usuarioRepository.save(user);
	}
	
	public Usuario buscarPorLogin(String login){
		return usuarioRepository.findByLogin(login);
	}

	@Override
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario buscar(Long id) {
		return usuarioRepository.getOne(id);
	}

	@Override
	public void remover(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public String criptografar(String senha) {
		return new BCryptPasswordEncoder().encode(senha);
	}
}
