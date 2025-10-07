package com.mx.PadreHijo.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfigPadre {
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // rutas públicas
                        .requestMatchers("/api/padre/listar").permitAll()
                        .requestMatchers("/api/hijo/listar").permitAll()
                        
                        // rutas cor permisos Padre
                        .requestMatchers("/api/padre/guardar").hasAuthority("CREATE")
                        .requestMatchers("/api/padre/editar").hasAuthority("UPDATE")
                        .requestMatchers("/api/padre/eliminar").hasAuthority("DELETE")
                        .requestMatchers("/api/padre/buscar/**").hasAuthority("READ")
                        
                     // Rutas con permisos Hijo
                        .requestMatchers("/api/hijo/guardar").hasAuthority("CREATE")
                        .requestMatchers("/api/hijo/editar").hasAuthority("UPDATE")
                        .requestMatchers("/api/hijo/eliminar").hasAuthority("DELETE")
                        .requestMatchers("/api/hijo/buscar/**").hasAuthority("READ")
                        
                        // cualquier otra ruta autenticada
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    @Primary
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
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
        List<UserDetails> users = new ArrayList<>();

        users.add(User.withUsername("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .authorities("CREATE", "READ", "UPDATE")
                .build());

        users.add(User.withUsername("user")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .authorities("READ")
                .build());

        users.add(User.withUsername("invited")
                .password(passwordEncoder().encode("1234"))
                .roles("INVITED")
                .authorities("READ")
                .build());

        users.add(User.withUsername("developer")
                .password(passwordEncoder().encode("1234"))
                .roles("DEVELOPER")
                .authorities("CREATE", "READ", "UPDATE", "DELETE")
                .build());

        return new InMemoryUserDetailsManager(users);

   }
}
