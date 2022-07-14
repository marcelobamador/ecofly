package br.com.ecofly.service.impl;

import org.springframework.stereotype.Service;

import br.com.ecofly.repository.AircraftRepository;
import br.com.ecofly.service.AircraftService;

@Service
public class AircraftServiceImpl implements AircraftService {
	
	AircraftRepository aircraftRepository;
	
	public AircraftServiceImpl (AircraftRepository aircraftRepository) {
		this.aircraftRepository = aircraftRepository;
	}

	@Override
	public long getCountAircraft() {
		return this.aircraftRepository.count();
	}

}
