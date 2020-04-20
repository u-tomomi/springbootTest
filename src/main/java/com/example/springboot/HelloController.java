package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formattedDate=dateFormat.format(date);

		System.out.println(formattedDate);
		return "Greetings from Spring Boot!";
	}

}
