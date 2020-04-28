package com.example.springboot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
//		System.out.println("start");
//	    SecurityContext securityContext = SecurityContextHolder.getContext();
//		System.out.println("securityContext");
//	    LoginPrincipal loginPrincipal = (LoginPrincipal) securityContext.getAuthentication().getPrincipal();
//		System.out.println("loginPrincipal");
		
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formattedDate=dateFormat.format(date);

		System.out.println(formattedDate);
		System.out.println(loginPrincipal.getUsername());
		return "Greetings from Spring Boot!";
	}

		@RequestMapping("/hello")
		public String hello() {
			Date date=new Date();
			DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String formattedDate=dateFormat.format(date);

			System.out.println(formattedDate);
			throw new IllegalStateException("Something is wrong");
		}

}
