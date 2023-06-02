package project.aurora.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import project.aurora.api.utils.GenerateToken;

@Entity
@Table(name = "password_codes")
public class PasswordCode {

	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "accessToken")
	private String accessToken;
	
	@Column(name = "confirmationCode")
	private String confirmationCode;

	public PasswordCode() {
		super();
	}

	public PasswordCode(String email, String accessToken) {
		super();
		this.email = email;
		this.accessToken = accessToken;
		this.confirmationCode = GenerateToken.generatePasswordResetCode();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}
	
}
