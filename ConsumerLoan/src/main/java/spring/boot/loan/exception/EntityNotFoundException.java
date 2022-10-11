package spring.boot.loan.exception;

public class EntityNotFoundException extends Exception {

	
	private String message;
	
	public EntityNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public EntityNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}

