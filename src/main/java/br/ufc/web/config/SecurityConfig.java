//package br.ufc.web.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import br.ufc.web.security.UserDetailsServiceImplements;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	@Autowired
//	private UserDetailsServiceImplements userDetailsImplements;
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests()
//		
//		.antMatchers("/galeria").permitAll()
//		.antMatchers("/produto/formulario").hasAnyRole("ADMIN")
//		
//		.anyRequest().authenticated()
//		
//		.and()
//		.formLogin()
//		.loginPage("/usuario/logar")
//		.permitAll()
//		
//		.and()
//		.logout()
//		.logoutSuccessUrl("usuario/logar?logout")
//		.permitAll();
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsImplements).passwordEncoder(new BCryptPasswordEncoder());
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
//	}
//}
