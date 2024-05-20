package com.trekup.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.trekup.common.security.CustomLoginSuccessHandler;
import com.trekup.common.security.CustomUserDetailsService;

import lombok.extern.java.Log;

@Log
// Configuration defines beans for class; EnableWebSecurity enables security features
@Configuration
@EnableWebSecurity
// prePostEnabled enables use of @PreAuthorize and @PostAuthorize; securedEnabled allows use of @Secured
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

	@Autowired
	DataSource dataSource;
	
	// filterChain configures security filter chain, which defines how HTTP requests are processed by Spring Security
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// disable Cross-Site Request Forgery protection
		log.info("SecurityFilterChain called");
		
		http.csrf().disable();
		
		// configure login settings: specifying login page, success handler, and failure URL
		http.formLogin()
			.loginPage("/login")
			.successHandler(createAuthenticationSuccessHandler())
			.failureUrl("/account/loginFail");
		
		// configure logout settings: logout URL, success URL, delete cookies upon logout (for auto-login)
		http.logout()
			.logoutUrl("/account/logout")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			.deleteCookies("remember-me", "JSESSION_ID");
		
		// set validity period of remember-me (24 hours), specifying key and token repository
		http.rememberMe()
			.key("common")
			.tokenRepository(createJDBCRepository())
			.tokenValiditySeconds(60*60*24);
		
		return http.build();
	}
	
	// create instance of CustomLoginSuccessHander to handle successful login authentication
	@Bean
	AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	// create instance of CustomUserDetailsServie to implement UserDetailsService interface
	@Bean
	UserDetailsService createUserDetailsService() {
		return new CustomUserDetailsService();
	}
	
	// create instance of BCryptPasswordEncoder, which encodes passwords
	@Bean
	PasswordEncoder createPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// create persistent token repository to implement remember-me functionality
	private PersistentTokenRepository createJDBCRepository() {
		JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
		repository.setDataSource(dataSource);
		return repository;
	}
	
	// configure authentication manager to use CustomUserDetailsService and password encoder
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(createUserDetailsService()).passwordEncoder(createPasswordEncoder());
	}
}
