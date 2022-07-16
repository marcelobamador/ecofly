package br.com.ecofly.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ecofly.model.PilotEntity;

public interface PilotRepository extends JpaRepository<PilotEntity, Integer>{
	
	PilotEntity findByEmail(String email);
	
	Optional<PilotEntity> findByUserName(String userName);
	
	long count();
}
