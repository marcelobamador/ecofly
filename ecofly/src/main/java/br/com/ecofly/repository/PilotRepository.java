package br.com.ecofly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ecofly.model.PilotEntity;

@Repository
public interface PilotRepository extends JpaRepository<PilotEntity, Integer>{
	
}
