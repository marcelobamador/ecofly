package br.com.ecofly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecofly.model.AircraftEntity;

public interface AircraftRepository extends JpaRepository<AircraftEntity, Integer>{
	
	long count();
	
}
