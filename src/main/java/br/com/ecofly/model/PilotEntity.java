package br.com.ecofly.model;



import java.util.Date;

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
@Table(name = "phpvms_pilots")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PilotEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pilotid", unique = true, nullable = false)
	private Integer pilotId;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "code")
	private String code;

	@Column(name = "location")
	private String location;

	@Column(name = "hub")
	private String hub;

	@Column(name = "password")
	private String password;

	@Column(name = "salt")
	private String salt;

	@Column(name = "bgimage")
	private String bgImage;

	@Column(name = "lastlogin")
	private Date lastLogin;

	@Column(name = "totalflights")
	private int totalFlights;

	@Column(name = "totalhours")
	private float totalHours;

	@Column(name = "totalpay")
	private float totalPay;

	@Column(name = "payadjust")
	private float payAdjust;

	@Column(name = "transferhours")
	private float transferHours;

	@Column(name = "rankid")
	private int rankId;

	@Column(name = "rank")
	private String rank;

	@Column(name = "ranklevel")
	private int rankLevel;

	@Column(name = "confirmed")
	private int confirmed;

	@Column(name = "retired")
	private int retired;

	@Column(name = "joindate")
	private Date joinDate;

	@Column(name = "lastpirep")
	private Date lastPirep;

	@Column(name = "lastip")
	private String lastIp;

	@Column(name = "comment")
	private String comment;
	
	@Column(name = "username")
	private String userName;

}
