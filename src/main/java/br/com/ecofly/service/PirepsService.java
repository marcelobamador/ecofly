package br.com.ecofly.service;

import java.text.ParseException;
import java.util.List;

import br.com.ecofly.dto.PirepsDTO;
import br.com.ecofly.model.PirepsEntity;

public interface PirepsService {

	List<PirepsDTO> listPiperps();
	
	List<PirepsEntity> listPirepsToday() throws ParseException;
	
	PirepsEntity updatePirepToday(PirepsEntity pirep);
}
