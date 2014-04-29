package com.ideaiselectronics.catalogo.spring.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.ideaiselectronics.catalogo.spring.service.interfaces.CustomerServiceBehavior;

@Service
public class CustomerService implements CustomerServiceBehavior {
	
	private final String CUSTOMER_CHECKOUT = "http://ideaiselectronics.com:9082/Checkout/customer/";

	@Override
	public void redirectToCheckoutRegister( HttpServletResponse response ) throws IOException {
		response.sendRedirect( CUSTOMER_CHECKOUT + "new" );
	}
	
	@Override
	public void redirectToCheckoutDetails(HttpServletResponse response) throws IOException {
		response.sendRedirect( CUSTOMER_CHECKOUT + "/customerDetails" );
	}

	@Override
	public void redirectToCheckoutLogin( HttpServletResponse response ) throws IOException {
		response.sendRedirect( CUSTOMER_CHECKOUT + "authenticate/loginForm" );
	}

	@Override
	public void redirectToCheckoutLogout(HttpServletResponse response) throws IOException {
		response.sendRedirect( CUSTOMER_CHECKOUT + "authenticate/logout" );		
	}

}
