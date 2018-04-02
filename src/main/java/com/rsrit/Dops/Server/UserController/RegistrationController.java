package com.rsrit.Dops.Server.UserController;


/**
 * @author gn.teja created on 02/25/2017
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rsrit.Dops.Server.Model.UserModel.DataOps_User;
import com.rsrit.Dops.Server.Service.UserService.IRegistrationService;
import com.rsrit.Dops.Server.Service.UserService.UserStatusService;
import com.rsrit.Dops.Server.Validations.EmailExistsException;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.http.HttpRequest;

@RestController
@RequestMapping("api/user")
public class RegistrationController {
	
	@Autowired
	IRegistrationService registrationService;
	
	
	@PostMapping(value = "/registration")
	public DataOps_User registrationOfUser(@RequestBody DataOps_User userDetails) {
		System.out.println("from the registration method");
		try {
			System.out.println("in registration method");
			return registrationService.registerNewUser(userDetails);
		} catch (EmailExistsException e) {
			System.out.println("email exist expection caught -> register Controller");
			System.out.println(e);
			return null;
		}
	}
	
	@PostMapping("/checkSession")
	@ResponseBody
	public UserStatusService sessionResponse(HttpServletRequest request) { 
		System.out.println("this is from the check session method");
		
		if (request.getCookies()[0].getValue() != null) {
			
			System.out.println(request.getCookies()[0].getValue());
			
			return new UserStatusService(true, "Authorized");
		}
		
		return new UserStatusService(false, "Unauthorized");
	}
	
	@RequestMapping(value = "/loggout")
	public void loogedUser() {
		System.out.println("logout method");
	}
}
