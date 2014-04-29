package com.ideaiselectronics.catalogo.spring.service.interfaces;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public interface CustomerServiceBehavior {
	
	public void redirectToCheckoutRegister(HttpServletResponse response) throws IOException;
	
	public void redirectToCheckoutDetails(HttpServletResponse response) throws IOException;
	
	public void redirectToCheckoutLogin(HttpServletResponse response) throws IOException;
	
	public void redirectToCheckoutLogout(HttpServletResponse response) throws IOException;

}
