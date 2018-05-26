package offtocol;


import offtocol.domain.service.user.ReservationUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	ReservationUserDetailsService userDetailsService;


	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	protected void configure(HttpSecurity http)
		throws Exception {

		http
			.authorizeRequests()
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/owner").hasRole("OWNER")
				.antMatchers("/", "/registerForm", "/css/**").permitAll()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/loginForm")
				.loginProcessingUrl("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl("/houses", true)
				.failureUrl("/loginForm?error=true").permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/");
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth)
		throws Exception {

		auth.userDetailsService(userDetailsService)
			.passwordEncoder(encoder());

	}


}
