package br.com.ecofly.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phpvms_groups")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
@NoArgsConstructor
public class GroupsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "groupid", unique = true, nullable = false)
	private Integer groupId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "permissions")
	private String permissions;
	
	@Column(name = "core")
	private Integer core;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="phpvms_groupmembers", joinColumns=
    {@JoinColumn(name="groupid")}, inverseJoinColumns=
      {@JoinColumn(name="pilotid")})
	Set<PilotEntity> accessPilots;

}
