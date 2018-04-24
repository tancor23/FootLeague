package by.rebel.footleague.web.util;

/**
 * @author Vydra_Sergei
 * HttpRequestParamValidator class checked the received parameter to null.
 */
public class HttpRequestParamValidator {

	private HttpRequestParamValidator() {}

	public static void validateRequestParamNotNull(String ... str) {
		for (String s: str) {
			if(s==null) {
				throw new ValidateNullParamException();
			}
		}
	}
}
