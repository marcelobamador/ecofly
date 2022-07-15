package br.com.ecofly.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ecofly.model.PilotEntity;
import br.com.ecofly.repository.PilotRepository;
import br.com.ecofly.service.PilotService;

@Service
public class PilotServiceImpl implements PilotService {

	PilotRepository pilotRepository;

	public PilotServiceImpl(PilotRepository pilotRepository) {
		this.pilotRepository = pilotRepository;
	}

	@Override
	public Optional<PilotEntity> getPilot(Integer id) {
		return this.pilotRepository.findById(id);
	}

	@Override
	public long getCountPilots() {
		return this.pilotRepository.count();
	}
}
