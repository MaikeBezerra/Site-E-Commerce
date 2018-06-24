package br.ufc.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.ufc.web.model.Role;
import br.ufc.web.model.Usuario;
import br.ufc.web.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	
	public void adicionarUsuario(Usuario user) {
		
		user.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
		usuarioRepository.save(user);
	}
	
	public Iterable<Usuario> allUsers(){
		return usuarioRepository.findAll();
	}
	
	public Usuario buscaPorId(long id) {
		return usuarioRepository.getOne(id);
	}
	
	public void removerUsuario(long id) {
		usuarioRepository.deleteById(id);
		
	}
	
	public Usuario buscarPorLogin(String login){
		return usuarioRepository.findByLogin(login);
	}
}
