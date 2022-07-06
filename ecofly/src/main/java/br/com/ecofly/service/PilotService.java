package br.com.ecofly.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

import br.com.ecofly.model.PilotEntity;

public interface PilotService {

	Optional<PilotEntity> getPilot(Integer id);
	
}
