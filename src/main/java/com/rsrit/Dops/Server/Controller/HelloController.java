package com.rsrit.Dops.Server.Controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

	@RequestMapping("/hello")
	public String hello(HttpServletRequest request) {
		System.out.println("Hello from Api");
		//System.out.println(request.getParameter("JsessionId"));
	    System.out.println(request.getCookies()[0].getValue());
		return "Hello From Api";
	}
	
}