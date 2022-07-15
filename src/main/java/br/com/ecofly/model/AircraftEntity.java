package br.com.ecofly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name = "phpvms_aircraft")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AircraftEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "icao")
	private String icao;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "registration")
	private String registration;
	
	@Column(name = "downloadlink")
	private String downloadLink;
	
	@Column(name = "imagelink")
	private String imageLink;
	
	@Column(name = "range")
	private String range;
	
	@Column(name = "weight")
	private String weight;
	
	@Column(name = "cruise")
	private String cruise;
	
	@Column(name = "maxpax")
	private float maxPax;
	
	@Column(name = "maxcargo")
	private float maxCargo;
	
	@Column(name = "minrank")
	private Integer minRank;
	
	@Column(name = "ranklevel")
	private Integer rankLevel;
	
	@Column(name = "enabled")
	private Integer enabled;
	
}
