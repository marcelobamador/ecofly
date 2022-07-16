package br.com.ecofly.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phpvms_awards")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
@NoArgsConstructor
public class AwardsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "awardid", unique = true, nullable = false)
	private Integer awardId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "descrip")
	private String descrip;
	
	@Column(name = "image")
	private String image;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="phpvms_awardsgranted", joinColumns=
    {@JoinColumn(name="awardid")}, inverseJoinColumns=
      {@JoinColumn(name="pilotid")})
    Set<PilotEntity> likedPilots;

}
