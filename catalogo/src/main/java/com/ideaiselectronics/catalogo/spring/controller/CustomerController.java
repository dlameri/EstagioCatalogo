package com.ideaiselectronics.catalogo.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ideaiselectronics.catalogo.spring.service.interfaces.CustomerServiceBehavior;

@Controller("customerCon")
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired @Qualifier("customerService")
	private CustomerServiceBehavior customerService;
	
	@RequestMapping( value = "/register", method = RequestMethod.GET )
	public void redirectToCheckoutRegister( HttpServletResponse response ) {
		try {
			customerService.redirectToCheckoutRegister( response );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping( value = "/authenticate/loginForm", method = RequestMethod.GET )
	public void redirectToCheckoutLogin( HttpServletResponse response ) {
		try {
			customerService.redirectToCheckoutLogin( response );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping( value = "/customerDetails", method = RequestMethod.GET )
	public void redirectToCheckoutDetails( HttpServletResponse response ) {
		try {
			customerService.redirectToCheckoutDetails( response );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping( value = "/authenticate/logout", method = RequestMethod.GET )
	public void redirectToCheckoutLogout( HttpServletResponse response ) {
		try {
			customerService.redirectToCheckoutLogin( response );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
