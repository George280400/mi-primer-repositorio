package com.mx.SpringSecurity.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // esta clase es una fuente de configuracion y debe definir beans
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		return httpSecurity
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						//rutas publicas
						.requestMatchers("/auth/public").permitAll()
						//rutas privadas con acceso de rol
				        .requestMatchers("/auth/rol").hasRole("ADMIN")
				        //rutas privadas con un permiso
				        .requestMatchers("/auth/permiso").hasAuthority("READ")
				        //rutas por defecto todas las rutas que no fue especificdo su filtro deben llevar autenticacion
						.anyRequest().authenticated()
						)
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager( HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailService())
				.passwordEncoder(passwordEncoder())
				.and()
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailService() {
		List<UserDetails> userDetailsList = new ArrayList<>();
		userDetailsList.add(User.withUsername("Santiago")
				.password(passwordEncoder().encode("1234"))
				//.roles("ADMIN")
				.authorities("ROLE_ADMIN","READ", "CREATE")
				.build());
		
		userDetailsList.add(User.withUsername("Daniel")
				.password(passwordEncoder().encode("1234"))
				.roles("USER")
				.authorities("READ")
				.build());
		
		return new InMemoryUserDetailsManager(userDetailsList);
	}
	
	
	

}
