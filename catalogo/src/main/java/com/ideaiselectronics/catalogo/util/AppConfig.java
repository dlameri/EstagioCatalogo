package com.ideaiselectronics.catalogo.util;

import java.util.ResourceBundle;

public class AppConfig {

	private static ResourceBundle config = ResourceBundle.getBundle("catalog-config");

	public static String getUrlProductDefaultImage() {
		return config.getString("url.default.image");
	}
}