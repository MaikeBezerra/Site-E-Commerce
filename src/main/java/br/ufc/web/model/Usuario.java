package br.ufc.web.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String cpf;
	private String nome;
	private String endereco;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( 
	        name = "usuarios_roles", 
	        joinColumns = @JoinColumn(
	          name = "usuario_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "role_id", referencedColumnName = "papel")) 
	private List<Role> roles;

	@ManyToMany
	@JoinTable(
			name = "usuarios_produtos",
			joinColumns = @JoinColumn(
					name = "usuario_id", referencedColumnName = "id"))
	private List<Produto> produtos;
	
	private String login;
	private String senha;
	
	public Usuario() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) this.roles;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
