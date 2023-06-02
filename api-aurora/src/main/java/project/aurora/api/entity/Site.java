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
@Table(name = "sites")
@JsonPropertyOrder({ "id", "city", "country", "primaryHouse" })
public class Site {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "primaryHouse")
	private boolean primaryHouse;

	public Site() {
		
	}

	public Site(String city, String country, boolean primaryHouse) {
		super();
		this.city = city;
		this.country = country;
		this.primaryHouse = primaryHouse;
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

	public boolean isPrimaryHouse() {
		return primaryHouse;
	}

	public void setPrimaryHouse(boolean primaryHouse) {
		this.primaryHouse = primaryHouse;
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
		map.put("primaryHouse", this.primaryHouse);
		return map;
	}

}
