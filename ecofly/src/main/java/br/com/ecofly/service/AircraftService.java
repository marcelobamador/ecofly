package br.com.ecofly.service;

import java.util.Optional;

import br.com.ecofly.model.AircraftEntity;

public interface AircraftService {
	long getCountAircraft();
	
	Optional<AircraftEntity> getAircraftById(Integer id);
}
