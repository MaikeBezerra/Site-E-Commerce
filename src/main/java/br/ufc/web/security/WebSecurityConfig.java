package br.ufc.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/sobre").permitAll()
		.antMatchers("/formulario").permitAll()
		.antMatchers("/usuario/formulario").permitAll()
		.antMatchers("/usuario/salvar").permitAll()
		.antMatchers("/produto/carrinho").hasRole("USER")
		.antMatchers("/produto/carrinho/adicionar").hasRole("USER")
		.antMatchers("/produto/carrinho/excluir").hasRole("USER")
		.antMatchers("/produto/carrinho/finalizar").hasRole("USER")
		.antMatchers("/produto/formulario").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().loginProcessingUrl("/login").loginPage("/login").permitAll()
		.and().logout().logoutSuccessUrl("/logout").permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/materialize/**", "/css/**","/js/**", "/img/**");
	}
	
	
}
