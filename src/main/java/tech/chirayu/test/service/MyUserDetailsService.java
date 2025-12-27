package tech.chirayu.test.service;

import java.security.PrivateKey;
import java.util.Optional;

import javax.print.event.PrintJobAttributeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tech.chirayu.test.entity.AppUser;
import tech.chirayu.test.repository.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> op=userRepository.findByUsername(username);
		// here this is entity class. 
		AppUser appUser=null;
		if(op.isPresent()) {
			appUser=op.get();
		}else {
			throw new UsernameNotFoundException("User not Found..");
		}
		
		UserDetails userDetails = User
		.builder()
		.username(appUser.getUsername())
		.password(appUser.getPassword())
		.roles(appUser.getRole().replace("ROLE_", ""))
		.build();
		return userDetails;

	}

}
