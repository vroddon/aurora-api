package project.aurora.api.entity;

public class PasswordConfirmationCode {
	
	private String password;
	
	private String confirmationCode;

	public PasswordConfirmationCode() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

}
