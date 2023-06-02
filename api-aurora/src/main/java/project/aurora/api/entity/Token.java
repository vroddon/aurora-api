package project.aurora.api.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import project.aurora.api.utils.GenerateToken;

@Entity
@Table(name = "tokens")
public class Token {
	
	@Id	
	@JsonIgnore
	private Long id;
	
	@Column(name = "email")
	@JsonIgnore
	private String email;
	
	@Column(name = "accessToken")
	private String accessToken;
	
	@Column(name = "refreshToken")
	private String refreshToken;
	
	public Token() {
		
	}

	public Token(Long id, String email) {
		super();
		this.id = id;
		this.email = email;
		this.accessToken = GenerateToken.generateNewToken();
		this.refreshToken = GenerateToken.generateNewToken();
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	public Map<String, Object> toJsonMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("accessToken", this.accessToken);
		map.put("refreshToken", this.refreshToken);
		return map;
	}

}
