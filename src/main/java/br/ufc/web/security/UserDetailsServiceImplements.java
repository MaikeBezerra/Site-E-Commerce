//package br.ufc.web.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import br.ufc.web.model.Usuario;
//import br.ufc.web.repository.UsuarioRepository;
//
//@Service
//public class UserDetailsServiceImplements implements UserDetailsService{
//	
//	@Autowired
//	private UsuarioRepository usuarioRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//		Usuario usuario = usuarioRepository.findByLogin(login);
//		if (usuario == null) {
//			 throw new UsernameNotFoundException("Usuário Invalido");
//		}
//			
//		return new User(usuario.getUsername(), usuario.getPassword(),true,true,true,true,usuario.getAuthorities());
//	}
//	
//}
