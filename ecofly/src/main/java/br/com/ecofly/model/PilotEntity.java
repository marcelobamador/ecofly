package br.com.ecofly.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "phpvms_pilots")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PilotEntity {

	@Id
	@Column(name = "pilotid")
	private int pilotId;

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

	public int getPilotId() {
		return pilotId;
	}

	public void setPilotId(int pilotId) {
		this.pilotId = pilotId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHub() {
		return hub;
	}

	public void setHub(String hub) {
		this.hub = hub;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getBgImage() {
		return bgImage;
	}

	public void setBgImage(String bgImage) {
		this.bgImage = bgImage;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getTotalFlights() {
		return totalFlights;
	}

	public void setTotalFlights(int totalFlights) {
		this.totalFlights = totalFlights;
	}

	public float getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(float totalHours) {
		this.totalHours = totalHours;
	}

	public float getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(float totalPay) {
		this.totalPay = totalPay;
	}

	public float getPayAdjust() {
		return payAdjust;
	}

	public void setPayAdjust(float payAdjust) {
		this.payAdjust = payAdjust;
	}

	public float getTransferHours() {
		return transferHours;
	}

	public void setTransferHours(float transferHours) {
		this.transferHours = transferHours;
	}

	public int getRankId() {
		return rankId;
	}

	public void setRankId(int rankId) {
		this.rankId = rankId;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getRankLevel() {
		return rankLevel;
	}

	public void setRankLevel(int rankLevel) {
		this.rankLevel = rankLevel;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}

	public int getRetired() {
		return retired;
	}

	public void setRetired(int retired) {
		this.retired = retired;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getLastPirep() {
		return lastPirep;
	}

	public void setLastPirep(Date lastPirep) {
		this.lastPirep = lastPirep;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "PilotEntity [pilotId=" + pilotId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", code=" + code + ", location=" + location + ", hub=" + hub + ", password=" + password
				+ ", salt=" + salt + ", bgImage=" + bgImage + ", lastLogin=" + lastLogin + ", totalFlights="
				+ totalFlights + ", totalHours=" + totalHours + ", totalPay=" + totalPay + ", payAdjust=" + payAdjust
				+ ", transferHours=" + transferHours + ", rankId=" + rankId + ", rank=" + rank + ", rankLevel="
				+ rankLevel + ", confirmed=" + confirmed + ", retired=" + retired + ", joinDate=" + joinDate
				+ ", lastPirep=" + lastPirep + ", lastIp=" + lastIp + ", comment=" + comment + "]";
	}

}
