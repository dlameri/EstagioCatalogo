package com.ideaiselectronics.catalogo.util;

import javax.servlet.http.Cookie;

public class CookieUtil {
	
	public static Cookie getCookieByName( Cookie[] cookies, String name ) {
		if( cookies != null ){
			for (int i = 0; i < cookies.length; i++) {
				if( cookies[i].getName().equals( name ) ) {
					return cookies[i];
				}
			}
		}
		return null;
	}

}
