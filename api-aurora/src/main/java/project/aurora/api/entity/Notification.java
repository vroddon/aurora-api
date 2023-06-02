package project.aurora.api.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notifications")
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "frequency")
	private String frequency;
	
	@Column(name = "frequencyValue")
	private String frequencyValue;
	
	public Notification() {
		
	}

	public Notification(String type, String frequency, String frequencyValue) {
		super();
		this.type = type;
		this.frequency = frequency;
		this.frequencyValue = frequencyValue;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getFrequencyValue() {
		return frequencyValue;
	}

	public void setFrequencyValue(String frequencyValue) {
		this.frequencyValue = frequencyValue;
	}

	public Long getId() {
		return id;
	}

	public String getType() {
		return type;
	}
	
	public Map<String, Object> toJsonMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("id", this.id);
		map.put("type", this.type);
		map.put("frequency", this.frequency);
		map.put("frequencyValue", this.frequencyValue);
		return map;
	}

}
