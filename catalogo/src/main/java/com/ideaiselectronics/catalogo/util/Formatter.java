package com.ideaiselectronics.catalogo.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Formatter {
	
	public static String valueFormater(BigDecimal value) {
	    Locale Local = new Locale("pt", "BR");
	    DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Local));
	    return df.format(value);
	}

}
