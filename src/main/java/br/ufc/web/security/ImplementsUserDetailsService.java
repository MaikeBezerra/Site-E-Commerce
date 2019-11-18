package br.ufc.web.security;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.ufc.web.model.Usuario;
import br.ufc.web.repository.UsuarioRepository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String login) {
		Usuario usuario = ur.findByLogin(login);
		if (Objects.isNull(usuario)) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		return usuario;
	}

}
