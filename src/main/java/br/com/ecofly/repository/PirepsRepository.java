package br.com.ecofly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ecofly.model.PirepsEntity;

public interface PirepsRepository extends JpaRepository<PirepsEntity, Integer> {

	@Query(value = "SELECT * FROM phpvms_pireps pirep ORDER BY pirep.submitdate DESC LIMIT 10", nativeQuery = true)
	List<PirepsEntity> findLastPireps();
}
