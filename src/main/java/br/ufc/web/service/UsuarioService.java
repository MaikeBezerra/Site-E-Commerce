package br.ufc.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.web.model.Usuario;
import br.ufc.web.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void adicionarUsuario(Usuario user) {
		usuarioRepository.save(user);
	}
	
	public List<Usuario> allUsers(){
		return usuarioRepository.findAll();
	}
	
	public Usuario buscaPorId(String cpf) {
		return usuarioRepository.getOne(cpf);
	}
	
	public void removerUsuario(String cpf) {
		usuarioRepository.deleteById(cpf);
		
	}
}
