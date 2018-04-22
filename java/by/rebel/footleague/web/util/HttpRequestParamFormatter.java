package by.rebel.footleague.web.util;

/**
 * @author Vydra_Sergei
 * HttpRequestParamFormatter class replaces from String to Integer. 
 */
public class HttpRequestParamFormatter {

	private HttpRequestParamFormatter() {
	}

	public static int formatString(String param) {
		return Integer.parseInt(param);
	}
}
