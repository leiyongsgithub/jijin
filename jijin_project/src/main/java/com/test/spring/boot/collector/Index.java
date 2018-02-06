package com.test.spring.boot.collector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
	
	@RequestMapping("/login")
	 public String index() {
	    return "forward:/index.html";
	 }
}
