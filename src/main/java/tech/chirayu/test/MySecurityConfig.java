package tech.chirayu.test;

import java.nio.file.attribute.UserDefinedFileAttributeView;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import net.bytebuddy.build.Plugin.Engine.Source.InMemory;

@Configuration 
public class MySecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/test/admin").hasRole("ADMIN")
		.antMatchers("/test/member").hasRole("MEMBER")
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/test/mylogin")
		.loginProcessingUrl("/dologin")
		.usernameParameter("user")
		.passwordParameter("pass")
		
		
		
		
		;
		
		DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
		return defaultSecurityFilterChain;

	}
	
	@Bean
	InMemoryUserDetailsManager inMemory() {
		
		UserDetails adminDetails = org.springframework.security.core.userdetails.User.builder()
		.username("admin")
		.password(passwordEncoder().encode("admin123"))
		.roles("ADMIN")
		.build();
		
		
		UserDetails memberDetails = org.springframework.security.core.userdetails.User.builder()
		.username("member")
		.password(passwordEncoder().encode("member123"))
		.roles("MEMBER")
		.build();
		
		return new InMemoryUserDetailsManager(adminDetails,memberDetails);
		
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
