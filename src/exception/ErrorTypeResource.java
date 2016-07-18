package exception;

/**
 * @author ilya shusterman
 *
 */
public enum ErrorTypeResource {
USERNAME_PASSWORD_DOES_NOT_MATCH(1,"Username and password does not match!"),
UNAUTHORIZED_REQUEST(2,"The request you are making is not authorized");



	private final int code;
	private final String description;

	private ErrorTypeResource(int code, String description) {
		    this.code = code;
		    this.description = description;
		  }

	public String getDescription() {
		return description;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return code + ": " + description;
	}
}