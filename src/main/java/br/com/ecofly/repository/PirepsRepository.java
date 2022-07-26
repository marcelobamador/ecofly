package br.com.ecofly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.ecofly.model.PirepsEntity;

@Transactional
public interface PirepsRepository extends JpaRepository<PirepsEntity, Integer> {

	@Query(value = "SELECT * FROM phpvms_pireps pirep ORDER BY pirep.submitdate DESC LIMIT 10", nativeQuery = true)
	List<PirepsEntity> findLastPireps();
	
	@Query(value = "SELECT * FROM phpvms_pireps pirep WHERE pirep.accepted = 0 AND date(pirep.submitdate) = ?1", nativeQuery = true)
	List<PirepsEntity> findPirepsToday(String date);
	
	@Modifying
	@Query(value = "UPDATE phpvms_pireps SET accepted = 1, modifieddate = CURRENT_TIMESTAMP WHERE pirepid = ?1", nativeQuery = true)
	void updatePirepToday(Integer pirepId);
	
	
}
