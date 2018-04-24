package by.rebel.footleague.web.util;

/**
 * @author Vydra_Sergei
 * ValidateNullParamException class is own exception class.
 */
public class ValidateNullParamException extends RuntimeException {

	private static final long serialVersionUID = 4460204887405834735L;

	public ValidateNullParamException() {
		super();
	}

	public ValidateNullParamException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateNullParamException(String message) {
		super(message);
	}

	public ValidateNullParamException(Throwable cause) {
		super(cause);
	}
	
}
