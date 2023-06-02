package project.aurora.api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import project.aurora.api.data.GeneralData;

@Entity
@Table(name = "transport_data")
public class TransportData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "userId")
	private Long userId;
	
	@Column(name = "countryId")
	private Long countryId;
	
	@CreatedDate
	@Column(name = "created", nullable = false, updatable = false)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime created;
	
	@LastModifiedDate 
	@Column(name = "modified")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modified;
	
	@Column(name = "dateOfTravel")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfTravel;
	
	@Column(name="typeOfVehicleId")
	private Long typeOfVehicleId;
	
	@Column(name="levelOfOccupancyId")
	private Long levelOfOccupancyId;
	
	@Column(name="distanceTravelled")
	private float distanceTravelled;
	
	@Column(name="energyConsumption")
	private float energyConsumption;
	
	@Column(name="emissions")
	private float emissions;
	
	public TransportData() {
		
	}
	
	public TransportData(Long userId, Long countryId, LocalDate dateOfTravel, Long typeOfVehicleId, Long levelOfOccupancyId, float distanceTravelled) {
		super();
		this.userId = userId;
		this.countryId = countryId;
		this.dateOfTravel = dateOfTravel;
		this.typeOfVehicleId = typeOfVehicleId;
		this.levelOfOccupancyId = levelOfOccupancyId;
		this.distanceTravelled = distanceTravelled;
		this.created = LocalDateTime.now();
		float energyValue = GeneralData.generalEnergyMap.get(countryId).get(typeOfVehicleId).get(levelOfOccupancyId);
		this.energyConsumption = energyValue * distanceTravelled;
		float emissionsValue = GeneralData.generalEmissionsMap.get(countryId).get(typeOfVehicleId).get(levelOfOccupancyId);
		this.emissions = emissionsValue * distanceTravelled;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = LocalDateTime.now();
	}

	public LocalDate getDateOfTravel() {
		return dateOfTravel;
	}

	public void setDateOfTravel(LocalDate dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}

	public Long getTypeOfVehicleId() {
		return typeOfVehicleId;
	}

	public void setTypeOfVehicleId(Long typeOfVehicleId) {
		this.typeOfVehicleId = typeOfVehicleId;
	}

	public Long getLevelOfOccupancyId() {
		return levelOfOccupancyId;
	}

	public void setLevelOfOccupancyId(Long levelOfOccupancyId) {
		this.levelOfOccupancyId = levelOfOccupancyId;
	}

	public float getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(float distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}

	public float getEnergyConsumption() {
		return energyConsumption;
	}

	public void setEnergyConsumption(float energyConsumption) {
		this.energyConsumption = energyConsumption;
	}

	public float getEmissions() {
		return emissions;
	}

	public void setEmissions(float emissions) {
		this.emissions = emissions;
	}

	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	
	public void updateEnergyEmissionsValues() {
		float energyValue = GeneralData.generalEnergyMap.get(this.countryId).get(this.typeOfVehicleId).get(this.levelOfOccupancyId);
		this.energyConsumption = energyValue * distanceTravelled;
		float emissionsValue = GeneralData.generalEmissionsMap.get(this.countryId).get(this.typeOfVehicleId).get(this.levelOfOccupancyId);
		this.emissions = emissionsValue * distanceTravelled;
	}

//	public String toJsonString() {
//		return "{\n" + 
//				"  \"id\": " + this.id + ",\n" + 
//				"  \"date\": \"" + this.dateOfTravel + "\",\n" +
//				"  \"typeOfVehicle\": " + this.typeOfVehicleId + ",\n" +
//				"  \"levelOfOccupancy\": " + this.levelOfOccupancyId + ",\n" +
//				"  \"distanceTravelled\": " + this.distanceTravelled + ",\n" +
//				"  \"energyConsumption\": " + this.energyConsumption + ",\n" +
//				"  \"emissions\": " + this.emissions + "\n" +
//				"}";
//	}
	
	public Map<String, Object> toJsonMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("id", this.id);
		map.put("date", this.dateOfTravel.toString());
		map.put("typeOfVehicle", this.typeOfVehicleId);
		map.put("levelOfOccupancy", this.levelOfOccupancyId);
		map.put("distanceTravelled", this.distanceTravelled);
		map.put("energyConsumption", this.energyConsumption);
		map.put("emissions", this.emissions);
		return map;
	}

}
