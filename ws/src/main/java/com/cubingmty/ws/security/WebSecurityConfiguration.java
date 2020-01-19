package com.cubingmty.ws.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{


	final static String USERS_QUERY = "select Email, Password, Enabled from cm_user where Email=?";

	final static String AUTHORITIES_QUERY = 
			"SELECT cm_user.Email as username, cm_roles.Role as role" + 
					"        FROM cm_user" + 
					"        INNER JOIN cm_user_roles ON cm_user.Id = cm_user_roles.Id_User" + 
					"        INNER JOIN cm_roles ON cm_user_roles.Id_Role = cm_roles.Id" + 
					"        WHERE cm_user.Email = ? ";

	@Autowired
	private UserDetailsService userDetailsService;

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//		auth.jdbcAuthentication().dataSource(dataSource)
		//		.usersByUsernameQuery(USERS_QUERY)
		//		.authoritiesByUsernameQuery(AUTHORITIES_QUERY);
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests()
		// Los recursos estáticos no requieren autenticación
		.antMatchers(
				"/bootstrap/**",
				"/img/**",
				"/js/**",
				"/css/**",
				"/tinymce/**",
				"/logos/**").permitAll()
		.antMatchers("/login*").permitAll()
		.antMatchers(HttpMethod.POST,"/api/v1/**").permitAll()
		// Las vistas públicas no requieren autenticación
		.antMatchers(
				"/signup",
				"/api/**",
				"/catalog/**").permitAll()
		// Todas las demás URLs de la Aplicación requieren autenticación
		.anyRequest().authenticated()
		// El formulario de Login no requiere autenticacion
		.and()
		.formLogin()
		.loginPage("/login-page").permitAll()
		.and()
		.csrf().disable();

	}



}
