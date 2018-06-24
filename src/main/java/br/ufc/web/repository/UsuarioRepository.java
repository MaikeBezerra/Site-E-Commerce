package br.ufc.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.web.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByLogin(String login);
}
