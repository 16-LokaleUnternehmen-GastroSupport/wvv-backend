package me.itson.backend.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AuthenticationConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
				.and()
			.authorizeRequests()
				.antMatchers("/", "/account/**", "/swagger-ui/**", "/swagger-ui.html", "/v3/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.csrf().disable();
	}

	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder);
		return authProvider;
	}
}
