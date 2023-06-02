package project.aurora.api.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "demo_sites")
@JsonPropertyOrder({ "id", "city", "country" })
public class DemoSite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "city")
	private String city;
	
//	@JsonIgnore
	@Column(name = "country")
	private String country;

	public DemoSite() {
		
	}

	public DemoSite(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Map<String, Object> toJsonMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("id", this.id);
		map.put("city", this.city);
		map.put("country", this.country);
		return map;
	}

}
