package project.aurora.api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.HashMap;
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
@Table(name = "household_data")
public class HouseholdData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "userId")
	private Long userId;
	
	@Column(name = "countryId")
	private Long countryId;
	
	@Column(name = "siteId")
	private Long siteId;
	
	@Column(name = "heatingSourceId")
	private Long heatingSourceId;
	
	@Column(name = "numberOfPersons")
    private int numberOfPersons;
	
	@CreatedDate
	@Column(name = "created", nullable = false, updatable = false)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime created;
	
	@LastModifiedDate 
	@Column(name = "modified")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modified;
	
	@Column(name = "initialDate")
    private LocalDate initialDate;
	
	@Column(name = "finalDate")
    private LocalDate finalDate;
	
	@Column(name = "numberOfDays")
    private int numberOfDays;
	
	@Column(name="electricityConsumption")
	private float electricityConsumption;
	
	@Column(name="thermalConsumption")
	private float thermalConsumption;
	
	@Column(name="electricityConsumptionPerCapita")
	private float electricityConsumptionPerCapita;
	
	@Column(name="thermalConsumptionPerCapita")
	private float thermalConsumptionPerCapita;
	
	@Column(name="emissionsElectricityConsumption")
	private float emissionsElectricityConsumption;
	
	@Column(name="emissionsThermalConsumption")
	private float emissionsThermalConsumption;
	
	public HouseholdData() {
		
	}

	public HouseholdData(Long userId, Long countryId, Long heatingSourceId, Long siteId, int numberOfPersons, LocalDate initialDate,
			LocalDate finalDate, float electricityConsumption, float thermalConsumption) {
		super();
		this.userId = userId;
		this.countryId = countryId;
		this.heatingSourceId = heatingSourceId;
		this.siteId = siteId;
		this.numberOfPersons = numberOfPersons;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.electricityConsumption = electricityConsumption;
		this.thermalConsumption = thermalConsumption;
		this.created = LocalDateTime.now();
		this.numberOfDays = Period.between(initialDate, finalDate).getDays() + 1;
		this.electricityConsumptionPerCapita = electricityConsumption / numberOfPersons;
		this.thermalConsumptionPerCapita = thermalConsumption / numberOfPersons;
		this.emissionsElectricityConsumption = this.electricityConsumptionPerCapita * GeneralData.electricityEFMap.get(countryId);
		this.emissionsThermalConsumption = this.thermalConsumptionPerCapita * GeneralData.thermalEFMap.get(heatingSourceId);
	}
	
	public void updateConsumptionValues() {
		this.modified = LocalDateTime.now();
		this.numberOfDays = Period.between(this.initialDate, this.finalDate).getDays() + 1;
		this.electricityConsumptionPerCapita = this.electricityConsumption / this.numberOfPersons;
		this.thermalConsumptionPerCapita = this.thermalConsumption / this.numberOfPersons;
		this.emissionsElectricityConsumption = this.electricityConsumptionPerCapita * GeneralData.electricityEFMap.get(countryId);
		this.emissionsThermalConsumption = this.thermalConsumptionPerCapita * GeneralData.thermalEFMap.get(heatingSourceId);
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getHeatingSourceId() {
		return heatingSourceId;
	}

	public void setHeatingSourceId(Long heatingSourceId) {
		this.heatingSourceId = heatingSourceId;
	}
	
	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public int getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	public LocalDate getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(LocalDate initialDate) {
		this.initialDate = initialDate;
	}

	public LocalDate getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}

	public float getElectricityConsumption() {
		return electricityConsumption;
	}

	public void setElectricityConsumption(float electricityConsumption) {
		this.electricityConsumption = electricityConsumption;
	}

	public float getThermalConsumption() {
		return thermalConsumption;
	}

	public void setThermalConsumption(float thermalConsumption) {
		this.thermalConsumption = thermalConsumption;
	}

	public Long getUserId() {
		return userId;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public float getElectricityConsumptionPerCapita() {
		return electricityConsumptionPerCapita;
	}

	public float getThermalConsumptionPerCapita() {
		return thermalConsumptionPerCapita;
	}

	public float getEmissionsElectricityConsumption() {
		return emissionsElectricityConsumption;
	}

	public float getEmissionsThermalConsumption() {
		return emissionsThermalConsumption;
	}
	
	public Map<String, Object> toJsonMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("id", this.id);
		map.put("heatingSourceId", this.heatingSourceId);
		map.put("siteId", this.siteId);
		map.put("numberOfPersons", this.numberOfPersons);
		map.put("initialDate", this.initialDate.toString());
		map.put("finalDate", this.finalDate.toString());
		map.put("electricityConsumption", this.electricityConsumption);
		map.put("thermalConsumption", this.thermalConsumption);
		map.put("electricityConsumptionPerCapita", this.electricityConsumptionPerCapita);
		map.put("thermalConsumptionPerCapita", this.thermalConsumptionPerCapita);
		map.put("emissionsElectricityConsumption", this.emissionsElectricityConsumption);
		map.put("emissionsThermalConsumption", this.emissionsThermalConsumption);
		return map;
	}
	
}
