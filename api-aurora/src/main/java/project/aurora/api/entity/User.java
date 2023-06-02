package project.aurora.api.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "yearOfBirth")
	private int yearOfBirth;
	
	@Column(name = "gender")
	private String gender;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Site> sites;
	
	public User() {
		
	}

	public User(String email, String firstName, String lastName, String password, int yearOfBirth, String gender) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.yearOfBirth = yearOfBirth;
		this.gender = gender;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
	
	public void addSite(Site site) {
		this.sites.add(site);
	}
	
	public void removeSite(Site site) {
		if (this.sites.contains(site))
			this.sites.remove(site);
	}
	
	public Map<String, Object> toJsonMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("id", this.id);
		map.put("email", this.email);
		map.put("firstName", this.firstName);
		map.put("lastName", this.lastName);
		map.put("yearOfBirth", this.yearOfBirth);
		map.put("gender", this.gender);
		List<Map<String, Object>> sites = new ArrayList<Map<String,Object>>();
		for(Site site:this.sites) {
			sites.add(site.toJsonMap());
		}
		map.put("sites", sites);
		return map;
	}
}
