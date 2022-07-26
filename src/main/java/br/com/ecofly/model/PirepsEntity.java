package br.com.ecofly.model;


import java.sql.Date;

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
@Table(name = "phpvms_pireps")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PirepsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pirepid", unique = true, nullable = false)
	private Integer pirepId;
	
	@Column(name = "pilotid")
	private Integer pilotId;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "flightnum")
	private String flightNum;
	
	@Column(name = "depicao")
	private String depicao;
	
	@Column(name = "arricao")
	private String arricao;
	
	@Column(name = "route")
	private String route;
	
	@Column(name = "route_details")
	private String routeDetails;
	
	@Column(name = "aircraft")
	private String aircraft;
	
	@Column(name = "flighttime")
	private String flightTime;
	
	@Column(name = "flighttime_stamp")
	private String flighttimeStamp;
	
	@Column(name = "distance")
	private Long distance;
	
	@Column(name = "landingrate")
	private String landingRate;
	
	@Column(name = "submitdate")
	private Date submitDate;
	
	@Column(name = "modifieddate")
	private Date modifiedDate;
	
	@Column(name = "accepted")	
	private Integer accepted;
	
	@Column(name = "log")
	private String log;
	
	@Column(name = "load")
	private Integer load;
	
	@Column(name = "fuelused")
	private Float fuelUsed;
	
	@Column(name = "fuelunitcost")
	private Float fuelUnitCost;
	
	@Column(name = "fuelprice")
	private Float fuelPrice;
	
	@Column(name = "price")
	private Float price;
	
	@Column(name = "flighttype")
	private String flightType;
	
	@Column(name = "gross")
	private Float gross;
	
	@Column(name = "pilotpay")
	private Float pilotPay;
	
	@Column(name = "paytype")
	private Integer payType;
	
	@Column(name = "expenses")
	private Float expenses;
	
	@Column(name = "expenselist")
	private String expenseList;
	
	@Column(name = "revenue")
	private Float revenue;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "exported")
	private Integer exported;
	
	@Column(name = "rawdata")
	private String rawdata;
	
}
