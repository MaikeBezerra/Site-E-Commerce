package br.ufc.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.web.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	Usuario findByLogin(String login);
}
