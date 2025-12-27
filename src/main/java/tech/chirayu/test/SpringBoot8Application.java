package tech.chirayu.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import tech.chirayu.test.entity.AppUser;
import tech.chirayu.test.repository.UserRepository;

@SpringBootApplication
public class SpringBoot8Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBoot8Application.class, args);
		UserRepository userRepo = ctx.getBean(UserRepository.class);
		PasswordEncoder encoder = ctx.getBean(PasswordEncoder.class);
		
		// admin and member. 
		
		if(userRepo.findByUsername("admin").isEmpty())
		{
			AppUser appUser = new AppUser();
			appUser.setUsername("admin");
			appUser.setPassword(encoder.encode("admin123"));
			appUser.setRole("ROLE_ADMIN");
			userRepo.save(appUser);
			System.out.println("ADMIN INSERTED.");
			
		}else {
			System.out.println("admin all ready exist");
		}
		
		if(userRepo.findByUsername("member").isEmpty())
		{
			AppUser appUser = new AppUser();
			appUser.setUsername("member");
			appUser.setPassword(encoder.encode("member123"));
			appUser.setRole("ROLE_MEMBER");
			userRepo.save(appUser);
			System.out.println("MEMBER INSERTED.");
			
		}else {
			System.out.println("member all ready exist");
		}
		
	}

}
