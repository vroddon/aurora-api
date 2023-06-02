package project.aurora.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import project.aurora.api.utils.GenerateToken;

@Entity
@Table(name = "email_codes")
public class EmailCode {
	
	@Id
	@Column(name = "accessToken")
	private String accessToken;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "confirmationCode")
	private String confirmationCode;
	
	public EmailCode() {
	
	}
	
	public EmailCode(String accessToken, String email) {
		super();
		this.accessToken = accessToken;
		this.email = email;
		this.confirmationCode = GenerateToken.generateEmailConfirmationCode();		
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

}
