package tech.chirayu.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class MyController {

	@GetMapping("/index")
	public String index() {
		return "index";
	} 

	@GetMapping("/member")
	public String member() {
		return "member";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/mylogin")
	public String loginpage() {
		return "login";
	}
	
}
