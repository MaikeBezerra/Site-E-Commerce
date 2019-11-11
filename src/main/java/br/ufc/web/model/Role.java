package br.ufc.web.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Id
	private String papel;
	
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuario;
	
	public Role() {}
	
	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	@Override
	public String getAuthority() {
		return this.papel;
	}

}
