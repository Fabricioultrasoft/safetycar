package br.com.dimag.safetycar.util;

public class FormatUtil {

	public static String formatDouble(double d){
		String string = String.valueOf(d);
		
		return string.replace(".", ",");
	}
}
